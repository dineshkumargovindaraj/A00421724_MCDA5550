package com.example.dinn.bmiapp;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.database.Cursor;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat simpleDateFormat;

    EditText personDOB ;
    EditText personPassword;
    EditText personName;
    EditText personHealthCardNo;
    Button personDetailsSubmit;
    InClassDatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personDetailsSubmit = (Button) findViewById(R.id.buttonSubmit);

        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();


        personDOB = (EditText) findViewById(R.id.textDOB);
        personPassword = (EditText) findViewById(R.id.textPassword);
        personName = (EditText) findViewById(R.id.textName);
        personHealthCardNo = (EditText) findViewById(R.id.textHCN);
        personDetailsSubmit = (Button) findViewById(R.id.buttonSubmit);

        personDOB.setOnClickListener(this);
        personDetailsSubmit.setOnClickListener(this);

        //Run a query
        Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME, new String[]{"NAME", "PASSWORD", "DATE", "HEALTH_CARD_NUMB"}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            String name = cursor.getString(0);
            String password = cursor.getString(1);
            String date = cursor.getString(2);
            String healthCardNumber = cursor.getString(3);

            personName.setText(name);
            personDOB.setText(date);
            personPassword.setText(password);
            personHealthCardNo.setText(healthCardNumber);
        }
        cursor.close();  // cleanup
        db.close();

        getDateofBirth();

    }


    private void getDateofBirth() {
        Calendar calendar = Calendar.getInstance();
        personDOB.setFocusable(false);
        personDOB.setClickable(true);
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, day);
                personDOB.setText(simpleDateFormat.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.textDOB:
                datePickerDialog.show();
                break;

            case R.id.buttonSubmit:
                String name = personName.getText().toString();
                String password = personPassword.getText().toString();
                String healthCardNumber = personHealthCardNo.getText().toString();
                String dob = personDOB.getText().toString();
                helper.insertPersonDetails(name, password, healthCardNumber, dob);
                Intent intent = new Intent(this, activity_calculate_bmi.class);
                startActivity(intent);
                break;
        }
    }

}


