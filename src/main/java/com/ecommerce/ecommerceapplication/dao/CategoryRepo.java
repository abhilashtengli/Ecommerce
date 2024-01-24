package com.ecommerce.ecommerceapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerceapplication.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
