package com.example.dinn.bmiapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.database.Cursor;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        //Run a query
        Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME,new String[] {"NAME","PASSWORD","DATE"},null,null,null,null,null);

        if (cursor.moveToFirst()){
            String name = cursor.getString(0);
            EditText results = (EditText) findViewById(R.id.textName);
            results.setText(name);
        }
        cursor.close();  // cleanup
        db.close();


   }

    public void onClickEnter(View view){
        Intent intent = new Intent(this,activity_calculate_bmi.class);
        startActivity(intent);

    }
}


