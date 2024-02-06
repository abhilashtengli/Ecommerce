package com.ecommerce.ecommerceapplication.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int id;

    private int totalAmount;

    private LocalDate orderDate;

    @NotNull(message = "Order failed due to payment failure")
    private String transactionId;

    @NotNull(message = "user Id cannot be null")
    private int user;

}
