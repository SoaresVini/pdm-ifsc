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

    @SuppressLint("Range")
    public Nota getNota(Long id) {
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = database.query(TABLE_NOTAS, null, selection, selectionArgs, null, null, null);
        if (cursor.moveToFirst()) {
            Nota nota;
            nota = new Nota(
                    cursor.getLong(cursor.getColumnIndex(COLUMN_ID)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_TITULO)),
                    cursor.getString(cursor.getColumnIndex(COLUMN_TEXTO))
            );
            cursor.close();
            return nota;
        }
        cursor.close();
        return null;
    }

    public Boolean atualizarNota(Nota nota) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITULO, nota.getTitulo());
        contentValues.put(COLUMN_TEXTO, nota.getTxt());

        String whereClause = COLUMN_ID + " = ?";
        String[] whereArgs = {String.valueOf(nota.getIdNota())};

        int rowsAffected = database.update(TABLE_NOTAS, contentValues, whereClause, whereArgs);
        return rowsAffected > 0;
    }

    public boolean excluirNota(Long id) {
        int rowsAffected = database.delete(TABLE_NOTAS, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        return rowsAffected > 0;
    }

    @SuppressLint("Range")
    public List<Nota> listaNotas() {
        List<Nota> listaNotas = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NOTAS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Nota note = new Nota(
                        cursor.getLong(cursor.getColumnIndex(COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TITULO)),
                        cursor.getString(cursor.getColumnIndex(COLUMN_TEXTO))
                );
                listaNotas.add(note);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return listaNotas;
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
