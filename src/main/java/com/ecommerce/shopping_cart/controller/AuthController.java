package com.ecommerce.shopping_cart.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shopping_cart.dto.AuthRequestDto;
import com.ecommerce.shopping_cart.dto.AuthResDto;
import com.ecommerce.shopping_cart.dto.SignupRequestDto;
import com.ecommerce.shopping_cart.dto.UserDto;
import com.ecommerce.shopping_cart.entity.User;
import com.ecommerce.shopping_cart.service.authendication.AuthServiceImpl;
import com.ecommerce.shopping_cart.utils.JwtUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private AuthServiceImpl authServiceImpl;
    private JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, AuthServiceImpl authServiceImpl,
            JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.authServiceImpl = authServiceImpl;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signup-customer")
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequestDto signupRequestDto) {
        Optional<User> existingUser = authServiceImpl.findUserByEmail(signupRequestDto.getEmail());
        if (existingUser.isPresent()) {
            //return ResponseEntity.badRequest().body("This user is already exists");
            return new ResponseEntity<>("This user already exists", HttpStatus.BAD_REQUEST);
        }
        UserDto userDto = authServiceImpl.signupCustomer(signupRequestDto);
        //return ResponseEntity.ok("User registered successfully");
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/signup-admin")
    public ResponseEntity<?> signupAdmin(@RequestBody SignupRequestDto signupRequestDto) {
        Optional<User> existingUser = authServiceImpl.findUserByEmail(signupRequestDto.getEmail());
        if (existingUser.isPresent()) {
            //return ResponseEntity.badRequest().body("This user is already exists");
            return new ResponseEntity<>("This user already exists", HttpStatus.BAD_REQUEST);
        }
        UserDto userDto = authServiceImpl.signupAdmin(signupRequestDto);
        //return ResponseEntity.ok("User registered successfully");
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> loginUser(@RequestBody AuthRequestDto authRequestDto) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequestDto.getEmail(), authRequestDto.getPassword()));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtUtils.generateToken(userDetails);

            User existingUser = authServiceImpl.findUserByEmail(authRequestDto.getEmail()).get();

            AuthResDto authResDto = new AuthResDto();
            authResDto.setId(existingUser.getUserId());
            authResDto.setToken(jwt);
            authResDto.setRole(existingUser.getRole());
            return ResponseEntity.ok(authResDto);
            
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
        
    }
  
    
}
