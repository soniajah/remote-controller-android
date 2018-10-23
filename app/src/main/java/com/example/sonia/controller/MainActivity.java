package com.example.sonia.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startActivity(View view){
        // start activity
        Intent intent = new Intent(this, FirstActivity.class);
        startActivity(intent);
    }

    public void startFancyActivity(View view){
        // start activity
        Intent intent = new Intent(this, FancyControlActivity.class);
        startActivity(intent);
    }
}
