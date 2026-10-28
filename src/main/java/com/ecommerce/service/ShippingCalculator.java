package com.ecommerce.service;

import com.ecommerce.model.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingCalculator {

    public double calculateShippingCost(Order order) {
        if (order == null) {
            return 0.0;
        }

        if (order.isEligibleForFreeShipping()) {
            return 0.0;
        }

        double baseCost = 10.0;
        baseCost += order.getCustomerRegionSurcharge();

        if (order.hasHeavyProduct()) {
            baseCost += 50.0;
        }

        return baseCost;
    }
}