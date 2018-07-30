package com.example.dinn.bmiapp;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;


public class BMIListActivity extends ListActivity {


    InClassDatabaseHelper helper;
    ArrayList<BMIHistory> resultList;
    BMIHistory bmiHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bmilist);

        ListView listBMIResults = getListView();

        helper = new InClassDatabaseHelper(this);

        resultList = new ArrayList<>();
        Cursor data = helper.getListHistoryView();
        if (data.getCount() == 0)

        {
            Toast.makeText(BMIListActivity.this, "No Records Found !!.", Toast.LENGTH_LONG).show();
        } else

        {
            int i = 0;
            while (data.moveToNext()) {
                bmiHistory = new BMIHistory(data.getDouble(1), data.getDouble(2));
                resultList.add(i, bmiHistory);
                i++;
            }

            HistoryCustomAdapterListView adapter = new HistoryCustomAdapterListView(this, R.layout.activity_custom_listview, resultList);

            listBMIResults = (ListView) findViewById(android.R.id.list);

            listBMIResults.setAdapter(adapter);

            //Add to Activity on Click

        }


    }
}