package com.ecommerce.shopping_cart.controller.admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shopping_cart.dto.ProductDto;
import com.ecommerce.shopping_cart.service.adminProduct.AdminProductServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminProductController {
    
    @Autowired
    private AdminProductServiceImpl adminProductServiceImpl;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {

        return new ResponseEntity<>(adminProductServiceImpl.getAllProducts(), HttpStatus.OK);

    }

    @PostMapping("/product")
    public ResponseEntity<ProductDto> addProduct(@ModelAttribute ProductDto productDto) throws IOException {

        return new ResponseEntity<>(adminProductServiceImpl.addProduct(productDto), HttpStatus.OK);
        
    }
}
