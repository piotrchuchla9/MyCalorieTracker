package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class AddMeal extends AppCompatActivity {

    private Button addButton;
    private TextView selectedProduct;
    private EditText mealQuantity;

    List<Product> products;

    DBRepository repository = new FakeRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
    }

    public void openActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        selectedProduct = (TextView) findViewById(R.id.selectedProduct);
        mealQuantity = (EditText) findViewById(R.id.mealQuantity);

        selectedProduct.setVisibility(View.INVISIBLE);
        mealQuantity.setVisibility(View.INVISIBLE);



        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            Product p = (Product) selectedProduct.getTag();
            Meal meal = new Meal(0, p, Double.parseDouble(mealQuantity.getText().toString()));
            repository.insertMeal(meal);
            openActivityMain();
        });
        //list
        ListView lvProducts = (ListView)findViewById(R.id.productList);

        products = repository.getProducts();

        ProductsAdapter adapter = new ProductsAdapter(this, products);

        lvProducts.setAdapter(adapter);
        lvProducts.setOnItemClickListener((adapterView, view, i, l) -> {
            Product p = products.get(i);
            Log.d("AddMealActivity", "Clicked " + p.getProductName());

            selectedProduct.setVisibility(View.VISIBLE);
            mealQuantity.setVisibility(View.VISIBLE);

            selectedProduct.setText(p.getProductName());
            selectedProduct.setTag(p);
        });
    }

}