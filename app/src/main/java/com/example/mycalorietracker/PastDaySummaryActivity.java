package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PastDaySummaryActivity extends AppCompatActivity {

    private Button backMainActivity;
    private Button addPhotoButtonPast;
    private ImageButton callendarButtonPast;

    private TextView currentDayPast;
    private TextView calorieAmountPast;
    private TextView proteinAmountPast;
    private TextView carbsAmountPast;
    private TextView fatsAmountPast;

    private String today;

    List<Meal> meals;

    DBRepository repository = new FakeRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_day_summary);

        backMainActivity = (Button) findViewById(R.id.backMainButton);
        backMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, AddMeal.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle b = getIntent().getExtras();
        int dayId = -1;
        if(b != null) {
            dayId = b.getInt("dayId");
        }

        Day day = repository.getDay(dayId);
        ListView lvMeals = (ListView)findViewById(R.id.myMealsListPast);
        meals = repository.getMealsForDay(day.getId());
        day.setMeals(meals);

    }


}