package com.ecommerce.ecommerceapplication.mapper.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecommerce.ecommerceapplication.dao.CategoryRepo;
import com.ecommerce.ecommerceapplication.dto.ProductDto;
import com.ecommerce.ecommerceapplication.exceptionClass.CategoryIdNotFoundException;
import com.ecommerce.ecommerceapplication.mapper.ProductMapper;
import com.ecommerce.ecommerceapplication.model.Category;
import com.ecommerce.ecommerceapplication.model.Product;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Product saveProduct(ProductDto product) throws CategoryIdNotFoundException {
        Product newProduct = new Product();
        newProduct.setProductName(product.getProductName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setImageUrl(product.getImageUrl());

        int CategoryId = product.getCategoryId();
        Optional<Category> cId = categoryRepo.findById(CategoryId);

        if (!cId.isPresent()) {
            throw new CategoryIdNotFoundException("Category Id not found = " + cId.get());
        } else {
            newProduct.setCategory(cId.get());
        }
        return newProduct;
    }

    @Override
    public ProductDto savedProductDto(Product savedProduct) {
        ProductDto saveProductDto = new ProductDto();
        saveProductDto.setId(savedProduct.getId());
        saveProductDto.setDescription(savedProduct.getDescription());
        saveProductDto.setPrice(savedProduct.getPrice());
        saveProductDto.setQuantity(savedProduct.getQuantity());
        saveProductDto.setImageUrl(savedProduct.getImageUrl());
        saveProductDto.setProductName(savedProduct.getProductName());
        saveProductDto.setCategoryId(savedProduct.getCategory().getId());

        Category c = categoryRepo.findById(savedProduct.getCategory().getId()).get();
        List<Category> list = new ArrayList<>();
        list.add(c);
        saveProductDto.setCategories(list);
        return saveProductDto;
    }

    @Override
    public List<ProductDto> getAllProductDto(List<Product> prodList) {

        List<ProductDto> list = new ArrayList<>();
        prodList.forEach(product -> {
            ProductDto productDto = savedProductDto(product);
            list.add(productDto);
        });
        return list;
    }

    @Override
    public Product updateProduct(ProductDto productDto) {

        Product product = Product.builder()
                .productName(productDto.getProductName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImageUrl())
                .quantity(productDto.getQuantity()).build();

        return product;
    }

}
