package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String color;

    public void applyDiscountAndCalculateTaxes(double percentage) {
        this.price = this.price - (this.price * percentage / 100);
        this.price = this.price + (this.price * 0.15);
    }

    public String generateHtmlCardForUI() {
        return "<div class='product-card'>" +
               "<h1>" + this.name.toUpperCase() + "</h1>" +
               "<p style='color:" + this.color + "'>Price: $" + this.price + "</p>" +
               "<button onclick='buy(" + this.id + ")'>Buy Now</button>" +
               "</div>";
    }

    public String getJsonRepresentationForApi() {
        return "{\"productId\":\"" + this.id + "\",\"title\":\"" + this.name + "\"}";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}