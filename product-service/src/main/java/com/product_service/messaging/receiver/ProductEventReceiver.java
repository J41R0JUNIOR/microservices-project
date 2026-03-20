package com.product_service.messaging.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product_service.domain.event.OrderReceivedEvent;
import com.product_service.service.ProductService;

@Component
public class ProductEventReceiver {

    @Autowired
    private ProductService productService;
    
    @RabbitListener(queues = "order-queue")
    public void receiveMessage(OrderReceivedEvent event) {
        System.out.println("Received message: " + event);

        productService.handleOrderCreated(event);
    }
}