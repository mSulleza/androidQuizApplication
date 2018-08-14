package com.uplb.mark.nasc9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseCRUD {


    private static final String TABLE_NAME = "QUESTIONS";
    private DatabaseHelper db_helper;
    public DatabaseCRUD(Context context)
    {
        db_helper = new DatabaseHelper(context);
    }

    public Cursor getQuestion(int id)
    {
        SQLiteDatabase mainDB = db_helper.getWritableDatabase();
        Cursor cursor = mainDB.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id + ";", null);
        cursor.moveToFirst();

        mainDB.close();
        return cursor;
    }

    public void answeredCorrect(int id)
    {
        ContentValues cv = new ContentValues();
        cv.put("answered", 1);
        System.out.println("UPDATING: " + id);
        SQLiteDatabase mainDB = db_helper.getWritableDatabase();
//        mainDB.rawQuery("UPDATE " + TABLE_NAME + " SET answered = 1 WHERE id = " + id + ";", null);
        mainDB.update(TABLE_NAME, cv, "id = " + id, null);
        Cursor cursor = mainDB.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE id = " + id + ";", null);
        cursor.moveToFirst();

        mainDB.close();
        System.out.println("VALUE AFTER UPDATE: " + cursor.getString(4));
    }

    public boolean isAnswered(int id)
    {
        SQLiteDatabase mainDB = db_helper.getWritableDatabase();
        Cursor cursor = mainDB.rawQuery("SELECT answered FROM " + TABLE_NAME + " WHERE id = " + id + ";", null);
        cursor.moveToFirst();

        mainDB.close();
        System.out.println("IS ANSWERED: " + cursor.getString(0));
        if (cursor.getString(0).equals("1")) return true;
        else return false;
    }

    public boolean isCompleted(int id)
    {
        SQLiteDatabase mainDB = db_helper.getWritableDatabase();
        Cursor cursor = mainDB.rawQuery("SELECT completed FROM LEVELS where id = " + id + ";", null);
        cursor.moveToFirst();

        mainDB.close();
        if (cursor.getString(0).equals("1")) return true;
        else return false;
    }

    public void levelCompleted(int id)
    {
        ContentValues cv = new ContentValues();
        cv.put("completed", 1);
        SQLiteDatabase mainDB = db_helper.getWritableDatabase();
//        mainDB.rawQuery("UPDATE " + TABLE_NAME + " SET answered = 1 WHERE id = " + id + ";", null);
        mainDB.update("LEVELS", cv, "id = " + id, null);
    }
}
