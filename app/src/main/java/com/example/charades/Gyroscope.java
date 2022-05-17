package com.example.charades;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.Toast;

public class Gyroscope {

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    private Listener listener;

    public void setListener(Listener l){
        listener = l;
    }

    public interface Listener{
        void onRotation(float rx, float ry,  float rz);
    }

    Gyroscope(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(sensor == null){
            Toast.makeText(context.getApplicationContext(), "Gyroscope not found!", Toast.LENGTH_SHORT).show();
        }
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(listener !=null){
                    listener.onRotation(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

    public void register(){
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void unRegister(){
        sensorManager.unregisterListener(sensorEventListener);
    }
}
