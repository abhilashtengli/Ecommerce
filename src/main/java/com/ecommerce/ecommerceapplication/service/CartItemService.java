package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.exceptionClass.PoductNotAvailableException;
import com.ecommerce.ecommerceapplication.model.CartItem;

public interface CartItemService {

    CartItem saveTheCartItem(CartItem ct);

    void deleteCartItem(int userId);

    CartItem updateCartItem(int id, CartItem cart) throws PoductNotAvailableException;
    
}
