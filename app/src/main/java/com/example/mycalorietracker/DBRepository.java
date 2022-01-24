package com.example.mycalorietracker;

import java.util.List;

public interface DBRepository {
    Meal getMealByDay(int dayId);
    Day getDay(int dayId);
    Product getProductById(int productId);
    List<Product> getProducts();

    void insertMeal(Meal meal);

    void insertDay(Day day);

    Day getCurrentDay(Day day);
}
