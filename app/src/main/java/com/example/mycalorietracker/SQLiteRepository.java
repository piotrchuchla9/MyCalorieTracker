package com.example.mycalorietracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SQLiteRepository implements DBRepository {

    private final DBHelper helper;

    public SQLiteRepository(Context context) {
        helper = DBHelper.getInstance(context);
    }

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
        List<Day> result = new ArrayList<>();
        var db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT id, day FROM Days",null);
        try {
            while (c.moveToNext()) {
                Day day = new Day(c.getInt(0), c.getString(1), null);
                result.add(day);
            }
        } finally {
            c.close();
        }
        return result;
    }

    @Override
    public void insertMeal(Meal meal) {
        long rowId = helper.insertMealData(meal.getProductId(), meal.getProductName(), meal.getCalories(), meal.getProteins(), meal.getCarbs(), meal.getFats(), meal.getQuantity(), meal.getDayId());
        meal.setId((int)rowId);
    }

    @Override
    public void insertDay(Day day) {
        long rowId = helper.insertDayData(day.getDayDate());
        day.setId((int)rowId);
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
