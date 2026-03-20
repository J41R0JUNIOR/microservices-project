package com.order_service.domain.dto;

import com.order_service.domain.models.Item;

public record ItemCreatedEvent (
    String id,
    Integer quantity,
    Integer price
) { 
    public ItemCreatedEvent(Item data) {
        this(
            data.getId(),
            data.getQuantity(),
            data.getPrice()
        );
    }
}