package com.example.dinn.bmiapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class HistoryCustomAdapterListView extends ArrayAdapter<BMIHistory> {

    private LayoutInflater mInflater;
    private ArrayList<BMIHistory> bmiHistories;
    private int mViewResourceId;
    String date_n = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());

    public HistoryCustomAdapterListView(Context context, int textViewResourceId, ArrayList<BMIHistory> bmiHistories) {
        super(context, textViewResourceId, bmiHistories);
        this.bmiHistories = bmiHistories;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        BMIHistory bmiHistory = bmiHistories.get(position);

        if (bmiHistory != null) {

            TextView height = (TextView) convertView.findViewById(R.id.textHeight);
            TextView weight = (TextView) convertView.findViewById(R.id.textWeight);
            TextView bmiResult = (TextView) convertView.findViewById(R.id.textBMIDetails);
            TextView bmiDate = (TextView) convertView.findViewById(R.id.textDate);


            height.setText(String.valueOf(bmiHistory.getHeight()));
            weight.setText(String.valueOf(bmiHistory.getWeight()));
            bmiResult.setText(String.valueOf(bmiHistory.getResult()));
            bmiDate.setText(date_n);

        }

        return convertView;

    }
}
