package com.example.myapplication.Model;

public class Nota {

    private long idNota;

    private String titulo, txt;

    public Nota(Long idNota, String titulo, String txt) {
        this.idNota = idNota;
        this.titulo = titulo;
        this.txt = txt;
    }

    public Nota(String titulo, String txt) {
        this.titulo = titulo;
        this.txt = txt;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
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

