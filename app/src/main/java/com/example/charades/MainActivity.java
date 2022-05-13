package com.example.charades;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Accelerometer accelerometer;
    private Gyroscope gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accelerometer = new Accelerometer(this);
        gyroscope = new Gyroscope(this);

        gyroscope.setListener(new Gyroscope.Listener() {
            @Override
            public void onRotation(float rx, float ry, float rz) {
                if(rz > 5.0f){
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                } else if(rz < -5.0f){
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }

                if(ry > 5.0f){
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                } else if(ry < -5.0f){
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        accelerometer.register();
        gyroscope.register();
    }

    @Override
    protected void onPause() {
        super.onPause();

        accelerometer.unRegister();
        gyroscope.unRegister();
    }
}