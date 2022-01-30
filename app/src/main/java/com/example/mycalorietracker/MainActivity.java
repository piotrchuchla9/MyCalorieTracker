package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button addMealButton;
    private Button addPhotoButton;
    private ImageButton callendarButton;

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

        addPhotoButton = (Button) findViewById(R.id.addPhotoButton);
        addPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddPhotoClass();
            }
        });

        callendarButton = (ImageButton) findViewById(R.id.callendarButton);
        callendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCallendarClass();
            }
        });
    }

    public void openAddMealClass() {
        Intent intent = new Intent(this, AddMeal.class);
        startActivity(intent);
    }

    public void openAddPhotoClass() {
        Intent intent = new Intent(this, PhotoActivity.class);
        startActivity(intent);
    }

    public void openCallendarClass() {
        Intent intent = new Intent(this, CallendarActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();

        currentDay = (TextView) findViewById(R.id.currentDay);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        today = sdf.format(new Date());
        currentDay.setText(today);

        Day day = repository.getCurrentDay();
        if(day == null) {
            day = new Day(repository.getNextDayId(), today, new ArrayList<Meal>());
            repository.insertDay(day);
        }

        ListView lvMeals = (ListView)findViewById(R.id.myMealsList);
        meals = repository.getMealsForDay(day.getId());
        day.setMeals(meals);

        MealsAdapter mealsAdapter = new MealsAdapter(this, meals);
        lvMeals.setAdapter(mealsAdapter);


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