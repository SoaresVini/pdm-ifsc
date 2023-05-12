package com.example.myapplication.Model;

import android.database.sqlite.SQLiteDatabase;

public class NotasDAO {

    SQLiteDatabase sqLiteDatabase;

    public NotasDAO(SQLiteDatabase sqLiteDatabase) {
        this.sqLiteDatabase = sqLiteDatabase;
    }


}
