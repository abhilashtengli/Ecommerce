package com.ecommerce.ecommerceapplication.mapper;

import com.ecommerce.ecommerceapplication.dto.OrderDto;
import com.ecommerce.ecommerceapplication.model.Order;

import jakarta.validation.Valid;

public interface OrderMapper {

    Order placeOrder(@Valid OrderDto orderDto);

    OrderDto converToDto(Order orderSaved);
    
}
