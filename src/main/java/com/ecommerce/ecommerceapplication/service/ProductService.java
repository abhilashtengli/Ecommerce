package com.ecommerce.ecommerceapplication.service;

import java.util.List;

import com.ecommerce.ecommerceapplication.exceptionClass.ProductNotFoundException;
import com.ecommerce.ecommerceapplication.model.Product;

public interface ProductService {

    Product saveProduct(Product productToSave);

    Product getProduct(String productName) throws ProductNotFoundException;

    List<Product> getAllProduct();

    void updateProduct(int productId, int quantity);

}
