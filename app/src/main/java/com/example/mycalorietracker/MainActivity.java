package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button addMealButton;
    private TextView currentDay;
    private TextView calorieAmount;
    private TextView proteinAmount;
    private TextView carbsAmount;
    private TextView fatsAmount;

    private String today;

    List<Meal> meals;

    DBRepository repository = new FakeRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addMealButton = (Button) findViewById(R.id.addMealButton);
        addMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddMealClass();
            }
        });
    }

    public void openAddMealClass() {
        Intent intent = new Intent(this, AddMeal.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();

        currentDay = (TextView) findViewById(R.id.currentDay);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        today = sdf.format(new Date());
        currentDay.setText(today);

        ListView lvMeals = (ListView)findViewById(R.id.myMealsList);
        meals = repository.getMeals();

        MealsAdapter mealsAdapter = new MealsAdapter(this, meals);
        lvMeals.setAdapter(mealsAdapter);

        Day day = new Day(2, today, meals);
        repository.insertDay(day);

        calorieAmount = (TextView) findViewById(R.id.calorieAmount);
        proteinAmount = (TextView) findViewById(R.id.proteinAmount);
        carbsAmount = (TextView) findViewById(R.id.carbsAmount);
        fatsAmount = (TextView) findViewById(R.id.fatsAmount);

        double sumCaloriesDouble = Double.valueOf(day.getSumCalories());
        String sumCaloriesString = String.format("%.01f", sumCaloriesDouble);
        double sumProteinsDouble = Double.valueOf(day.getSumProteins());
        String sumProteinsString = String.format("%.01f", sumProteinsDouble);
        double sumCarbsDouble = Double.valueOf(day.getSumCarbs());
        String sumCarbsString = String.format("%.01f", sumCarbsDouble);
        double sumFatsDouble = Double.valueOf(day.getSumFats());
        String sumFatsString = String.format("%.01f", sumFatsDouble);

        calorieAmount.setText(sumCaloriesString);
        proteinAmount.setText(sumProteinsString);
        carbsAmount.setText(sumCarbsString);
        fatsAmount.setText(sumFatsString);


    }
}