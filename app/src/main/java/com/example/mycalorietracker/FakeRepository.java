package com.example.mycalorietracker;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FakeRepository implements DBRepository {

    private List<Product> fakeProducts = new ArrayList<>();
    private static List<Meal> meals = new ArrayList<>();
    private static List<Day> days = new ArrayList<>();

    public FakeRepository() {
        fakeProducts.add(new Product(1,1, "Egg", 63, 5.5, 0.3, 4.2 ));
        fakeProducts.add(new Product(2,2, "White Bread", 50, 1.5, 0.8, 1 ));
        fakeProducts.add(new Product(3,3, "Rice", 340.6, 6, 78, 0.5 ));

        days.add(new Day(1, "24 January 2022", meals));
    }



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
    public void insertMeal(Meal meal) {
        meals.add(meal);
    }

    @Override
    public void insertDay(Day day) { days.add(day); }

    @Override
    public Day getCurrentDay(Day day) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String today = sdf.format(new Date());

        if(getDay(days.size()-1).getDay().equals(today)) {
            return day;
        } else {
            return null;
        }

    }

}
