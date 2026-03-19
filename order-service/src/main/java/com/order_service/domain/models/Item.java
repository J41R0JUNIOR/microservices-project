package com.order_service.domain.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.order_service.domain.dto.ItemRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private Integer quantity;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    public Item(ItemRequestDto data, Order order) {
        this.quantity = data.quantity();
        this.price = data.price();
        this.order = order;
        this.validateItem();
    }

    private void validateItem() {
        if (this.quantity == null || this.quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (this.price == null || this.price < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to 0");
        }
        if (this.order == null) {
            throw new IllegalArgumentException("Order must not be null");
        }
    }
}