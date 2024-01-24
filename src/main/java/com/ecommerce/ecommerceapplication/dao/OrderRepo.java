package com.ecommerce.ecommerceapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerceapplication.model.Order;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    
}
