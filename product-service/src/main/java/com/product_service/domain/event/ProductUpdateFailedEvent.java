package com.product_service.domain.event;

public record ProductUpdateFailedEvent(
    String orderId,
    String reason
) { }
