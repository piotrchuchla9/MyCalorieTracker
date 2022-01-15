package com.example.mycalorietracker;

public class Product {

    private int productId;
    private String productName;
    private double calories;
    private double proteins;
    private double carbs;
    private double fats;

    public Product(int productId, String productName, double calories, double proteins, double carbs, double fats) {
        this.productId = productId;
        this.productName = productName;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
    }
}
