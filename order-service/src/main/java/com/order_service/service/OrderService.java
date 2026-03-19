package com.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_service.domain.dto.OrderRequestDto;
import com.order_service.domain.dto.OrderResponseDto;
import com.order_service.domain.models.Order;
import com.order_service.domain.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderResponseDto createOrder(OrderRequestDto data) {

        Order order = new Order(data);
        linkItemsToOrder(order);

        Order response = orderRepository.save(order);

        response.setItems(order.getItems());

        return new OrderResponseDto(response);
    }

    private void linkItemsToOrder(Order order) {
        order.getItems().forEach(item -> item.setOrder(order));
    }
}
