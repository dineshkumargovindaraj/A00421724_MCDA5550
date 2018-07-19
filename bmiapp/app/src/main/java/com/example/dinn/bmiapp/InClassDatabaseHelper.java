package com.example.dinn.bmiapp;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import java.util.Date;
class InClassDatabaseHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "inclass";  // name of the DB
    private static final int DB_VERSION = 1;  // version of the DB
    public static final String TABLE_NAME = "PERSON";// name of the Table
    public static final String TABLE_NAME1 = "BMI";
    public InClassDatabaseHelper(Context context){
        super(context,DB_NAME,null, DB_VERSION);  //   null is for cursors}@
    }
    SQLiteDatabase db;
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
    }

    public  void insertPersonDetails(String name , String password , String healthCardNumber , String date){
        ContentValues personValues= new ContentValues();
        personValues.put("NAME", name);
        personValues.put("PASSWORD", password);
        personValues.put("HEALTH_CARD_NUMB", healthCardNumber);
        personValues.put("DATE", date);
        db.insert(TABLE_NAME,null, personValues);
    }

    public  void insertBMIDetails(Double height , Double weight , Double result){
        ContentValues bmiDetails = new ContentValues();
        bmiDetails.put("HEIGHT", height);
        bmiDetails.put("WEIGHT", weight);
        bmiDetails.put("RESULT", result);

        db.insert(TABLE_NAME,null, bmiDetails);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}



