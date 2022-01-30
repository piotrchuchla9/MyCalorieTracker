package com.example.mycalorietracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyCalorieTracker.db";

    public static final String PRODUCTS_TABLE = "Products";
    public static final String PRODUCTS_ID = "id";
    public static final String PRODUCTS_PRODUCT_NAME = "productName";
    public static final String PRODUCTS_CALORIES = "calories";
    public static final String PRODUCTS_PROTEINS = "proteins";
    public static final String PRODUCTS_CARBS = "carbs";
    public static final String PRODUCTS_FATS = "fats";

    public static final String MEALS_TABLE = "Meals";
    public static final String MEAL_ID = "id";
    public static final String MEAL_PRODUCT_ID = "productId";
    public static final String MEAL_PRODUCT_NAME = "productName";
    public static final String MEAL_CALORIES = "calories";
    public static final String MEAL_PROTEINS = "proteins";
    public static final String MEAL_CARBS = "carbs";
    public static final String MEAL_FATS = "fats";
    public static final String MEAL_QUANTITY = "quantity";
    public static final String MEAL_DAY_ID = "dayId";

    public static final String DAYS_TABLE = "Days";
    public static final String DAY_ID = "id";
    public static final String DAY_DAY = "day";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PRODUCTS_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, productName TEXT, calories REAL, proteins REAL, carbs REAL, fats REAL)");
        db.execSQL("CREATE TABLE " + MEALS_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, productId INTEGER, productName TEXT, calories REAL, proteins REAL, carbs REAL, fats REAL, quantity REAL, dayId INTEGER, FOREIGN KEY(productId) REFERENCES Products(id), FOREIGN KEY(dayId) REFERENCES Days(id))");
        db.execSQL("CREATE TABLE " + DAYS_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, day TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCTS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MEALS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DAYS_TABLE);
        onCreate(db);
    }

    public boolean insertProductData(String productName, double caloreis, double proteins, double carbs, double fats) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCTS_PRODUCT_NAME, productName);
        contentValues.put(PRODUCTS_CALORIES, caloreis);
        contentValues.put(PRODUCTS_PROTEINS, proteins);
        contentValues.put(PRODUCTS_CARBS, carbs);
        contentValues.put(PRODUCTS_FATS, fats);
        long result = db.insert(PRODUCTS_TABLE, null, contentValues);
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertMealData(int productId, String productName, double caloreis, double proteins, double carbs, double fats, double quantity, int dayId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MEAL_PRODUCT_ID, productId);
        contentValues.put(MEAL_PRODUCT_NAME, productName);
        contentValues.put(MEAL_CALORIES, caloreis);
        contentValues.put(MEAL_PROTEINS, proteins);
        contentValues.put(MEAL_CARBS, carbs);
        contentValues.put(MEAL_FATS, fats);
        contentValues.put(MEAL_QUANTITY, quantity);
        contentValues.put(MEAL_DAY_ID, dayId);
        long result = db.insert(MEALS_TABLE, null, contentValues);
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertDayData(String day) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DAY_ID, day);
        long result = db.insert(DAYS_TABLE, null, contentValues);
        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }


}
