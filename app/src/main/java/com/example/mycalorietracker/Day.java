package com.example.mycalorietracker;

import java.util.List;

public class Day {

    List<Meal> meals;

    private int id;
    private String day;
    private double calories;
    private double proteins;
    private double carbs;
    private double fats;
    private double quantity;

    public Day(int id, String day, double calories, double proteins, double carbs, double fats, double quantity) {
        this.id = id;
        this.day = day;
        this.calories = calories;
        this.proteins = proteins;
        this.carbs = carbs;
        this.fats = fats;
        this.quantity = quantity;
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
