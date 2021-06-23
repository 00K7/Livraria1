package com.example.livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLivro1 = (Button) findViewById(R.id.btnLivro1);
        btnLivro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it1 = new Intent(getApplicationContext(), Livro1Activity.class);
                startActivity(it1);
            }
        });

        Button btnLivro2 = (Button) findViewById(R.id.btnLivro2);
        btnLivro2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it2 = new Intent(getApplicationContext(), Livro2Activity.class);
                startActivity(it2);
            }
        });

        Button btnLivro3 = (Button) findViewById(R.id.btnLivro3);
        btnLivro3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it3 = new Intent(getApplicationContext(), Livro3Activity.class);
                startActivity(it3);
            }
        });

        Button btnLivro4 = (Button) findViewById(R.id.btnLivro4);
        btnLivro4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it4 = new Intent(getApplicationContext(), Livro4Activity.class);
                startActivity(it4);
            }
        });

        Button btnLivro5 = (Button) findViewById(R.id.btnLivro5);
        btnLivro5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it5 = new Intent(getApplicationContext(), Livro5Activity.class);
                startActivity(it5);
            }
        });

    }
}