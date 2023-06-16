package com.example.myapplication.Controll;

import android.content.Context;

import com.example.myapplication.Model.Nota;
import com.example.myapplication.Model.NotasDAO;

import java.util.ArrayList;
import java.util.List;

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

    public Boolean updateNota(Nota nota){
        return notasDAO.atualizarNota(nota);
    }

    public List<Nota> getListNota(){
        return notasDAO.listaNotas();
    }

    public boolean deletarNota(Long id){
        return notasDAO.excluirNota(id);
    }

    public Nota getNota(Long id){return notasDAO.getNota(id);}

}
