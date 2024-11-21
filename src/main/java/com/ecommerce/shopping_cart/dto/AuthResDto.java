package com.ecommerce.shopping_cart.dto;

import com.ecommerce.shopping_cart.enums.UserRole;

import lombok.Data;

@Data
public class AuthResDto {
    
    private int id;
    private String token;
    private UserRole role;

}
