package com.example.myapplication.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Controll.NotaController;
import com.example.myapplication.Model.Nota;
import com.example.myapplication.R;

public class ActivityExibeNota extends AppCompatActivity {

    private EditText titulo, conteudo;
    private Button salva;
    private NotaController controller;
    private Nota nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_nota);

        getSupportActionBar().setTitle("Bloco de Notas");

        controller = new NotaController(this);
        titulo =  findViewById(R.id.titulo);
        conteudo = findViewById(R.id.conteudo);
        salva = findViewById(R.id.salvar);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("id_nota")) {
            Long id = extras.getLong("id_nota");
            nota = controller.getNota(id);

            titulo.setText(nota.getTitulo());
            conteudo.setText(nota.getTxt());
        }

        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaNota();
                ActivityNotasMain.carregaTudo(controller.getListNota());
                finish();
            }
        });

    }

    private void salvaNota(){
        String tituloTxt = titulo.getText().toString();
        String conteudoTxt = conteudo.getText().toString();

        if (nota != null) {
            nota.setTitulo(tituloTxt);
            nota.setTxt(conteudoTxt);
            controller.updateNota(nota);
        } else {
            Nota novaNota = new Nota(tituloTxt, conteudoTxt);
            controller.cadastrarNota(novaNota);
            ActivityNotasMain.carregaTudo(controller.getListNota());
        }
    }
}


