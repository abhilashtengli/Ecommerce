package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.model.OrderItem;

public interface OrderItemService {

    OrderItem saveOrderItemToDb(OrderItem oItem);
    
}
