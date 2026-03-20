package com.order_service.domain.event;

public record ProductUpdateFailedEvent(
    String orderId,
    String reason
) { }
