package com.ecommerce.shopping_cart.controller.admin;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shopping_cart.dto.CategoryDto;
import com.ecommerce.shopping_cart.entity.Category;
import com.ecommerce.shopping_cart.service.adminCategory.CategoryServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminCategoryController {

    private CategoryServiceImpl categoryServiceImpl;
    
    public AdminCategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @PostMapping("/create_category")
    public Category saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryServiceImpl.saveCategory(categoryDto);
    }

    @GetMapping("")
    public List<Category> getAllCategories() {
        return categoryServiceImpl.getAllCategories();
    }
}
