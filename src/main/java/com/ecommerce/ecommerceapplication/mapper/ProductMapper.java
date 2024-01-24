package com.ecommerce.ecommerceapplication.mapper;

import java.util.List;

import com.ecommerce.ecommerceapplication.dto.ProductDto;
import com.ecommerce.ecommerceapplication.exceptionClass.CategoryIdNotFoundException;
import com.ecommerce.ecommerceapplication.model.Product;

public interface ProductMapper {

    Product saveProduct(ProductDto product) throws CategoryIdNotFoundException;

    ProductDto savedProductDto(Product savedProduct);

    List<ProductDto> getAllProductDto(List<Product> prodList);

    
}
