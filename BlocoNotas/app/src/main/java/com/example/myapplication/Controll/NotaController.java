package com.example.myapplication.Controll;

import android.content.Context;

import com.example.myapplication.Model.Nota;
import com.example.myapplication.Model.NotasDAO;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class NotaController {

    Context mContext;
    NotasDAO notasDAO;

    public NotaController( Context c){
        mContext=c;
        notasDAO = new NotasDAO(c);
    }

    public Nota cadastrarNota(Nota n) {
        return notasDAO.inserirNota(n);
    }

    public Nota getNota(Integer id){
        return null;
    }

    public ArrayList<Nota> getListNota(){
        return null;
    }

    public boolean DeletarNota(Nota nota){
        return false;
    }
}
