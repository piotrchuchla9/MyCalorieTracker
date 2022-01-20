package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddMeal extends AppCompatActivity {

    private Button backMainButton;

    List<Product> products;

    DBRepository repository = new FakeRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
//        backMainButton = (Button) findViewById(R.id.backMainButton);
//        backMainButton.setOnClickListener(v -> openActivityMain());
    }

    public void openActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        backMainButton = (Button) findViewById(R.id.backMainButton);
        backMainButton.setOnClickListener(v -> openActivityMain());
        //list
        ListView lvProducts = (ListView)findViewById(R.id.productList);

        products = repository.getProducts();

        ProductsAdapter adapter = new ProductsAdapter(this, products);

        lvProducts.setAdapter(adapter);
        lvProducts.setOnItemClickListener((adapterView, view, i, l) -> {
            Product p = products.get(i);
            Log.d("AddMealActivity", "Clicked " + p.getProductName());
        });
    }

}