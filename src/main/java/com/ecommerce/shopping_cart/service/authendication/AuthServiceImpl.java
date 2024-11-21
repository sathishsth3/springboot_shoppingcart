package com.ecommerce.shopping_cart.service.authendication;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping_cart.dto.SignupRequestDto;
import com.ecommerce.shopping_cart.dto.UserDto;
import com.ecommerce.shopping_cart.entity.User;
import com.ecommerce.shopping_cart.enums.UserRole;
import com.ecommerce.shopping_cart.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> existingUser = Optional.ofNullable(userRepository.findByEmail(email));
        return existingUser;
    }

    @Override
    public UserDto signupCustomer(SignupRequestDto signupRequestDto) {

        User user = new User();
        user.setUserName(signupRequestDto.getUserName());
        user.setEmail(signupRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        user.setRole(UserRole.CUSTOMER);

        User createdUser = userRepository.save(user);

        UserDto userDto = new UserDto();

        userDto.setId(createdUser.getUserId());
        userDto.setEmail(createdUser.getEmail());
        userDto.setUserName((createdUser.getUserName()));
        userDto.setRole(createdUser.getRole());

        return userDto;

    }

    @Override
    public UserDto signupAdmin(SignupRequestDto signupRequestDto) {

        User user = new User();
        user.setUserName(signupRequestDto.getUserName());
        user.setEmail(signupRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequestDto.getPassword()));
        user.setRole(UserRole.ADMIN);

        User createdUser = userRepository.save(user);

        UserDto userDto = new UserDto();

        userDto.setId(createdUser.getUserId());
        userDto.setEmail(createdUser.getEmail());
        userDto.setUserName((createdUser.getUserName()));
        userDto.setRole(createdUser.getRole());

        return userDto;
        
    }
    
}
