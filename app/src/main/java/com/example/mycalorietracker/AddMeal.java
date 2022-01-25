package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddMeal extends AppCompatActivity {

    private Button addButton;
    private TextView selectedProduct;
    private EditText mealQuantity;
    private TextView gram;

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
        gram = (TextView) findViewById(R.id.gram);
        addButton = (Button) findViewById(R.id.addButton);

        addButton.setVisibility(View.INVISIBLE);
        selectedProduct.setVisibility(View.INVISIBLE);
        mealQuantity.setVisibility(View.INVISIBLE);
        gram.setVisibility(View.INVISIBLE);


        addButton.setOnClickListener(v -> {
            Product p = (Product) selectedProduct.getTag();
            Meal meal = new Meal(0, p, Double.parseDouble(mealQuantity.getText().toString()));

            if(mealQuantity.getText().toString().equals("0")) {
                Context context = getApplicationContext();
                Toast noInput = Toast.makeText(context, "First insert amount!", Toast.LENGTH_SHORT);
                noInput.show();
            } else {
                repository.insertMeal(meal);
                openActivityMain();
            }

        });
        //list
        ListView lvProducts = (ListView)findViewById(R.id.productList);

        products = repository.getProducts();

        ProductsAdapter productsAdapter = new ProductsAdapter(this, products);

        lvProducts.setAdapter(productsAdapter);
        lvProducts.setOnItemClickListener((adapterView, view, i, l) -> {
            Product p = products.get(i);
            Log.d("AddMealActivity", "Clicked " + p.getProductName());

            selectedProduct.setVisibility(View.VISIBLE);
            mealQuantity.setVisibility(View.VISIBLE);
            gram.setVisibility(View.VISIBLE);
            addButton.setVisibility(View.VISIBLE);

            selectedProduct.setText(p.getProductName());
            selectedProduct.setTag(p);
            mealQuantity.setHint("insert");
        });
    }

}