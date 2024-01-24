package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.exceptionClass.UserNotFoundException;
import com.ecommerce.ecommerceapplication.model.User;

public interface UserService {

    User saveNewUser(User newUser);

    User getById(Integer id) throws UserNotFoundException;

    User updateUser(User user, int id) throws UserNotFoundException;
    
    
}
