package com.example.slideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView iv;

    Integer [] imagens;

    Integer x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagens = new Integer[]{
                R.drawable.cachorro,
                R.drawable.gardem,
                R.drawable.happy,
                R.drawable.patinho,
                R.drawable.porquinho
        };
        iv = findViewById(R.id.imageView);
        iv.setImageResource(imagens[0]);

    }
    public void onClickNext(View view) {
        x ++;
        if ( x == imagens.length){
            x = 0;
        }
        iv.setImageResource(imagens[x]);
    }
    public void onClickUtil(View view) {
        x --;

        if ( x < 0){
            x = imagens.length - 1;
        }
        iv.setImageResource(imagens[x]);
    }

    public void onClickHome(View view) {
        x = 0;
        iv.setImageResource(imagens[x]);
    }
}