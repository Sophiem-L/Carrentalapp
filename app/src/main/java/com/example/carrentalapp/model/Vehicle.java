package com.example.carrentalapp.model;

public class Vehicle {
    private String name;
    private String price;

    public Vehicle(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public String getPrice() { return price; }
}

