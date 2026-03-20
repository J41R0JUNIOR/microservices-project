package com.product_service.domain.event;

public record ProductUpdatedEvent(
    String orderId, boolean success
) { }