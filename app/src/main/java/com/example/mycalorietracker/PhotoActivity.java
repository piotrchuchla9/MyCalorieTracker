package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoActivity extends AppCompatActivity {

    ImageView myPhoto;

    TextView noPhoto;

    Button makePhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
    }

    @Override
    public void onStart() {
        super.onStart();

        myPhoto = (ImageView) findViewById(R.id.myPhoto);
        noPhoto = (TextView) findViewById(R.id.noPhoto);

        if(myPhoto.getDrawable() == null) {
            noPhoto.setVisibility(View.VISIBLE);
        } else {
            noPhoto.setVisibility(View.INVISIBLE);
        }

    }


}