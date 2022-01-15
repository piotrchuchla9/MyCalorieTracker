package com.example.mycalorietracker;

public class Meal {

    private int mealId;
    private int productId;
    private String productName;
    private double calories;
    private double proteins;
    private double carbs;
    private double fats;

    public Meal(int mealId, int productId, String productName, double calories, double proteins, double carbs, double fats) {
        this.mealId = mealId;
        this.productId = productId;
        this.productName = productName;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
    }


}
