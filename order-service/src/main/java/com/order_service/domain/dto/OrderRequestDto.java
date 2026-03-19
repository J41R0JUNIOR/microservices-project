package com.order_service.domain.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequestDto(
    @NotBlank(message = "Buyer ID is required")
    String buyerId,

    @NotNull(message = "Total amount cannot be null")
    @Positive(message = "Total amount must be greater than zero")
    Integer totalAmount,

    @NotNull(message = "Items cannot be null")
    @NotEmpty(message = "Items cannot be empty")
    List<@Valid ItemRequestDto> items
) { }