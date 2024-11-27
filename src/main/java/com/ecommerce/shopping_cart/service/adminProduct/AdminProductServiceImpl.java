package com.ecommerce.shopping_cart.service.adminProduct;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping_cart.dto.ProductDto;
import com.ecommerce.shopping_cart.entity.Category;
import com.ecommerce.shopping_cart.entity.Product;
import com.ecommerce.shopping_cart.repository.AdminProductRepository;
import com.ecommerce.shopping_cart.repository.CategoryRepository;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    @Autowired
    private AdminProductRepository adminProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDto addProduct(ProductDto productDto) throws IOException {
        
        Product product = new Product();

        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImage(productDto.getImage().getBytes());

        Category category = categoryRepository.findById(productDto.getCategoryId()).get();
        product.setCategory(category);

        return adminProductRepository.save(product).getProductDto();
    }

    @Override
    public List<ProductDto> getAllProducts() {
       
        List<Product> products = adminProductRepository.findAll();
        List<ProductDto> productDtos = products.stream().map(Product::getProductDto).collect(Collectors.toList());
        return productDtos;

    }
    
}
