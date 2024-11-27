package com.ecommerce.shopping_cart.service.adminProduct;

import java.io.IOException;
import java.util.List;

import com.ecommerce.shopping_cart.dto.ProductDto;

public interface AdminProductService {
    
    ProductDto addProduct(ProductDto productDto) throws IOException;

    List<ProductDto> getAllProducts();
}
