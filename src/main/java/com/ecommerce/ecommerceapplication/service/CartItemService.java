package com.ecommerce.ecommerceapplication.service;

import com.ecommerce.ecommerceapplication.model.CartItem;

public interface CartItemService {

    CartItem saveTheCartItem(CartItem ct);

    void deleteCartItem(int userId);
    
}
