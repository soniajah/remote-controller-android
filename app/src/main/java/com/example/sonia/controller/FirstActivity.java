package com.example.sonia.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Timer;
import java.util.TimerTask;

public class FirstActivity extends AppCompatActivity {
    final public String local_host ="http://192.168.0.10:8000/control";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);



//        Button left = (Button)findViewById(R.id.left);
//        left.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
//                    leftButton(view);
//                }
//                return false;
//            }
//        });
    }

    public void leftClickButton(View view){
        ControlCommands.leftClickButton(this, local_host, view);
    }

    public void rightClickButton(View view){
        ControlCommands.rightClickButton(this, local_host, view);
    }

    public void upButton(View view){
        ControlCommands.moveButton(this, local_host, 0, -5, view);
    }

    public void downButton(View view){
        ControlCommands.moveButton(this, local_host, 0, 5, view);

    }

    public void leftButton(View view){
        ControlCommands.moveButton(this, local_host, -5, 0, view);

    }

    public void rightButton(View view){
        ControlCommands.moveButton(this, local_host, 5, 0, view);
    }

    public void leftupButton(View view){
        ControlCommands.moveButton(this, local_host, -5, -5, view);
    }

    public void rightupButton(View view){
        ControlCommands.moveButton(this, local_host, 5, -5, view);

    }

    public void leftdownButton(View view){
        ControlCommands.moveButton(this, local_host, -5, 5, view);

    }

    public void rightdownButton(View view){
        ControlCommands.moveButton(this, local_host, 5, 5, view);

    }

    public void scrollingUp(View view){
        ControlCommands.scrollingUp(this, local_host, view);
    }

    public void scrollingDown(View view){
        ControlCommands.scrollingDown(this, local_host, view);
    }

    public void volumeUp(View view){
        ControlCommands.volumeUp(this, local_host, view);

    }

    public void volumeDown(View view){

        ControlCommands.volumeDown(this, local_host, view);

    }
}
