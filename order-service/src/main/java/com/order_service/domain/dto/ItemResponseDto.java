package com.order_service.domain.dto;

import com.order_service.domain.models.Item;

public record ItemResponseDto (
    String id,
    Integer quantity,
    Integer price
) { 
    public ItemResponseDto(Item data) {
        this(
            data.getId(),
            data.getQuantity(),
            data.getPrice()
        );
    }
}