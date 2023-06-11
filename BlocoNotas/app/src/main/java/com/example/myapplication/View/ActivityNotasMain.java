package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.myapplication.Controll.NotaController;
import com.example.myapplication.Model.Nota;
import com.example.myapplication.Model.NotaAdapter;
import com.example.myapplication.R;

import java.util.List;

public class ActivityNotasMain extends AppCompatActivity {

    private ListView listView;
    static NotaAdapter adapter;

    private NotaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Bloquinho de Notas do Vini");

        controller = new NotaController(this);
        List<Nota> notas = controller.getListNota();

        adapter = new NotaAdapter(this, notas);

        listView.setAdapter(adapter);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abreNota();
            }
        });
    }

    private void abreNota(){
        Intent i = new Intent(ActivityNotasMain.this, ActivityExibeNota.class);
        startActivity(i);
    }


    public static void reloadList(List<Nota> list) {
        adapter.clear();
        adapter.addAll(list);

        // Notifica o adaptador sobre as mudanças nos dados
        adapter.notifyDataSetChanged();
    }



}