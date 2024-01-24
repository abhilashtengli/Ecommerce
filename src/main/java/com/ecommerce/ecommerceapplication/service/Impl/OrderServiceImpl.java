package com.ecommerce.ecommerceapplication.service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.ecommerceapplication.dao.CartItemRepo;
import com.ecommerce.ecommerceapplication.dao.OrderItemRepo;
import com.ecommerce.ecommerceapplication.dao.OrderRepo;
import com.ecommerce.ecommerceapplication.dao.ProductRepo;
import com.ecommerce.ecommerceapplication.dao.UserRepo;
import com.ecommerce.ecommerceapplication.model.CartItem;
import com.ecommerce.ecommerceapplication.model.Order;
import com.ecommerce.ecommerceapplication.model.OrderItem;
import com.ecommerce.ecommerceapplication.model.Product;
import com.ecommerce.ecommerceapplication.model.User;
import com.ecommerce.ecommerceapplication.service.OrderService;
import com.ecommerce.ecommerceapplication.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Override
    @Transactional
    public Order placeOrder(Order od) {
        int userId = od.getUser().getId();

        List<CartItem> cartItems = cartItemRepo.findByUserId(userId);

        Order order = new Order();

        order.setCreatedDate(LocalDate.now());
        User user = userRepo.findById(userId).get();
        order.setUser(user);
        AtomicInteger totalPriceAmount = new AtomicInteger(0);

        cartItems.forEach(items -> {
            int proId = items.getProduct().getId();
            int itemQuantity = items.getQuantity();
            Product pd = productRepo.findById(proId).get();
            totalPriceAmount.addAndGet(pd.getPrice() * itemQuantity);
            productService.updateProduct(proId, itemQuantity);
        });
        int price = totalPriceAmount.get();
        order.setTotalAmount(price);

        orderRepo.save(order);

        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();

            orderItem.setCreatedDate(cartItem.getCreatedDate());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOrder(order);
            int proId = cartItem.getProduct().getId();
            Product pd = productRepo.findById(proId).get();
            orderItem.setPrice(pd.getPrice() * cartItem.getQuantity());

            orderItemRepo.save(orderItem);
        }
        cartItemRepo.deleteByUser_Id(userId);
        return order;
    }

}
