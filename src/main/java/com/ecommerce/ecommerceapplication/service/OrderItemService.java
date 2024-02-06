package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.model.OrderItem;
import com.ecommerce.ecommerceapplication.model.TransactionDetails;

public interface OrderItemService {

    OrderItem saveOrderItemToDb(OrderItem oItem);

    TransactionDetails createTransaction(int amount);
    
}
