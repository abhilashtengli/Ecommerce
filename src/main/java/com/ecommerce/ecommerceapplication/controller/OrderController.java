package com.ecommerce.ecommerceapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerceapplication.dto.OrderDto;
import com.ecommerce.ecommerceapplication.mapper.OrderMapper;
import com.ecommerce.ecommerceapplication.model.Order;
import com.ecommerce.ecommerceapplication.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<OrderDto> placeOrder(@Valid @RequestBody OrderDto orderDto) {
        Order od = orderMapper.placeOrder(orderDto);
        Order orderSaved = orderService.placeOrder(od);
        OrderDto oDto = orderMapper.converToDto(orderSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(oDto);
    }
}
