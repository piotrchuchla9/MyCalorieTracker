package com.example.mycalorietracker;

import java.util.List;

public class SQLiteRepository implements DBRepository {


    @Override
    public Meal getMealByDay(int dayId) {
        return null;
    }

    @Override
    public Day getDay(int dayId) {
        return null;
    }

    @Override
    public Product getProductById(int productId) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Meal> getMeals() {
        return null;
    }

    @Override
    public List<Day> getDays() {
        return null;
    }

    @Override
    public void insertMeal(Meal meal) {

    }

    @Override
    public void insertDay(Day day) {

    }

    @Override
    public Day getCurrentDay() {
        return null;
    }

    @Override
    public int getNextMealId() {
        return 0;
    }

    @Override
    public int getNextDayId() {
        return 0;
    }

    @Override
    public List<Meal> getMealsForDay(int dayId) {
        return null;
    }
}
