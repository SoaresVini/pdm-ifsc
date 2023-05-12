package com.example.myapplication.Model;

public class Nota {

    Integer idNota;

    String titulo, txt;

    public Nota(Integer idNota, String titulo, String txt) {
        this.idNota = idNota;
        this.titulo = titulo;
        this.txt = txt;
    }

    public Nota(String titulo, String txt) {
        this.titulo = titulo;
        this.txt = txt;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}

