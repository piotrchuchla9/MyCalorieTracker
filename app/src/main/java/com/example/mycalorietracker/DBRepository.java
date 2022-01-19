package com.example.mycalorietracker;

import java.util.List;

public interface DBRepository {
    public Meal getMealByDay(int dayId);
    public Day getDay(int dayId);
    public Product getProductById(int productId);
    public List<Product> getProducts();
}
