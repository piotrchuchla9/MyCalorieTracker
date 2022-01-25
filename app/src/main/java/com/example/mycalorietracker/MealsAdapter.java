package com.example.mycalorietracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class MealsAdapter extends ArrayAdapter<Meal> {

    public MealsAdapter(Context context, List<Meal> meals) { super(context, 0, meals); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Meal meal = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_row_main, parent, false);
        }
        // Lookup view for data population
        TextView productInfo = (TextView) convertView.findViewById(R.id.productInfo);
        productInfo.setText(meal.getProductName());

        TextView productAmount = (TextView) convertView.findViewById(R.id.productAmount);
        productAmount.setText(String.valueOf(meal.getQuantity()) + "g");

        // Return the completed view to render on screen
        return convertView;
    }

}
