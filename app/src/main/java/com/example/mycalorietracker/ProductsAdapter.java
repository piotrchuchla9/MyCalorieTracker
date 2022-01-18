package com.example.mycalorietracker;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productInfo;

        public ViewHolder(View itemView) {
            super(itemView);

            productInfo = (TextView) itemView.findViewById(R.id.productInfo);
        }

        DBRepository fakeRepository = new FakeRepository();

        private List<Product> products;


        public ProductsAdapter(List<Product> products) {
            this.products = products;
        }

        public void onBindViewHolder(ProductsAdapter.ViewHolder holder, int position) {
            Product product = products.get(position);

            TextView textView = holder.productInfo;
            textView.setText(product);

        }

        public int getItemCount() {
            return products.size();
        }

    }



}
