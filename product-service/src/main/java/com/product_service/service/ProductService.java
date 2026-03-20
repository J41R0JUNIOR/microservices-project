package com.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product_service.domain.dto.ProductRequestDto;
import com.product_service.domain.dto.ProductResponseDto;
import com.product_service.domain.event.ItemReceivedEvent;
import com.product_service.domain.event.OrderReceivedEvent;
import com.product_service.domain.event.ProductUpdateFailedEvent;
import com.product_service.domain.event.ProductUpdatedEvent;
import com.product_service.domain.models.Product;
import com.product_service.domain.repository.ProductRepository;
import com.product_service.messaging.sender.ProductEventSender;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEventSender productEventProducer;

    public ProductResponseDto createProduct(ProductRequestDto data) {
        Product product = new Product(data);
        productRepository.save(product);

        return new ProductResponseDto(product);
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> repoProducts = productRepository.findAll();

        return repoProducts.stream().map(ProductResponseDto::new).toList();
    }

    public void handleOrderCreated(OrderReceivedEvent event) {
        try {
            for (ItemReceivedEvent item : event.items()) {
                System.out.println("Processing item: " + item.productId() + ", quantity: " + item.quantity());
                Product product = productRepository.findById(item.productId())
                        .orElseThrow();

                product.decreaseStock(item.quantity());
                productRepository.save(product);
            }

            productEventProducer.sendSuccess(new ProductUpdatedEvent(event.orderId(), true));

        } catch (Exception e) {
            productEventProducer.sendFailure(
                    new ProductUpdateFailedEvent(event.orderId(), e.getMessage())
            );
        }
    }
}
