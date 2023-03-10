package br.com.ifsc.aulapraticapdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class imc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        String string = bundle.getString("msg");

        TextView textNome = findViewById(R.id.textView);

        textNome.setText(string);
    }
}