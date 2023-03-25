package com.example.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edPeso;
    private EditText edAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CalcIMC(View view) {

        edPeso = findViewById(R.id.peso);
        edAltura = findViewById(R.id.altura);

        double peso = Double.parseDouble(edPeso.getText().toString());
        double altura = Double.parseDouble(edAltura.getText().toString());

        double imc = peso/(altura * altura);

        Intent i = new Intent(this, calcIMC.class);
        i.putExtra("imc", imc);
        startActivity(i);

    }


}