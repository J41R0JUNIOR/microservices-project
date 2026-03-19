package com.order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_service.domain.dto.OrderRequestDto;
import com.order_service.domain.dto.OrderResponseDto;
import com.order_service.domain.models.Order;
import com.order_service.domain.repository.OrderRepository;
import com.order_service.messaging.OrderEventProducer;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEventProducer orderEventProducer;

    public OrderResponseDto createOrder(OrderRequestDto data) {
        Order order = new Order(data);
        Order repoOrder = orderRepository.save(order);

        orderEventProducer.sendMessage();

        return new OrderResponseDto(repoOrder);
    }

    public List<OrderResponseDto> getAllOrders() {
        List<Order> repoOrders = orderRepository.findAll();

        return repoOrders.stream().map(OrderResponseDto::new).toList();
    }
}
