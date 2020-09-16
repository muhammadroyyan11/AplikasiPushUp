package com.royyan.aplikasipushup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.royyan.aplikasipushup.databinding.ActivityPushUpBinding;

public class PushUpActivity extends AppCompatActivity {

    //TextView TextCount;

    private int counter = 0;
    private ActivityPushUpBinding binding;
    private SensorManager sensorManager;
    private Sensor proximitySensor;
    private SensorEventListener proximitySensorListener;

//    public LayoutInflater getLayoutInflater() {
//        return super.getLayoutInflater();
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //counter ++;

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_push_up);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_push_up);
        binding.textPushupCount.setText("0");
        //binding.containerPushupCounter.setOnClickListener(counter +);
        binding.containerPushupCounter.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                counter++;
                binding.textPushupCount.setText("" + counter);
            }
        });

//        TextCount = findViewById(R.id.text_pushup_count);
//        TextCount.setText("0");
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        if (proximitySensor == null) {
            Toast.makeText(this, "Proximity sensor tidak tersedia" , Toast.LENGTH_LONG).show();
            finish();
        }

        proximitySensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                    if (event.values[0] == 0) {
                        counter++;
                        binding.textPushupCount.setText("" + counter);
                    } else {
                        binding.textPushupCount.getText();
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sensorManager.registerListener(proximitySensorListener, proximitySensor, 2 * 1000 * 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(proximitySensorListener);
    }
}