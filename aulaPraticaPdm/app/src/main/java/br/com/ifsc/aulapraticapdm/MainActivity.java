package br.com.ifsc.aulapraticapdm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.CredentialProtectedWhileLockedViolation;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d( "metodoscallback", "onCreate");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d( "metodoscallback", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( "metodoscallback", "onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d( "metodoscallback", "onPause");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d( "metodoscallback", "onRestart");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d( "metodoscallback", "onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d( "metodoscallback", "onDestroy");
    }

    public void iniciaActivity(View view) {
        nome     = (EditText) findViewById(R.id.editText);
        Intent i = new Intent(this,imc.class);
        String mensagem = String.valueOf(nome.getText());
        i.putExtra("msg",mensagem);
        startActivity(i);
    }
}
