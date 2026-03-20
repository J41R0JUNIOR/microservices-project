package com.product_service.messaging.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.product_service.domain.event.ProductUpdateFailedEvent;
import com.product_service.domain.event.ProductUpdatedEvent;

@Component
public class ProductEventSender {

    private final RabbitTemplate template;

    public ProductEventSender(RabbitTemplate template) {
        this.template = template;
    }

    public void sendSuccess(ProductUpdatedEvent event) {
        template.convertAndSend("product-success-queue", event);
        System.out.println("Sent success event: " + event);
    }

    public void sendFailure(ProductUpdateFailedEvent event) {
        template.convertAndSend("product-failure-queue", event);
        System.out.println("Sent failure event: " + event);
    }
}