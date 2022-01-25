package com.example.mycalorietracker;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FakeRepository implements DBRepository {

    private List<Product> fakeProducts = new ArrayList<Product>(Arrays.asList(
            new Product(1,1, "Egg", 63, 5.5, 0.3, 4.2 ),
            new Product(2,2, "White Bread", 50, 1.5, 0.8, 1 ),
            new Product(3,3, "Rice", 340.6, 6, 78, 0.5 )
    ));
    private static List<Meal> meals = new ArrayList<>();
    private static List<Day> days = new ArrayList<Day>(Arrays.asList(new Day(1, "24 January 2022", Arrays.asList(new Meal(1, new Product(1,1, "Egg", 63, 5.5, 0.3, 4.2 ), 50, 1)))));

    public FakeRepository() { }

    @Override
    public Meal getMealByDay(int dayId) {
        return null;
    }

    @Override
    public Day getDay(int dayId) { return days.get(dayId); }

    @Override
    public Product getProductById(int productId) {
        return fakeProducts.get(productId);
    }

    @Override
    public List<Product> getProducts() {
        return fakeProducts;
    }

    @Override
    public List<Meal> getMeals() { return meals; }

    @Override
    public void insertMeal(Meal meal) {
        meals.add(meal);
    }

    @Override
    public void insertDay(Day day) { days.add(day); }

    @Override
    public Day getCurrentDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String today = sdf.format(new Date());

        if(getDay(days.size()-1).getDayDate().equals(today)) {
            return getDay(days.size()-1);
        } else {
            return null;
        }

    }

    @Override
    public int getNextMealId() {
        return meals.size() + 1;
    }

    @Override
    public int getNextDayId() {
        return days.size() + 1;
    }

    @Override
    public List<Meal> getMealsForDay(int dayId) {
        return meals.stream().filter(meal -> meal.getDayId() == dayId).collect(Collectors.toList());
    }

}
