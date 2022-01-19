package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddMeal extends AppCompatActivity implements RecyclerViewInterface{

    private Button backMainButton;
    private TextView takeProduct = (TextView) findViewById(R.id.productInfo);

    List<Product> products;

    DBRepository repository = new FakeRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);

        backMainButton = (Button) findViewById(R.id.backMainButton);
        backMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });
    }

    public void openActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();


        //list
        RecyclerView rvProducts = (RecyclerView)findViewById(R.id.productList);

        products = repository.getProducts();

        ProductsAdapter adapter = new ProductsAdapter(products, this);

        rvProducts.setAdapter(adapter);
        rvProducts.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public void onItemClick(int position) {
        takeProduct.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Product ID = " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


}