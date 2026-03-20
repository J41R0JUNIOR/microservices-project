package com.order_service.domain.dto;

import com.order_service.domain.models.Item;

public record ItemCreatedEvent (
    String productId,
    Integer quantity,
    Integer price
) { 
    public ItemCreatedEvent(Item data) {
        this(
            data.getProductId(),
            data.getQuantity(),
            data.getPrice()
        );
    }
}