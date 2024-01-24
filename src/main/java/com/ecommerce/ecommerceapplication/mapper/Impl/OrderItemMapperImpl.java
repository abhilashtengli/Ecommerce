package com.ecommerce.ecommerceapplication.mapper.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.ecommerceapplication.dao.OrderRepo;
import com.ecommerce.ecommerceapplication.dao.ProductRepo;
import com.ecommerce.ecommerceapplication.dto.OrderItemDto;
import com.ecommerce.ecommerceapplication.mapper.OrderItemMapper;
import com.ecommerce.ecommerceapplication.model.Order;
import com.ecommerce.ecommerceapplication.model.OrderItem;
import com.ecommerce.ecommerceapplication.model.Product;

import jakarta.validation.Valid;

@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public OrderItem saveOrderItem(@Valid OrderItemDto orderItem) {

        OrderItem oItem = new OrderItem();

        oItem.setPrice(orderItem.getPrice());
        Product pod = productRepo.findById(orderItem.getProductId()).get();
        oItem.setProduct(pod);
        Order od = orderRepo.findById(orderItem.getOrderId()).get();
        oItem.setOrder(od);
        oItem.setCreatedDate(LocalDate.now());
        oItem.setQuantity(orderItem.getQuantity());

        return oItem;
    }

    @Override
    public OrderItemDto convertoDto(OrderItem od) {

        OrderItemDto oItem = new OrderItemDto();

        oItem.setId(od.getId());
        oItem.setCreatedDate(od.getCreatedDate());
        oItem.setOrderId(od.getOrder().getId());
        oItem.setPrice(od.getPrice());
        oItem.setProductId(od.getProduct().getId());
        oItem.setQuantity(od.getQuantity());

        return oItem;
    }

}
