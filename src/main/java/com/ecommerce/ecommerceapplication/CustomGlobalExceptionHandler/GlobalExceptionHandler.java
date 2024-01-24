package com.ecommerce.ecommerceapplication.CustomGlobalExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.ecommerceapplication.exceptionClass.CategoryIdNotFoundException;
import com.ecommerce.ecommerceapplication.exceptionClass.ProductNotFoundException;
import com.ecommerce.ecommerceapplication.exceptionClass.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException user) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Message", user.getMessage());
        map.put("StatusCode", HttpStatus.NOT_FOUND.toString());

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> ProductNotFoundException(ProductNotFoundException product) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Message", product.getMessage());
        map.put("StatusCode", HttpStatus.NOT_FOUND.toString());

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CategoryIdNotFoundException.class)
    public ResponseEntity<Map<String, String>> CategoryIdNotFoundException(CategoryIdNotFoundException product) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Message", product.getMessage());
        map.put("StatusCode", HttpStatus.NOT_FOUND.toString());

        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
