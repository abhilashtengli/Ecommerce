package com.ecommerce.ecommerceapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerceapplication.dto.ProductDto;
import com.ecommerce.ecommerceapplication.exceptionClass.CategoryIdNotFoundException;
import com.ecommerce.ecommerceapplication.exceptionClass.ProductNotFoundException;
import com.ecommerce.ecommerceapplication.mapper.ProductMapper;
import com.ecommerce.ecommerceapplication.model.Product;
import com.ecommerce.ecommerceapplication.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/save")
    public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto product)
            throws CategoryIdNotFoundException {

        Product productToSave = productMapper.saveProduct(product);
        Product savedProduct = productService.saveProduct(productToSave);
        ProductDto dto = productMapper.savedProductDto(savedProduct);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/get/{productName}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String productName) throws ProductNotFoundException {

        Product product = productService.getProduct(productName);
        ProductDto proDto = productMapper.savedProductDto(product);

        return ResponseEntity.status(HttpStatus.OK).body(proDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDto>> getAllproduct() {

        List<Product> prodList = productService.getAllProduct();
        List<ProductDto> prodDtoList = productMapper.getAllProductDto(prodList);

        return ResponseEntity.status(HttpStatus.OK).body(prodDtoList);
    }

}
