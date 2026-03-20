package com.order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_service.domain.dto.OrderCreatedEvent;
import com.order_service.domain.dto.OrderRequestDto;
import com.order_service.domain.dto.OrderResponseDto;
import com.order_service.domain.enums.OrderStatus;
import com.order_service.domain.models.Order;
import com.order_service.domain.repository.OrderRepository;
import com.order_service.messaging.OrderEventSender;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEventSender orderEventProducer;

    public OrderResponseDto createOrder(OrderRequestDto data) {
        Order order = new Order(data);
        orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(order);
        orderEventProducer.dispatchNewOrderEvent(event);

        return new OrderResponseDto(order);
    }

    public List<OrderResponseDto> getAllOrders() {
        List<Order> repoOrders = orderRepository.findAll();

        return repoOrders.stream().map(OrderResponseDto::new).toList();
    }

    public void confirmOrder(String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.setStatus(OrderStatus.COMPLETED);
        orderRepository.save(order);
    }
}
