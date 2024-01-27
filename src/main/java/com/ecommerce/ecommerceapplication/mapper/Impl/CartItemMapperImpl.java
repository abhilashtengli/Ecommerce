package com.ecommerce.ecommerceapplication.mapper.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.ecommerceapplication.dao.ProductRepo;
import com.ecommerce.ecommerceapplication.dao.UserRepo;
import com.ecommerce.ecommerceapplication.dto.CartItemDto;
import com.ecommerce.ecommerceapplication.mapper.CartItemMapper;
import com.ecommerce.ecommerceapplication.model.CartItem;
import com.ecommerce.ecommerceapplication.model.Product;
import com.ecommerce.ecommerceapplication.model.User;

@Component
public class CartItemMapperImpl implements CartItemMapper {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public CartItem saveCartItem(CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        Product prod = productRepo.findById(cartItemDto.getProductId()).get();
        User user = userRepo.findById(cartItemDto.getUserId()).get();
        cartItem.setProduct(prod);
        cartItem.setUser(user);
        cartItem.setCreatedDate(LocalDate.now());
        cartItem.setQuantity(cartItemDto.getQuantity());
        return cartItem;
    }

    @Override
    public CartItemDto converToDto(CartItem savedcartItem) {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(savedcartItem.getId());
        cartItemDto.setProductId(savedcartItem.getProduct().getId());
        cartItemDto.setQuantity(savedcartItem.getQuantity());
        cartItemDto.setCreatedDate(savedcartItem.getCreatedDate());
        cartItemDto.setUserId(savedcartItem.getUser().getId());
        return cartItemDto;
    }

    @Override
    public CartItem updateCartItem(CartItemDto cartItemdto) {
        CartItem cart = new CartItem();
        cart.setQuantity(cartItemdto.getQuantity());
        Product prod = productRepo.findById(cartItemdto.getProductId()).get();
        cart.setProduct(prod);
        return cart;
    }

}
