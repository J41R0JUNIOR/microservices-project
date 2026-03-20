package com.order_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order_service.domain.models.Order;

public interface OrderRepository extends JpaRepository<Order, String> { }