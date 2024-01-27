package com.ecommerce.ecommerceapplication.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.ProductRepo;
import com.ecommerce.ecommerceapplication.exceptionClass.ProductNotFoundException;
import com.ecommerce.ecommerceapplication.model.Product;
import com.ecommerce.ecommerceapplication.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product productToSave) {

        return productRepo.save(productToSave);
    }

    @Override
    public Product getProduct(String productName) throws ProductNotFoundException {

        Optional<Product> p = productRepo.findByProductName(productName);
        if (!p.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        return p.get();
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> all = productRepo.findAll();
        return all;
    }

    @Override
    public void updateProduct(int productId, int quantity) {

        Product pd = productRepo.findById(productId).get();
        int totalQuantity = pd.getQuantity();
        if (totalQuantity != 0) {
            int revisedQuantity = totalQuantity - quantity;
            pd.setQuantity(revisedQuantity);
        }

    }

    @Override
    public Product updateProductDetails(int id, Product prod) throws ProductNotFoundException {

        Optional<Product> pd = productRepo.findById(id);
        Product product = pd.get();
        if (pd.isPresent()) {
            product = Product.builder()
                    .productName(prod.getProductName())
                    .description(prod.getDescription())
                    .price(prod.getPrice())
                    .imageUrl(prod.getImageUrl())
                    .quantity(prod.getQuantity()).build();

        } else {
            throw new ProductNotFoundException("Product not found");
        }
        return product;
    }

    @Override
    public int getProductQuantity(int id) {
        int quantity = productRepo.findById(id).get().getQuantity();
        return quantity;
    }

}
