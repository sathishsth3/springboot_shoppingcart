package com.ecommerce.shopping_cart.dto;

import com.ecommerce.shopping_cart.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {
    
    private int id;
    private String email;
    private String userName;
    private UserRole role;
    
}
