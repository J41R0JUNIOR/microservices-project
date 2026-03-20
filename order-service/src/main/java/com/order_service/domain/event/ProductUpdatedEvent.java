package com.order_service.domain.event;

public record ProductUpdatedEvent(
    String orderId, boolean success
) { }