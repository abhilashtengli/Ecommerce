package com.ecommerce.ecommerceapplication.service.Impl;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.OrderItemRepo;
import com.ecommerce.ecommerceapplication.model.OrderItem;
import com.ecommerce.ecommerceapplication.model.TransactionDetails;
import com.ecommerce.ecommerceapplication.service.OrderItemService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;

    private static final String key = "rzp_test_A4nwLqory0WFj0";
    private static final String secret_key = "XoPtJmelEyZ7iQ7vKUi7XKvl";
    private static final String CURRENCY = "INR";

    @Override
    public OrderItem saveOrderItemToDb(OrderItem oItem) {
        return orderItemRepo.save(oItem);
    }

    public TransactionDetails createTransaction(int amount) {
        // amount
        // currency
        // key
        // secret_key
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("amount", amount * 100);
            jsonObject.put("currency", CURRENCY);
            RazorpayClient razorpayClient = new RazorpayClient(key, secret_key);

            Order orderRazorpay = razorpayClient.orders.create(jsonObject);

            log.info(orderRazorpay.toString());
            return prepareTransactionDetails(orderRazorpay);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private TransactionDetails prepareTransactionDetails(Order order) {
        String orderId = order.get("id");
        String currreny = order.get("currency");
        Integer amount = order.get("amount");

        TransactionDetails transactionDetails = new TransactionDetails(orderId, currreny, key, amount);

        return transactionDetails;
    }
}
