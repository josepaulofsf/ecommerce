package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    private String document;
    private String name;
    private String zipCode;
    private boolean active;

    public String getDocument() { return document; }
    public void setDocument(String document) { this.document = document; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}