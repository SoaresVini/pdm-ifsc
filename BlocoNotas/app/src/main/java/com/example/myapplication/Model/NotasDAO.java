package com.example.myapplication.Model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class NotasDAO {

    private static final String DATABASE_NAME = "dbNotas";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NOTAS = "notas";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITULO = "titulo";
    private static final String COLUMN_TEXTO = "texto";

    private SQLiteDatabase database;

    public NotasDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public Nota inserirNota(Nota n) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITULO, n.getTitulo());
        cv.put(COLUMN_TEXTO, n.getTxt());

        long id = database.insert(TABLE_NOTAS, null, cv);
        n.setIdNota(id);

        return n;
    }

    public Nota atualizarNota(Nota nota) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITULO, nota.getTitulo());
        cv.put(COLUMN_TEXTO, nota.getTxt());

        int rowsAffected = database.update(TABLE_NOTAS, cv, COLUMN_ID + "=?", new String[]{String.valueOf(nota.getIdNota())});

        if (rowsAffected > 0) {
            return nota;
        } else {
            return null;
        }
    }

    public boolean excluirNota(int id) {
        int rowsAffected = database.delete(TABLE_NOTAS, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        return rowsAffected > 0;
    }

    @SuppressLint("Range")
    public List<Nota> listarNotas() {
        List<Nota> notas = new ArrayList<>();

        Cursor cursor = database.query(TABLE_NOTAS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                long id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String titulo = cursor.getString(cursor.getColumnIndex(COLUMN_TITULO));
                String texto = cursor.getString(cursor.getColumnIndex(COLUMN_TEXTO));

                Nota nota = new Nota(id, titulo, texto);
                notas.add(nota);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return notas;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NOTAS +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITULO + " VARCHAR, " +
                    COLUMN_TEXTO + " VARCHAR)";
            db.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTAS);
            onCreate(db);
        }
    }
}
