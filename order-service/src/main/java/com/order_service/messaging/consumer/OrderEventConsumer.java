package com.order_service.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "order-queue")
public class OrderEventConsumer {
    
    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
