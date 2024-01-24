package com.ecommerce.ecommerceapplication.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.UserRepo;
import com.ecommerce.ecommerceapplication.exceptionClass.UserNotFoundException;
import com.ecommerce.ecommerceapplication.model.User;
import com.ecommerce.ecommerceapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveNewUser(User newUser) {

        return userRepo.save(newUser);

    }

    @Override
    public User getById(Integer id) throws UserNotFoundException {

        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public User updateUser(User user, int id) throws UserNotFoundException {

        Optional<User> userdb = userRepo.findById(id);

        if (userdb.isPresent()) {
            userRepo.save(user);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }

        return user;

    }

}
