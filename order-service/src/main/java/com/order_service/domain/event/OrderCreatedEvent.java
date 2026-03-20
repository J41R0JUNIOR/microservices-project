package com.order_service.domain.dto;

import java.util.List;

import com.order_service.domain.models.Order;

import jakarta.validation.Valid;

public record OrderCreatedEvent(
        String orderId,
        List<@Valid ItemCreatedEvent> items
        ) {

    public OrderCreatedEvent(Order data) {
        this(
                data.getId(),
                data.getItems()
                        .stream()
                        .map(item -> new ItemCreatedEvent(item))
                        .toList()
        );
    }
}
