package com.order_service.domain.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record OrderRequestDto(
    @NotBlank(message = "Buyer ID cannot be blank")
    String buyerId,

    @NotNull(message = "Total amount cannot be null")
    Integer totalAmount,

    @NotNull(message = "Items cannot be null")
    List<ItemRequestDto> items
) { }