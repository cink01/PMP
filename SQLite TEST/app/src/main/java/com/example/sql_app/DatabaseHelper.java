package com.example.sql_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper    {

    public static final String DATABASE_NAME="mylist.db";
    public static final String TABLE_NAME="zbozi_data";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAZEV";
    public static final String COL3 = "CENA";
    public static final String COL4 = "POCET";


    public DatabaseHelper(Context context){super(context,DATABASE_NAME,null,1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable="CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAZEV TEXT, CENA FLOAT, POCET FLOAT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String t = "DROP IF TABLE EXIST ";
        db.execSQL(t+TABLE_NAME);
    }

    public boolean AddData(Zbozi zbozi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2, zbozi.nazev);
        contentValues.put(COL3, zbozi.cena);
  //      contentValues.put(COL4, zbozi.pocet);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result ==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        /*Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
        return data;*/
        return db.rawQuery("SELECT * FROM "+ TABLE_NAME,null);
    }

}
