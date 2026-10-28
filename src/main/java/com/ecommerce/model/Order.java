package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Customer customer;
    
    @ManyToOne
    private Product product;
    
    private int quantity;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double calculateTotalValue() {
        if (this.product == null) {
            return 0.0;
        }
        return this.product.getPrice() * this.quantity;
    }

    public boolean isEligibleForFreeShipping() {
        return calculateTotalValue() > 500.0;
    }

    public boolean hasHeavyProduct() {
        return this.product != null && this.product.isHeavy();
    }

    public double getCustomerRegionSurcharge() {
        if (this.customer == null) {
            return 25.0;
        }
        return this.customer.getRegionShippingSurcharge();
    }
}