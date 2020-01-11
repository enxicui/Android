/*
* This is the main activity of the application
* from this activity, the user should be able to
* call other activities.
* */

package com.example.recycling;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    * open teh RecyclingList activity
    * */
    public void openRecycleList(View view) {
        Intent intent = new Intent(this, RecyclingList.class);
        startActivity(intent);
    }

    /*
    * open the food waste activity
    * */
    public void openFoodWasteActivity(View view) {
        Intent intent = new Intent(this, FoodWasteActivity.class);
        startActivity(intent);
    }

    /*
    * open the LargeItemActivity
    * */
    public void openLargeItemActivity(View view) {
        Intent intent = new Intent(this, LargeItemActivity.class);
        startActivity(intent);
    }

    /*
    * open the ElectronicActivity
    * */
    public void openElectronicActivity(View view) {
        Intent intent = new Intent(this, ElectronicActivity.class);
        startActivity(intent);
    }

    /*
    * open the RecycleStatActivity
    * */
    public void openDatabaseActivity(View view) {
        Intent intent = new Intent(this, RecycleStatActivity.class);
        startActivity(intent);
    }

    /*
    * open teh TextilesActivity
    * */
    public void openTextilesActivity(View view) {
        Intent intent = new Intent(this, TextilesActivity.class);
        startActivity(intent);
    }

    /*
    * open the HouseholdActivity
    * */
    public void openHouseholdActivity(View view) {
        Intent intent = new Intent(this, HouseholdActivity.class);
        startActivity(intent);
    }

    /*
    * open the WeatherActivity
    * */
    public void openWeatherActivity(View view) {
        Intent intent = new Intent(this, WeatherActivity.class);
        startActivity(intent);
    }
}
