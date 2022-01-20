package com.example.mycalorietracker;

public class Meal {

    private int id;
    private int productId;
    private String productName;
    private double calories;
    private double proteins;
    private double carbs;
    private double fats;
    private double quantity;

    public Meal(int id, int productId, String productName, double calories, double proteins, double carbs, double fats) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
    }

    public Meal(int id, Product p, double quantity) {
        this(id, p.getProductId(), p.getProductName(), p.getCalories(), p.getProteins(), p.getCarbs(), p.getFats());
        this.quantity = quantity;
    }

}
