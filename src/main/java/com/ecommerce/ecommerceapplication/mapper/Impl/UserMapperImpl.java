package com.ecommerce.ecommerceapplication.mapper.Impl;

import org.springframework.stereotype.Component;

import com.ecommerce.ecommerceapplication.dto.UserDto;
import com.ecommerce.ecommerceapplication.mapper.UserMapper;
import com.ecommerce.ecommerceapplication.model.User;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User saveUser(UserDto user) {

        User newUser = new User();

        newUser.setUsername(user.getUsername());
        newUser.setFirstname(user.getFirstname());
        newUser.setEmail(user.getEmail());
        newUser.setLastname(user.getLastname());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());

        return newUser;
    }

    @Override
    public UserDto convertToUserToUserDto(User savedUser) {

        UserDto userDto = new UserDto();

        userDto.setUserId(savedUser.getId());
        userDto.setUsername(savedUser.getUsername());
        userDto.setFirstname(savedUser.getFirstname());
        userDto.setEmail(savedUser.getEmail());
        userDto.setLastname(savedUser.getLastname());
        userDto.setRole(savedUser.getRole());
        userDto.setPassword(savedUser.getPassword());

        return userDto;
    }

    @Override
    public User updateUser(UserDto userDto) {
        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setFirstname(userDto.getFirstname());
        newUser.setEmail(userDto.getEmail());
        newUser.setLastname(userDto.getLastname());
        newUser.setPassword(userDto.getPassword());

        return newUser;
    }

}
