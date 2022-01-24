package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button addMealButton;
    private TextView currentDay;

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

        currentDay = (TextView) findViewById(R.id.currentDay);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String today = sdf.format(new Date());
        currentDay.setText(today);


    }

    public void openAddMealClass() {
        Intent intent = new Intent(this, AddMeal.class);
        startActivity(intent);
    }
}