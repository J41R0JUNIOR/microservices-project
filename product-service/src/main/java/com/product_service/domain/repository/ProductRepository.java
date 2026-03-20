package com.product_service.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product_service.domain.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
