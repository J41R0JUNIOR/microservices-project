package com.order_service.domain.models;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.order_service.domain.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String createdAt;
    private String updatedAt;
    private String buyerId;
    private Integer totalAmount;
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private List<Item> items;
}