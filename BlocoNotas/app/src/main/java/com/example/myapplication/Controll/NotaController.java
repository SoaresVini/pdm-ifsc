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

    public Nota updateNota(Nota nota){
        return notasDAO.atualizarNota(nota);
    }

    public ArrayList<Nota> getListNota(){
        return (ArrayList<Nota>) notasDAO.listarNotas();
    }

    public boolean DeletarNota(int id){
        return notasDAO.excluirNota(id);
    }
}
