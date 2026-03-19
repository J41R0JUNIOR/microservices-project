package com.order_service.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.order_service.domain.enums.OrderStatus;
import com.order_service.domain.models.Item;
import com.order_service.domain.models.Order;
import com.order_service.domain.repository.OrderRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder() {
        String id = UUID.randomUUID().toString();
        String now = new Date().toString();
        String customerId = "123";
        int totalAmount = 100;
        List<Item> items = List.of();
        OrderStatus orderStatus = OrderStatus.CREATED;

        Order order = new Order(id, now, now, customerId, totalAmount, orderStatus, items);
        Order response = orderRepository.save(order);
        Item item = new Item(null, 2, 50, response);
        response.setItems(List.of(item));
        return response;
    }
}
