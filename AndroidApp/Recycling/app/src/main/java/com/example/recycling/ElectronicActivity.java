/*
* This is the class for the electronic activity
* */

package com.example.recycling;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ElectronicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic);
    }

    /*
    * When the user click the image
    * it will call another activity from an external application
    * here it should call the YouTube application
    * */
    public void openVideo(View view) {
        String url = view.getTag().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
