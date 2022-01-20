package com.example.mycalorietracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsAdapter extends ArrayAdapter<Product> {

    public ProductsAdapter(Context context, List<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_row, parent, false);
        }
        // Lookup view for data population
        TextView productInfo = (TextView) convertView.findViewById(R.id.productInfo);
        productInfo.setText(product.getProductName());
        // Return the completed view to render on screen
        return convertView;
    }
}
