package com.product_service.domain.models;

import com.product_service.domain.dto.ProductRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Integer quantity;
    private Integer price;

    public Product(ProductRequestDto data) {
        this.name = data.name();
        this.quantity = data.quantity();
        this.price = data.price();
        this.validateItem();
    }

    private void validateItem() {
        if (this.quantity == null || this.quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        if (this.price == null || this.price < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to 0");
        }
    }

    public void decreaseStock(Integer amount) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        if (this.quantity < amount) {
            throw new IllegalArgumentException("Insufficient stock");
        }

        this.quantity -= amount;
    }
}
