package com.order_service.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.order_service.domain.dto.OrderCreatedEvent;

@Component
public class OrderEventReceiver {
    
    @RabbitListener(queues = "order-queue")
    public void receiveMessage(OrderCreatedEvent event) {
        System.out.println("Received message: " + event);
    }
}