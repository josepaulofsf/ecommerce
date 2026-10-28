package com.ecommerce.service;

import com.ecommerce.model.Order;
import com.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class OrderProcessingService {

    private final OrderRepository orderRepository;

    public OrderProcessingService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void processOrderAndDoEverything(Order order) {
        if (order.getCustomer() == null || !order.getCustomer().isActive()) {
            throw new RuntimeException("Invalid customer");
        }
        if (order.getProduct() == null || order.getProduct().getPrice() <= 0) {
            throw new RuntimeException("Invalid product");
        }
        if (order.getQuantity() > 100) {
            throw new RuntimeException("Quantity exceeds limit");
        }

        order.setStatus("PROCESSED");
        orderRepository.save(order);

        try {
            FileWriter writer = new FileWriter("c:\\temp\\invoice_" + order.getId() + ".txt");
            writer.write("INVOICE\n");
            writer.write("Customer: " + order.getCustomer().getName() + "\n");
            writer.write("Product: " + order.getProduct().getName() + "\n");
            writer.write("Total: " + (order.getProduct().getPrice() * order.getQuantity()) + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Connecting to SMTP server at smtp.example.com...");
        System.out.println("Authenticating user no-reply@ecommerce.com...");
        System.out.println("Sending email to " + order.getCustomer().getName() + "...");
        System.out.println("Email sent successfully.");

        try {
            FileWriter logWriter = new FileWriter("c:\\temp\\system_audit_log.txt", true);
            logWriter.write("Order " + order.getId() + " processed for customer " + order.getCustomer().getDocument() + "\n");
            logWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}