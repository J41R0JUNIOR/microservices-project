package com.product_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.domain.dto.ProductRequestDto;
import com.product_service.domain.dto.ProductResponseDto;
import com.product_service.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductResponseDto createProduct(@Valid @RequestBody ProductRequestDto data) {
        return productService.createProduct(data);
    }

    @GetMapping
    public Iterable<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
