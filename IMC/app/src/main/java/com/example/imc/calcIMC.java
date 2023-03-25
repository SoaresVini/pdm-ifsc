package com.example.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class calcIMC extends AppCompatActivity {

    TextView msg;
    ImageView clas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_imc);

        Bundle bundle = getIntent().getExtras();
        double imc = bundle.getDouble("imc");
        msg = findViewById(R.id.textView);
        clas = findViewById(R.id.imageView2);

        if (imc < 18.5) {
            msg.setText("IMC: " +String.format("%.2f",imc)+" - Abaixo do peso");
            clas.setImageResource(R.drawable.abaixopeso);
        } else if (imc >= 18.5 && imc <= 25) {
            msg.setText("IMC: " +String.format("%.2f",imc)+" - Peso normal");
            clas.setImageResource(R.drawable.normal);
        } else if (imc >= 25 && imc <= 30) {
            msg.setText("IMC: " +String.format("%.2f",imc)+" - Sobrepeso");
            clas.setImageResource(R.drawable.sobrepeso);
        } else if (imc >= 30 && imc <= 35) {
            msg.setText("IMC: " +String.format("%.2f",imc)+" - Obesidade grau 1");
            clas.setImageResource(R.drawable.obesidade1);
        } else if (imc >= 35 && imc <= 40) {
            msg.setText("IMC: " +String.format("%.2f",imc)+" - Obesidade grau 2");
            clas.setImageResource(R.drawable.obesidade2);
        } else {
            msg.setText("IMC: " +String.format("%.2f",imc)+" - Obesidade grau 3");
            clas.setImageResource(R.drawable.obesidade3);
        }

    }

    public void voltar(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}