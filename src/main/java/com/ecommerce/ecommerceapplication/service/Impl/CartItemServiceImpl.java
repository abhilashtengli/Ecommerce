package com.ecommerce.ecommerceapplication.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.CartItemRepo;
import com.ecommerce.ecommerceapplication.model.CartItem;
import com.ecommerce.ecommerceapplication.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;

    @Override
    public CartItem saveTheCartItem(CartItem ct) {
        return cartItemRepo.save(ct);
    }

    @Override
    public void deleteCartItem(int userId) {

        cartItemRepo.deleteById(userId);
    }

}
