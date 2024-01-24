package com.ecommerce.ecommerceapplication.mapper;

import com.ecommerce.ecommerceapplication.dto.UserDto;
import com.ecommerce.ecommerceapplication.model.User;

public interface UserMapper {

    User saveUser(UserDto user);

    UserDto convertToUserToUserDto(User savedUser);

    User updateUser(UserDto userDto);


}
