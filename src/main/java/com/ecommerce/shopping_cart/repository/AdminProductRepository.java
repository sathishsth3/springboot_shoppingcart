package com.ecommerce.shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shopping_cart.entity.Product;

@Repository
public interface AdminProductRepository extends JpaRepository<Product, Integer> {
    
}
