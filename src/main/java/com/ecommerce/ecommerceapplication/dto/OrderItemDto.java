package com.ecommerce.ecommerceapplication.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private int id;

    private @NotNull int quantity;

    private @NotNull double price;

    private  LocalDate createdDate;

    private @NotNull int orderId;

    private @NotNull int productId;
}
