package com.ecommerce.shopping_cart.dto;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDto {
    
    private int productId;
    private String productName;
    private BigDecimal price;
    private String description;
    private byte[] byteImage;

    private MultipartFile image;
    private int categoryId;

}
