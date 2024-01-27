package com.ecommerce.ecommerceapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.ecommerceapplication.dto.OrderItemDto;
import com.ecommerce.ecommerceapplication.mapper.OrderItemMapper;
import com.ecommerce.ecommerceapplication.model.OrderItem;
import com.ecommerce.ecommerceapplication.service.OrderItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/orderItem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @PostMapping("/save")
    public ResponseEntity<OrderItemDto> saveOrderItem(@Valid @RequestBody OrderItemDto orderItem) {
        OrderItem oItem = orderItemMapper.saveOrderItem(orderItem);
        OrderItem od = orderItemService.saveOrderItemToDb(oItem);
        OrderItemDto orderItemDto = orderItemMapper.convertoDto(od);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderItemDto);

    }

}
