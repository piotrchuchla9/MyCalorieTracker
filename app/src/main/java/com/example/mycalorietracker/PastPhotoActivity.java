package com.example.mycalorietracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PastPhotoActivity extends AppCompatActivity {

    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    public static final int CAMERA_ACTION_CODE = 1;
    public static final int REQUEST_CODE = 100;

    private ImageView myPhotoPast;
    private TextView noPhotoPast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_photo);

        myPhotoPast = (ImageView) findViewById(R.id.myPhotoPast);
        noPhotoPast = (TextView) findViewById(R.id.noPhotoPast);

        Bundle bun = getIntent().getExtras();
        String day = "";
        if(bun != null) {
            day = bun.getString("day");
        }

        String photoPath = getFilesDir() + "/SaveImage/" + day + ".jpg";

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap btmap = BitmapFactory.decodeFile(photoPath, options);
        myPhotoPast.setImageBitmap(btmap);




        if(myPhotoPast.getDrawable() == null) {
            noPhotoPast.setVisibility(View.VISIBLE);
        } else {
            noPhotoPast.setVisibility(View.INVISIBLE);
        }
    }
}