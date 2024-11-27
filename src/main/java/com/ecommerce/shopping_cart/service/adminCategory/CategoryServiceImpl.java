package com.ecommerce.shopping_cart.service.adminCategory;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping_cart.dto.CategoryDto;
import com.ecommerce.shopping_cart.entity.Category;
import com.ecommerce.shopping_cart.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        
        Category category = new Category();
        category.setCategoryName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }
    
}
