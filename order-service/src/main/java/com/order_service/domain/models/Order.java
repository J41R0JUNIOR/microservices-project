package com.order_service.domain.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.order_service.domain.dto.OrderRequestDto;
import com.order_service.domain.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String createdAt;
    private String updatedAt;
    private String buyerId;
    private Integer totalAmount;
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private List<Item> items;

    public Order(OrderRequestDto data) {
        String date = new Date().toString();

        this.createdAt = date;
        this.updatedAt = date;
        this.buyerId = data.buyerId();
        this.totalAmount = data.totalAmount();
        this.status = OrderStatus.CREATED;

        if (data.items().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item.");
        }

        this.items = data.items()
                .stream()
                .map(item -> new Item(item, this))
                .toList();
    }
}
