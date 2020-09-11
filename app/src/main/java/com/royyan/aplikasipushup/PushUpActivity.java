package com.royyan.aplikasipushup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.royyan.aplikasipushup.databinding.ActivityPushUpBinding;

public class PushUpActivity extends AppCompatActivity {

    private int counter = 0;
    private ActivityPushUpBinding binding;

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
    }
}