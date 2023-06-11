package com.example.myapplication.Model;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.myapplication.Controll.NotaController;

import java.util.List;

public class NotaAdapter extends ArrayAdapter<Nota> {

    private List<Nota> itemList;
    private Context context;
    private NotaController controller;

    public NotaAdapter(Context context, List<Nota> itemList) {
        super(context, 0, itemList);
        this.context = context;
        this.itemList = itemList;
    }

}
