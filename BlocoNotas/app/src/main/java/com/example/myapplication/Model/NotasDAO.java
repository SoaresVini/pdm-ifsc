package com.example.myapplication.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class NotasDAO {

    SQLiteDatabase database;

    public NotasDAO(Context c){
        database = c.openOrCreateDatabase("dbNotas",c.MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE notas (id Integer PRIMARY KEY AUTOINCREMENT,"+
                "titulo varchar," +
                "texto varchar)");
    }

    public Nota inserirNota(Nota n){
        ContentValues cv = new ContentValues();
        cv.put("titulo",n.getTitulo());
        cv.put("texto",n.getTxt());

      int i =(int)  database.insert("notas",null,cv);

      n.setIdNota(i);

      return n;
    }






}
