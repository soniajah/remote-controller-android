package com.example.sonia.controller;

import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FancyControlActivity extends AppCompatActivity {
    final public String local_host ="http://192.168.0.10:8000/control";
    long previousTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancy_control);

        final Button mousePad = (Button)findViewById(R.id.MousePad);
        final ImageView mousePadMarker = (ImageView) findViewById(R.id.MousePadMarker);
        mousePadMarker.setX((mousePad.getWidth() - mousePadMarker.getWidth()) / 2);
        mousePadMarker.setY((mousePad.getHeight() - mousePadMarker.getHeight()) / 2);
        mousePad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    mousePadMarker.setX((mousePad.getWidth() - mousePadMarker.getWidth()) / 2);
                    mousePadMarker.setY((mousePad.getHeight() - mousePadMarker.getHeight()) / 2);
                } else {
                    mousePadMarker.setX(motionEvent.getX() - (mousePadMarker.getWidth()) / 2);
                    mousePadMarker.setY(motionEvent.getY() - (mousePadMarker.getHeight()) / 2);
                    int maxValue = 50;
                    int x = (int)(maxValue*((motionEvent.getX() - (mousePad.getWidth() / 2)) / (mousePad.getWidth() / 2)));
                    int y = (int)(maxValue*((motionEvent.getY() - (mousePad.getHeight() / 2)) / (mousePad.getHeight() / 2)));
                    if (x < -maxValue) {x = -maxValue;}
                    if (x > maxValue) {x = maxValue;}
                    if (y < -maxValue) { y = -maxValue;}
                    if (y > maxValue) {y = maxValue;}
                    Log.w("sonia", "x: " + x + ", xevent: " + motionEvent.getX() + " width: " + mousePad.getWidth());
                    long time = System.currentTimeMillis();
                    if (time - previousTime > 100) {
                        ControlCommands.moveButton(FancyControlActivity.this,
                                local_host,
                                x,
                                y,
                                view);
                        previousTime = time;
                    }
                }
                return false;
            }
        });
    }
}
