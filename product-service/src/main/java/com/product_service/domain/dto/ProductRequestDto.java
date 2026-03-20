package com.product_service.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequestDto (
    @NotNull(message = "Name cannot be null")
    String name,
    
    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be greater than zero")
    Integer quantity,

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than zero")
    Integer price
) { }