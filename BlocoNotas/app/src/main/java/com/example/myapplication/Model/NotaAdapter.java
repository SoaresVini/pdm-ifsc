package com.example.myapplication.Model;

import android.app.AlertDialog;
import android.content.Context;
import com.example.myapplication.R;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.myapplication.Controll.NotaController;
import com.example.myapplication.View.ActivityExibeNota;
import com.example.myapplication.View.ActivityNotasMain;

import java.util.List;

public class NotaAdapter extends ArrayAdapter<Nota> {
    private List<Nota> itemList;
    private Context context;

    private NotaController FNoteController;

    public NotaAdapter(Context context, List<Nota> itemList) {
        super(context, 0, itemList);
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.item_lista_nota, parent, false);
        }

        Nota currentItem = itemList.get(position);

        TextView textView = listItemView.findViewById(R.id.titulo_lista);
        Button editButton = listItemView.findViewById(R.id.editar);
        Button deleteButton = listItemView.findViewById(R.id.deletar);

        textView.setText(currentItem.getTitulo());

        FNoteController = new NotaController(getContext());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FNoteController.deletarNota(currentItem.getIdNota());
                ActivityNotasMain.carregaTudo(FNoteController.getListNota());
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ActivityExibeNota.class);
                intent.putExtra("id_nota", currentItem.getIdNota());
                getContext().startActivity(intent);
            }
        });
        return listItemView;
    }

}
