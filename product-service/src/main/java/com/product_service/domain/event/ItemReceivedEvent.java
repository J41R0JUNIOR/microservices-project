package com.product_service.domain.event;

public record ItemReceivedEvent (
    String productId,
    Integer quantity,
    Integer price
) { }