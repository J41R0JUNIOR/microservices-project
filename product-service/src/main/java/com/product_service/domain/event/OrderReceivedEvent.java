package com.product_service.domain.event;

import java.util.List;

import jakarta.validation.Valid;

public record OrderReceivedEvent(
        String orderId,
        List<@Valid ItemReceivedEvent> items
) { }
