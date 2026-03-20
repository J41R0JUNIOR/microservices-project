package com.product_service.domain.dto;

import com.product_service.domain.models.Product;

public record ProductResponseDto (
    String id,
    String name,
    Integer quantity,
    Integer price
) { 
    public ProductResponseDto(Product data) {
        this(
            data.getId(),
            data.getName(),
            data.getQuantity(),
            data.getPrice()
        );
    }
}