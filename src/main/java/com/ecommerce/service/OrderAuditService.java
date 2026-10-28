package com.ecommerce.service;

import com.ecommerce.model.Order;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class OrderAuditService {

    public void record(Order order) {
        try (FileWriter writer = new FileWriter("c:\\temp\\system_audit_log.txt", true)) {
            writer.write("Order " + order.getId() + " processed for customer "
                    + order.getCustomer().getDocument() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
