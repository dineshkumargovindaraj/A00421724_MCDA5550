package com.example.dinn.bmiapp;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
class InClassDatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "inclass";  // name of the DB
    private static final int DB_VERSION = 1;  // version of the DB
    public static final String TABLE_NAME = "PERSON";// name of the Table
    public static final String TABLE_NAME1 = "BMI";
    public static final String TABLE_NAME2= "BMIHistory";
    public InClassDatabaseHelper(Context context){
        super(context,DB_NAME,null, DB_VERSION);  //   null is for cursors}@
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create the Person Table
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "PASSWORD TEXT, "   // Never store passwords in clear text in real apps
                + "HEALTH_CARD_NUMB TEXT, "
                + "DATE TEXT);");

        //Create the BMI Table
        db.execSQL("CREATE TABLE "+TABLE_NAME1+" ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "HEIGHT DOUBLE, "
                + "WEIGHT DOUBLE, "   // Never store passwords in clear text in real apps
                + "RESULT DOUBLE);");

        db.execSQL("CREATE TABLE "+TABLE_NAME2 +" ("
                + "ID INTEGER, "
                + "HEIGHT TEXT, "
                + "WEIGHT TEXT, "
                + "DATE TEXT, "
                + "BMI TEXT);");

    }



    public  void insertPersonDetails(String name , String password , String healthCardNumber , String date){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues personValues= new ContentValues();
        personValues.put("NAME", name);
        personValues.put("PASSWORD", password);
        personValues.put("HEALTH_CARD_NUMB", healthCardNumber);
        personValues.put("DATE", date);
        db.insert(TABLE_NAME,null, personValues);
        db.close();
    }

    public  void insertBMIDetails(Double height , Double weight , Double result){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues bmiDetails = new ContentValues();
        bmiDetails.put("HEIGHT", height);
        bmiDetails.put("WEIGHT", weight);
        bmiDetails.put("RESULT", result);

        db.insert(TABLE_NAME1,null, bmiDetails);
        db.close();
    }


    public void saveHistory(PersonBMIHistory personBMIHistory){
        SQLiteDatabase db = this.getWritableDatabase();
        Date today = new Date(); // we want to start with some initial data
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ContentValues personValues = new ContentValues();
        personValues.put("HEIGHT", personBMIHistory.getHeight());
        personValues.put("WEIGHT", personBMIHistory.getWeight());
        personValues.put("DATE", dateFormat.format(today));
        personValues.put("BMI", personBMIHistory.getBmi());
        db.insert(TABLE_NAME2,null, personValues);

    }

    public Cursor getListHistoryView(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME2, null);
        return  data;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}



