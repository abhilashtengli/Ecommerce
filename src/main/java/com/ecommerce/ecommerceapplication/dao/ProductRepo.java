package com.ecommerce.ecommerceapplication.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerceapplication.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    public Optional<Product> findByProductName(String productName);

}
