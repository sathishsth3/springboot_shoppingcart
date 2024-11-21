package com.ecommerce.shopping_cart.service.authendication;

import java.util.Optional;

import com.ecommerce.shopping_cart.dto.SignupRequestDto;
import com.ecommerce.shopping_cart.dto.UserDto;
import com.ecommerce.shopping_cart.entity.User;

public interface AuthService {

    Optional<User> findUserByEmail(String email);

    UserDto signupCustomer(SignupRequestDto signupRequestDto);

    UserDto signupAdmin(SignupRequestDto signupRequestDto);
    
}
