package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.myapplication.Controll.NotaController;
import com.example.myapplication.Model.Nota;
import com.example.myapplication.Model.NotaAdapter;
import com.example.myapplication.R;

import java.util.List;

public class ActivityNotasMain extends AppCompatActivity {

    private ListView listView;
    static NotaAdapter adapter;

    Button novaNota;
    private NotaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Bloco de Notas");

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);


        controller = new NotaController(this);
        List<Nota> itemList = controller.getListNota();
        adapter = new NotaAdapter(this, itemList);

        listView.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirNota();
            }
        });
    }

    private void abrirNota() {
        Intent intent = new Intent(ActivityNotasMain.this, ActivityExibeNota.class);
        startActivity(intent);
    }

    public static void carregaTudo(List<Nota> list) {
        adapter.clear();
        adapter.addAll(list);
        adapter.notifyDataSetChanged();
    }



}