package com.order_service.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order_service.domain.event.ProductUpdateFailedEvent;
import com.order_service.domain.event.ProductUpdatedEvent;
import com.order_service.service.OrderService;

@Component
public class OrderEventReceiver {

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "product-success-queue")
    public void handleSuccess(ProductUpdatedEvent event) {
        System.out.println("Product updated successfully for order: " + event.orderId());
        this.orderService.confirmOrder(event.orderId());
    }

    @RabbitListener(queues = "product-failure-queue")
    public void handleFailure(ProductUpdateFailedEvent event) {
        System.out.println("Product update failed for order: " + event.orderId());
    }
}
