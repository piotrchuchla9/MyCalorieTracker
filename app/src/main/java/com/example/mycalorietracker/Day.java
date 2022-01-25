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


    //---------------------------------------


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayDate() {
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


    //---------------------------------------------


    public double getSumCalories() {
        double sum = 0;

        for(int i = 0; i < meals.size(); i++) {
            sum += meals.get(i).getCalories() * meals.get(i).getQuantity() / 100;
        }

        return sum;
    }

    public double getSumProteins() {
        double sum = 0;

        for(int i = 0; i < meals.size(); i++) {
            sum += meals.get(i).getProteins() * meals.get(i).getQuantity() / 100;
        }

        return sum;
    }

    public double getSumCarbs() {
        double sum = 0;

        for(int i = 0; i < meals.size(); i++) {
            sum += meals.get(i).getCarbs() * meals.get(i).getQuantity() / 100;
        }

        return sum;
    }

    public double getSumFats() {
        double sum = 0;

        for(int i = 0; i < meals.size(); i++) {
            sum += meals.get(i).getFats() * meals.get(i).getQuantity() / 100;
        }

        return sum;
    }
}
