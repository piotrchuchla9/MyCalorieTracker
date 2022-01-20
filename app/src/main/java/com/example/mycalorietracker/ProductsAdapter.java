package com.example.mycalorietracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productInfo;

        public ViewHolder(View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            productInfo = (TextView) itemView.findViewById(R.id.productInfo);
            productInfo.setClickable(true);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(view, pos, productInfo);
                        }
                    }
                }
            });
        }
    }



    private List<Product> products;

    public ProductsAdapter(List<Product> products, RecyclerViewInterface recyclerViewInterface) {
        this.products = products;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View productView = inflater.inflate(R.layout.recyclerview_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(productView, recyclerViewInterface);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);

        TextView textView = holder.productInfo;
        textView.setText(product.getProductName());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

}
