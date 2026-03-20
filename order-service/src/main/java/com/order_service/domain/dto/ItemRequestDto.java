package com.order_service.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemRequestDto (
    @NotBlank(message = "Product ID is required")
    String productId,

    @NotNull(message = "Quantity cannot be null")
    @Positive(message = "Quantity must be greater than zero")
    Integer quantity,

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than zero")
    Integer price
) { }