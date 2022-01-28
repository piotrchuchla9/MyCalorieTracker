package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class CallendarActivity extends AppCompatActivity {

    List<Day> days;

    DBRepository repository = new FakeRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callendar);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListView lvDays = (ListView)findViewById(R.id.callendarList);
        days = repository.getDays();

        DaysAdapter daysAdapter = new DaysAdapter(this, days);
        lvDays.setAdapter(daysAdapter);

        lvDays.setOnItemClickListener((adapterView, view, i, l) -> {
            Day d = days.get(i);
            Log.d("CallendarActivity", "Clicked " + d.getDayDate());

            openPastDaySummaryActivity(d);
        });

    }

    public void openPastDaySummaryActivity(Day d) {
        Intent intent = new Intent(this, PastDaySummaryActivity.class);

        Bundle b = new Bundle();
        b.putInt("dayId", d.getId());
        intent.putExtras(b);
        startActivity(intent);

        finish();
    }
}