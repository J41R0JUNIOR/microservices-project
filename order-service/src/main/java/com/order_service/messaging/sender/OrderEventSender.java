package com.order_service.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order_service.domain.dto.OrderCreatedEvent;

@Component
public class OrderEventSender {

    @Autowired
    private RabbitTemplate template;

    public void dispatchNewOrderEvent(OrderCreatedEvent event) {
        this.template.convertAndSend("order-queue", event);
        System.out.println("Sent message: " + event);
    }
}