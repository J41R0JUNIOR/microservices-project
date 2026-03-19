package com.order_service.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class OrderEventProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendMessage() {
        String message = "Hello, RabbitMQ!";
        this.template.convertAndSend(queue.getName(), message);
        System.out.println("Sent message: " + message);
    }
}
