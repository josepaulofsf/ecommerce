package com.ecommerce.service;

import com.ecommerce.model.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingCalculator {

    public double calculateShippingCost(Order order) {
        double baseCost = 10.0;
        
        String zipCode = order.getCustomer().getZipCode();
        if (zipCode.startsWith("0") || zipCode.startsWith("1")) {
            baseCost += 5.0;
        } else if (zipCode.startsWith("2")) {
            baseCost += 15.0;
        } else {
            baseCost += 25.0;
        }

        double totalOrderValue = order.getProduct().getPrice() * order.getQuantity();
        if (totalOrderValue > 500.0) {
            baseCost = 0.0;
        }

        if (order.getProduct().getName().toLowerCase().contains("heavy")) {
            baseCost += 50.0;
        }

        return baseCost;
    }
}