package com.ecommerce.ecommerceapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerceapplication.model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {
    
}
