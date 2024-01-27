package com.ecommerce.ecommerceapplication.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerceapplication.dao.CartItemRepo;
import com.ecommerce.ecommerceapplication.exceptionClass.PoductNotAvailableException;
import com.ecommerce.ecommerceapplication.model.CartItem;
import com.ecommerce.ecommerceapplication.service.CartItemService;
import com.ecommerce.ecommerceapplication.service.ProductService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    ProductService productService;

    @Override
    public CartItem saveTheCartItem(CartItem ct) {
        return cartItemRepo.save(ct);
    }

    @Override
    public void deleteCartItem(int userId) {
        cartItemRepo.deleteById(userId);
    }

    @Override
    public CartItem updateCartItem(int id, CartItem cart) throws PoductNotAvailableException {

        CartItem cartItem = cartItemRepo.findById(id).get();

        if (cart.getQuantity() < productService.getProductQuantity(cart.getProduct().getId())) {
            cartItem.setQuantity(cart.getQuantity());
            cartItemRepo.save(cartItem);
        } else {
            throw new PoductNotAvailableException("Available quantity of the " + cart.getProduct().getProductName()
                    + " is only " + productService.getProductQuantity(cart.getProduct().getId()));
        }
        return cartItem;
    }

}
