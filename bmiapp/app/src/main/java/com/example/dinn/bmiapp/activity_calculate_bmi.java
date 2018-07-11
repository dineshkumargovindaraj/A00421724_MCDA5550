package com.example.dinn.bmiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class activity_calculate_bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);
    }

    public void calculateBmi(View view){
        //gets the height
        EditText height = (EditText) findViewById(R.id.textHeight);
        String value = height.getText().toString();
        Double heightVal = Double.parseDouble(value);
        System.out.println("Here is the height " + heightVal);

        //gets the weight
        EditText weight = (EditText) findViewById(R.id.textWeight);
        String w_value = height.getText().toString();
        Double weightVal = Double.parseDouble(w_value);
        System.out.println("Here is the weight " + weightVal);

        Double calc = (weightVal / (heightVal * heightVal));
        EditText result = (EditText) findViewById(R.id.resultText);

        result.setText(calc.toString());

    }
}
