package com.ecommerce.service;

import com.ecommerce.model.Order;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class InvoiceService {

    public void generate(Order order) {
        try (FileWriter writer = new FileWriter("c:\\temp\\invoice_" + order.getId() + ".txt")) {
            writer.write("INVOICE\n");
            writer.write("Customer: " + order.getCustomer().getName() + "\n");
            writer.write("Product: " + order.getProduct().getName() + "\n");
            writer.write("Total: " + (order.getProduct().getPrice() * order.getQuantity()) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
