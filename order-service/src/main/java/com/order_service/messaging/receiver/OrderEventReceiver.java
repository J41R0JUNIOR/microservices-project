package com.order_service.messaging;

import org.springframework.stereotype.Component;


@Component
public class OrderEventReceiver {
    
    // @RabbitListener(queues = "order-queue")
    // public void receiveMessage(OrderCreatedEvent event) {
    //     System.out.println("Received message: " + event);
    // }
}