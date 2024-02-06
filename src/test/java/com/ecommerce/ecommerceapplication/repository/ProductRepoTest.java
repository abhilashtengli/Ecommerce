package com.ecommerce.ecommerceapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.ecommerceapplication.dao.ProductRepo;
import com.ecommerce.ecommerceapplication.model.Product;

@SpringBootTest
public class ProductRepoTest {

    @Autowired
    private ProductRepo productRep;

    public void productSave() {

        Product product = Product.builder()
                .productName("shoes")
                .price(700).build();
    }
}
