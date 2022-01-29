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

        callendarButtonPast = (ImageButton) findViewById(R.id.callendarButtonPast);
        callendarButtonPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCallendarClass();
            }
        });

        addPhotoButtonPast = (Button) findViewById(R.id.addPhotoButtonPast);
        addPhotoButtonPast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPastPhotoActivity(currentDayPast.getText().toString());
            }
        });
    }

    public void openCallendarClass() {
        Intent intent = new Intent(this, CallendarActivity.class);
        startActivity(intent);
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openPastPhotoActivity(String day) {
        Intent intent = new Intent(this, PastPhotoActivity.class);

        Bundle bun = new Bundle();
        bun.putString("day", day);
        intent.putExtras(bun);

        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle b = getIntent().getExtras();
        int dayId = -1;
        if(b != null) {
            dayId = b.getInt("dayId");
        }

        Day day = repository.getDay(dayId-1);
        ListView lvMeals = (ListView)findViewById(R.id.myMealsListPast);
        meals = repository.getMealsForDay(day.getId());
        day.setMeals(meals);

        MealsAdapter mealsAdapter = new MealsAdapter(this, meals);
        lvMeals.setAdapter(mealsAdapter);

        currentDayPast = (TextView) findViewById(R.id.currentDayPast);
        String thatDay = day.getDayDate();
        currentDayPast.setText(thatDay);



        calorieAmountPast = (TextView) findViewById(R.id.calorieAmountPast);
        proteinAmountPast = (TextView) findViewById(R.id.proteinAmountPast);
        carbsAmountPast = (TextView) findViewById(R.id.carbsAmountPast);
        fatsAmountPast = (TextView) findViewById(R.id.fatsAmountPast);

        double sumCaloriesDouble = Double.valueOf(day.getSumCalories());
        String sumCaloriesString = String.format("%.01f", sumCaloriesDouble);
        double sumProteinsDouble = Double.valueOf(day.getSumProteins());
        String sumProteinsString = String.format("%.01f", sumProteinsDouble);
        double sumCarbsDouble = Double.valueOf(day.getSumCarbs());
        String sumCarbsString = String.format("%.01f", sumCarbsDouble);
        double sumFatsDouble = Double.valueOf(day.getSumFats());
        String sumFatsString = String.format("%.01f", sumFatsDouble);

        calorieAmountPast.setText(sumCaloriesString);
        proteinAmountPast.setText(sumProteinsString);
        carbsAmountPast.setText(sumCarbsString);
        fatsAmountPast.setText(sumFatsString);

    }


}