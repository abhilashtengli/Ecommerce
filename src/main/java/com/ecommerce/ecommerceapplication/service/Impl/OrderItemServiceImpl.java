package com.ecommerce.ecommerceapplication.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.OrderItemRepo;
import com.ecommerce.ecommerceapplication.model.OrderItem;
import com.ecommerce.ecommerceapplication.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Override
    public OrderItem saveOrderItemToDb(OrderItem oItem) {

        return orderItemRepo.save(oItem);
    }

}
