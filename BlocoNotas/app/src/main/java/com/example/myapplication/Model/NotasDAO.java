package com.example.myapplication.Model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

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
        public Nota atualizarNota(Nota nota){
            ContentValues cv = new ContentValues();
            cv.put("titulo", nota.getTitulo());
            cv.put("texto", nota.getTxt());

            int rowsAffected = database.update("notas", cv, "id=?", new String[]{String.valueOf(nota.idNota)});

            if (rowsAffected > 0) {
                return nota;
            } else {
                return null;
            }
        }

        public boolean excluirNota(int id){
            int rowsAffected = database.delete("notas", "id=?", new String[]{String.valueOf(id)});
            return rowsAffected > 0;
        }

        public List<Nota> listarNotas() {
            List<Nota> notas = new ArrayList<>();

            Cursor cursor = database.query("notas", null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") Nota nota = new Nota(
                            cursor.getInt(cursor.getColumnIndex("id")),
                            cursor.getString(cursor.getColumnIndex("titulo")),
                            cursor.getString(cursor.getColumnIndex("texto"))
                    );
                    notas.add(nota);
                } while (cursor.moveToNext());
            }
            cursor.close();
            return notas;
        }
    }
