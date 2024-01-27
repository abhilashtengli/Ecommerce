package com.ecommerce.ecommerceapplication.mapper;

import com.ecommerce.ecommerceapplication.dto.CartItemDto;
import com.ecommerce.ecommerceapplication.model.CartItem;

public interface CartItemMapper {

    CartItem saveCartItem(CartItemDto cartItemDto);

    CartItemDto converToDto(CartItem savedcartItem);

    CartItem updateCartItem(CartItemDto cartItemdto);

   
   
    
}
