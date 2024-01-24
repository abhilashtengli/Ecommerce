package com.ecommerce.ecommerceapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerceapplication.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
