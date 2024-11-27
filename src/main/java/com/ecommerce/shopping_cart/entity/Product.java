package com.ecommerce.shopping_cart.entity;

import java.math.BigDecimal;

import com.ecommerce.shopping_cart.dto.ProductDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private BigDecimal price;
    @Lob
    private String description;
    @Lob
    private byte[] image;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId", nullable = false)
    private Category category;

    public ProductDto getProductDto() {

        ProductDto productDto = new ProductDto();

        productDto.setProductId(productId);
        productDto.setProductName(productName);
        productDto.setPrice(price);
        productDto.setDescription(description);
        productDto.setByteImage(image);
        productDto.setCategoryId(category.getCategoryId());

        return productDto;
    }

}
