package com.ecommerce.ecommerceapplication.dto;

import java.util.List;

import com.ecommerce.ecommerceapplication.model.Order;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;

    @NotNull(message = "Username cannot be null")
    private String username;

    @Column(nullable = false)
    @Email(message = "The email address is invalid")
    private String email;

    @Size(min = 8, message = "Password must be at least have 8 characters")
    @NotNull(message = "password cannot be null")
    private String password;

    @Size(min = 3, max = 50)
    @NotNull(message = "firstname cannot be null")
    private String firstname;

    @NotNull(message = "Role cannot be null")
    private String role;

    @Column(nullable = true)
    private String lastname;

    private List<Order> orders;
}
