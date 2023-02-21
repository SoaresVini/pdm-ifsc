package com.example.sorteio;

import static java.lang.String.valueOf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.Sorteio);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textSorteio = findViewById(R.id.textSorteio);
                EditText ed1 = findViewById(R.id.numInicio);
                EditText ed2 = findViewById(R.id.numFim);

                String n1 = valueOf(ed1.getText());
                String n2 = valueOf(ed2.getText());

                Integer numInicio = Integer.valueOf(n1);
                Integer numFim = Integer.valueOf(n2);

                textSorteio.setText(valueOf(getRandom(numInicio,numFim )));
            }
        });


    };

    private static int getRandom(int n1, int n2 ) {

        Random ran = new Random();

        return ran.nextInt((n2 - n1) + 1);
    }
}