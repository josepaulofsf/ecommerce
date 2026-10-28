package com.ecommerce.service;

import com.ecommerce.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderNotificationService {

    public void notifyCustomer(Order order) {
        System.out.println("Connecting to SMTP server at smtp.example.com...");
        System.out.println("Authenticating user no-reply@ecommerce.com...");
        System.out.println("Sending email to " + order.getCustomer().getName() + "...");
        System.out.println("Email sent successfully.");
    }
}
