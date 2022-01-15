package com.example.mycalorietracker;

public interface DBRepository {
    public Meal getMealByDay(int dayId);
    public Day getDay(int dayId);
    public Product getProductById(int productId);
}
