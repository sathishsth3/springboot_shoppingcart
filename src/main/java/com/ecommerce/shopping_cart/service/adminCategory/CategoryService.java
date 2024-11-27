package com.ecommerce.shopping_cart.service.adminCategory;

import java.util.List;

import com.ecommerce.shopping_cart.dto.CategoryDto;
import com.ecommerce.shopping_cart.entity.Category;

public interface CategoryService {
    
    Category saveCategory(CategoryDto categoryDto);

    List<Category> getAllCategories();

}
