package com.example.mycalorietracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DaysAdapter extends ArrayAdapter<Day> {

    public DaysAdapter(Context context, List<Day> days) { super(context, 0, days); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Day day = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_row_callendar, parent, false);
        }
        // Lookup view for data population
        TextView productInfo = (TextView) convertView.findViewById(R.id.dayInfo);
        productInfo.setText(day.getDayDate());

        // Return the completed view to render on screen
        return convertView;
    }

}
