package com.example.user.sqllite_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final  String DATABASE_NAME = "Student.db";
    private static final  String Table_NAME = "student_details";
    private static final  String ID = "_id";
    private static final  String NAME = "Name";
    private static final  String AGE = "Age";
    private static final  String GENDER = "Gender";
    private static final  int VERSION_NUMBER=5;
    private Context context;
    private static final  String CREATE_TABLE="CREATE TABLE "+Table_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT , "+NAME+" VARCHAR(255), "+AGE+" INTEGER, "+GENDER+" VARCHAR(15))" ;
    private static final String DROP_TABLE="DROP TABLE IF EXISTS " +Table_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {

            Toast.makeText(context,"Table Created ", Toast.LENGTH_SHORT).show();


            sqLiteDatabase.execSQL(CREATE_TABLE);

        }catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        try {

            Toast.makeText(context,"Update_Call ", Toast.LENGTH_SHORT).show();

            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e, Toast.LENGTH_SHORT).show();

        }





    }
}
