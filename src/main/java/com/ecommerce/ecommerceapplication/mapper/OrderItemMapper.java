package com.ecommerce.ecommerceapplication.mapper;

import com.ecommerce.ecommerceapplication.dto.OrderItemDto;
import com.ecommerce.ecommerceapplication.model.OrderItem;

import jakarta.validation.Valid;

public interface OrderItemMapper {

    OrderItem saveOrderItem(@Valid OrderItemDto orderItem);

    OrderItemDto convertoDto(OrderItem od);

}
