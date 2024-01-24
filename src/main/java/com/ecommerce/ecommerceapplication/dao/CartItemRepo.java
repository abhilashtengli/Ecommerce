package com.ecommerce.ecommerceapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerceapplication.model.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Integer> {

    List<CartItem> findByUserId(int userId);

    void deleteByUser_Id(int userId);

}
