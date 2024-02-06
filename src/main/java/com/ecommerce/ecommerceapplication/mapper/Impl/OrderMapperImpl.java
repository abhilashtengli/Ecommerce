package com.ecommerce.ecommerceapplication.mapper.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.UserRepo;
import com.ecommerce.ecommerceapplication.dto.OrderDto;
import com.ecommerce.ecommerceapplication.mapper.OrderMapper;
import com.ecommerce.ecommerceapplication.model.Order;
import com.ecommerce.ecommerceapplication.model.User;

import jakarta.validation.Valid;

@Service
public class OrderMapperImpl implements OrderMapper {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Order placeOrder(@Valid OrderDto orderDto) {
        Order order = new Order();
        order.setCreatedDate(LocalDate.now());
        User u = userRepo.findById(orderDto.getUser()).get();
        order.setUser(u);
        order.setTransationId(orderDto.getTransactionId());
        return order;
    }

    @Override
    public OrderDto converToDto(Order orderSaved) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderSaved.getId());
        orderDto.setOrderDate(orderSaved.getCreatedDate());
        orderDto.setTotalAmount(orderSaved.getTotalAmount());
        orderDto.setUser(orderSaved.getUser().getId());
        return orderDto;
    }

}
