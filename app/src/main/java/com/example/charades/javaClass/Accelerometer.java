package com.example.charades.javaClass;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Accelerometer {
    final SensorManager sensorManager;
    final Sensor sensor;
    final SensorEventListener sensorEventListener;

    Listener listener;

    public void setListener(Listener l){
        listener = l;
    }

    public interface Listener{
        void onTransition(float rx, float ry,  float rz);
    }

    public Accelerometer(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(listener !=null){
                    listener.onTransition(sensorEvent.values[0], sensorEvent.values[1], sensorEvent.values[2]);
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
