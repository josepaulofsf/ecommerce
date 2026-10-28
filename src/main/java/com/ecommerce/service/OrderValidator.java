package com.ecommerce.service;

import com.ecommerce.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    public void validate(Order order) {
        if (order.getCustomer() == null || !order.getCustomer().isActive()) {
            throw new RuntimeException("Invalid customer");
        }
        if (order.getProduct() == null || order.getProduct().getPrice() <= 0) {
            throw new RuntimeException("Invalid product");
        }
        if (order.getQuantity() > 100) {
            throw new RuntimeException("Quantity exceeds limit");
        }
    }
}
