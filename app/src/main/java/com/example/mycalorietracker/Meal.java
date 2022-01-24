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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
