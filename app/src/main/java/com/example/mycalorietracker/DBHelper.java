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

    private static DBHelper sInstance;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    public static synchronized DBHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (sInstance == null) {
            sInstance = new DBHelper(context.getApplicationContext());
        }
        return sInstance;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + PRODUCTS_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, productName TEXT, calories REAL, proteins REAL, carbs REAL, fats REAL)");
        db.execSQL("CREATE TABLE " + MEALS_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, productId INTEGER, productName TEXT, calories REAL, proteins REAL, carbs REAL, fats REAL, quantity REAL, dayId INTEGER, FOREIGN KEY(productId) REFERENCES Products(id), FOREIGN KEY(dayId) REFERENCES Days(id))");
        db.execSQL("CREATE TABLE " + DAYS_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, day TEXT)");

        String product1 = "INSERT INTO " + PRODUCTS_TABLE + " (" + PRODUCTS_PRODUCT_NAME + ", " + PRODUCTS_CALORIES + ", " + PRODUCTS_PROTEINS + ", " + PRODUCTS_CARBS + ", " + PRODUCTS_FATS + ") VALUES ('Egg', '63', '5.5', '0.3', '4.2')";
        String product2 = "INSERT INTO " + PRODUCTS_TABLE + " (" + PRODUCTS_PRODUCT_NAME + ", " + PRODUCTS_CALORIES + ", " + PRODUCTS_PROTEINS + ", " + PRODUCTS_CARBS + ", " + PRODUCTS_FATS + ") VALUES ('White Bread', '50', '1.5', '0.8', '1')";
        String product3 = "INSERT INTO " + PRODUCTS_TABLE + " (" + PRODUCTS_PRODUCT_NAME + ", " + PRODUCTS_CALORIES + ", " + PRODUCTS_PROTEINS + ", " + PRODUCTS_CARBS + ", " + PRODUCTS_FATS + ") VALUES ('Rice', '340.6', '6', '78', '0.8')";

        db.execSQL(product1);
        db.execSQL(product2);
        db.execSQL(product3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        SQLiteDatabase.openDatabase("mydb",null, SQLiteDatabase.OPEN_READWRITE);
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCTS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MEALS_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DAYS_TABLE);
        onCreate(db);
    }

//    public long insertProductData(String productName, double caloreis, double proteins, double carbs, double fats) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(PRODUCTS_PRODUCT_NAME, productName);
//        contentValues.put(PRODUCTS_CALORIES, caloreis);
//        contentValues.put(PRODUCTS_PROTEINS, proteins);
//        contentValues.put(PRODUCTS_CARBS, carbs);
//        contentValues.put(PRODUCTS_FATS, fats);
//        long result = db.insert(PRODUCTS_TABLE, null, contentValues);
//        return result;
//    }

    public long insertMealData(int productId, String productName, double caloreis, double proteins, double carbs, double fats, double quantity, int dayId) {
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
        return result;
    }

    public long insertDayData(String day) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DAY_DAY, day);
        long result = db.insert(DAYS_TABLE, null, contentValues);
        return result;
    }


}