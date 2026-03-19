package com.order_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.order_service.messaging.OrderEventConsumer;
import com.order_service.messaging.OrderEventProducer;

@Configuration
public class RabbitConfig {

    @Bean 
    public Queue orderQueue() {
        return QueueBuilder.durable("order-queue").quorum().build();
    }

    @Bean 
    public OrderEventConsumer receiver() {
        return new OrderEventConsumer();
    }

    @Bean
    public OrderEventProducer sender() {
        return new OrderEventProducer();
    }
}
