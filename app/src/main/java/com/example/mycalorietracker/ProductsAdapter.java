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

    private final ListViewInterface listViewInterface;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView productInfo;

        public ViewHolder(View itemView, ListViewInterface listViewInterface) {
            super(itemView);

            productInfo = (TextView) itemView.findViewById(R.id.productInfo);
            productInfo.setClickable(true);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listViewInterface != null) {
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION) {
                            listViewInterface.onItemClick(view, pos, productInfo);
                        }
                    }
                }
            });
        }
    }

    private List<Product> products;

    public ProductsAdapter(List<Product> products, ListViewInterface listViewInterface) {
        this.products = products;
        this.listViewInterface = listViewInterface;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View productView = inflater.inflate(R.layout.listview_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(productView, listViewInterface);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Product product = products.get(position);

        TextView textView = holder.productInfo;
        textView.setText(product.getProductName());
    }


    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);

        TextView textView = holder.productInfo;
        textView.setText(product.getProductName());
    }

    public int getItemCount() {
        return products.size();
    }

}
