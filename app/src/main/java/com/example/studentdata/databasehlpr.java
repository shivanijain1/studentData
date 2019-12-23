package com.example.studentdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static android.content.ContentValues.*;
import static android.os.Build.ID;

public class databasehlpr extends SQLiteOpenHelper {
    public static final String Database_Name = "student.db";
    public static final String TableName = "STUDENT_DATA";
    public static final String Id = "ID";
    public static final String Name = "NAME";
    public static final String Surname = "SURNAME";
    public static final String Marks = "MARKS";
    public databasehlpr(Context context) {
        super(context, Database_Name, null, 1);
       // SQLiteDatabase db= this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String create_table = "CREATE TABLE " + TableName + "(" +Id + " INTEGER PRIMARY KEY AUTOINCREMENT," + Name + "TEXT," + Surname + "TEXT," + Marks + "INTEGER" + ")";
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TableName + "("
                + Id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Name + " TEXT,"
                + Surname + " TEXT, "
                + Marks + "INTEGER "
                + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TableName);
        onCreate(db);

    }
       public boolean insertData (String name, String surname,String marks){
        SQLiteDatabase db;
           db = this.getWritableDatabase();
           //SQLiteDatabase db=this.getReadableDatabase();
        ContentValues contentvalue = new ContentValues();
        contentvalue.put(Name,name);
        contentvalue.put (Surname,surname);
        contentvalue.put (Marks,marks);
        long result= db.insert(TableName,null,contentvalue);
        if (result==-1)
            return false;
        else
           return true;
  }
}
