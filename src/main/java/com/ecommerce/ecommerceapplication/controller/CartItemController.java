package com.ecommerce.ecommerceapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.ecommerceapplication.dto.CartItemDto;
import com.ecommerce.ecommerceapplication.exceptionClass.PoductNotAvailableException;
import com.ecommerce.ecommerceapplication.mapper.CartItemMapper;
import com.ecommerce.ecommerceapplication.model.CartItem;
import com.ecommerce.ecommerceapplication.service.CartItemService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cartItem")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartItemMapper cartItemMapper;

    @PostMapping("/save")
    public ResponseEntity<CartItemDto> saveCartItem(@Valid @RequestBody CartItemDto cartItemDto) {
        CartItem ct = cartItemMapper.saveCartItem(cartItemDto);
        CartItem savedcartItem = cartItemService.saveTheCartItem(ct);
        CartItemDto cDto = cartItemMapper.converToDto(savedcartItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(cDto);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public void deleteCartItem(@PathVariable int userId) {
        cartItemService.deleteCartItem(userId);
    }

    @PostMapping("updateCart/{id}")
    public ResponseEntity<CartItemDto> updateCartItem(@PathVariable int id, @RequestBody CartItemDto cartItemdto)
            throws PoductNotAvailableException {
        CartItem cart = cartItemMapper.updateCartItem(cartItemdto);
        CartItem updateCart = cartItemService.updateCartItem(id, cart);
        CartItemDto cartDto = cartItemMapper.converToDto(updateCart);
        return ResponseEntity.status(HttpStatus.OK).body(cartDto);
    }
}
