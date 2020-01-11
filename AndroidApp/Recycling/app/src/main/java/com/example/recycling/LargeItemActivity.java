/*
* This is the class of large Item Activity
*
* */

package com.example.recycling;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LargeItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_item);
    }

    /*
    * The method will be called when the user click the image of the video
    * it call a activity from other application
    * */
    public void openVideo1(View view) {
        String url = view.getTag().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
