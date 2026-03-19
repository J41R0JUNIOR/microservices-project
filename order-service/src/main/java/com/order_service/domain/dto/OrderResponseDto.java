package com.order_service.domain.dto;

import java.util.List;

import com.order_service.domain.enums.OrderStatus;
import com.order_service.domain.models.Order;

public record OrderResponseDto(
    String id,
    String createdAt,
    String updatedAt,
    String buyerId,
    OrderStatus status,
    Integer totalAmount,
    List<ItemResponseDto> items
) {

    public OrderResponseDto(Order data) {
        this(
            data.getId(),
            data.getCreatedAt(),
            data.getUpdatedAt(),
            data.getBuyerId(),
            data.getStatus(),
            data.getTotalAmount(),
            data.getItems().stream().map(item -> new ItemResponseDto(item)).toList()
        );
    }
}
