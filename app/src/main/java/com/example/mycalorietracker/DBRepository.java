package com.example.mycalorietracker;

import java.util.List;

public interface DBRepository {
    Meal getMealByDay(int dayId);
    Day getDay(int dayId);
    Product getProductById(int productId);
    List<Product> getProducts();
    List<Meal> getMeals();
    List<Day> getDays();

    void insertMeal(Meal meal);

    void insertDay(Day day);

    Day getCurrentDay();

    int getNextMealId();

    int getNextDayId();

    List<Meal> getMealsForDay(int dayId);

}
