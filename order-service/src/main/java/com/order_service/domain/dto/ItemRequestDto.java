package com.order_service.domain.dto;

public record ItemRequestDto (
    String id,
    Integer quantity,
    Integer price
) { }