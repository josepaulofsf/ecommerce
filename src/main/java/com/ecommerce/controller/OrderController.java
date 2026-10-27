package com.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/api/orders")
    public String createOrder(@RequestParam String customerDocument) {
        String cleanDocument = customerDocument.replaceAll("[^0-9]", "");
        
        if (cleanDocument.length() != 11 && cleanDocument.length() != 14) {
            return "Invalid document length";
        }
        
        boolean allDigitsEqual = true;
        for (int i = 1; i < cleanDocument.length(); i++) {
            if (cleanDocument.charAt(i) != cleanDocument.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual) {
            return "Document cannot have all equal digits";
        }

        return "Order created for customer " + cleanDocument;
    }
}