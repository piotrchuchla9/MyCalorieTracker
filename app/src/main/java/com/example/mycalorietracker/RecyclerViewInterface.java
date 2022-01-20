package com.example.mycalorietracker;

import android.view.View;
import android.widget.TextView;

public interface RecyclerViewInterface {

    void onItemClick(View view, int position, TextView productInfo);

}
