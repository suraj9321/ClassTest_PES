package com.example.surajsah.contactmap;


import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public abstract class SensorActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mTemperature;
    private Sensor mLight;
    private Sensor mProximity;
    private Sensor mAcceleration;
    boolean capturingData = true;
    TextView X_value;
    TextView Y_value;
    TextView Z_value;
    TextView Proxi;
    TextView Temp;
    TextView Light;
    Button plotProxi;
    Button plotTemp;
    Button plotLight;
    Button plotAcceleration;


    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mTemperature = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mAcceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        X_value = (TextView) findViewById(R.id.textView12);
        Y_value = (TextView) findViewById(R.id.textView13);
        Z_value = (TextView) findViewById(R.id.textView14);
        Proxi= (TextView) findViewById(R.id.textView5);
        Temp= (TextView) findViewById(R.id.textView6);
        Light= (TextView) findViewById(R.id.textView7);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {

        if(sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
           /* delay++;
            if (delay == 1) {
                delay = 0;
            }*/

            float x, y, z;
            x = sensorEvent.values[0];
            y = sensorEvent.values[1];
            z = sensorEvent.values[2];

            X_value.setText(Float.toString(x));
            Y_value.setText(Float.toString(y));
            Z_value.setText(Float.toString(z));

        }

        if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {


            float a;
            a=sensorEvent.values[0];

            Proxi.setText(Float.toString(a));


        }

        if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {


            float b;
            b=sensorEvent.values[0];

            Light.setText(Float.toString(b));


        }

        if (sensorEvent.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {


            float c;
            c=sensorEvent.values[0];

            Temp.setText(Float.toString(c));


        }





    }
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}