package com.example.mycalorietracker;

import java.util.List;

public class Day {

    private int id;
    private String day;
    List<Meal> meals;

    public Day(int id, String day, List<Meal> meals) {
        this.id = id;
        this.day = day;
        this.meals = meals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    //    public double getSumCalories {
//        // sumuje kalorie meals
//    }
//
//    public double getSumProteins {
//        // sumuje proteiny meals
//    }
//
//    public double getSumCarbs {
//        // sumuje węgle meals
//    }
//
//    public double getSumFats {
//        // sumuje tłuszcze meals
//    }
}
