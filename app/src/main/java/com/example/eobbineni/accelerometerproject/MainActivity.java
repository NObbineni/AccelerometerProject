package com.example.eobbineni.accelerometerproject;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView xText;
    TextView yText;
    TextView zText;
    double x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //20324
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xText = (TextView)findViewById(R.id.textView1);
        yText = (TextView)findViewById(R.id.textView2);
        zText = (TextView)findViewById(R.id.textView3);

        SensorManager sensorManager =  (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor accelSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelSensor , SensorManager.SENSOR_DELAY_NORMAL);

       // xText.setText(accelSensor.);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            x=sensorEvent.values[0];
            y=sensorEvent.values[1];
            z=sensorEvent.values[2];
        }
        xText.setText("X-Axis: "+x);
        yText.setText("Y-Axis: "+y);
        zText.setText("Z-Axis: "+z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}