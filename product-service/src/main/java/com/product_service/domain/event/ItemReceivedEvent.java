package com.product_service.domain.event;

public record ItemReceivedEvent (
    String id,
    Integer quantity,
    Integer price
) { }