package com.example.dinn.bmiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickEnter(View view){
        Intent intent = new Intent(this,activity_calculate_bmi.class);
        startActivity(intent);

    }
}


