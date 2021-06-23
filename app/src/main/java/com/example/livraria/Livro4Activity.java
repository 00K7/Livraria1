package com.example.livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Livro4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro4);

        Button btnVoltar3 = (Button) findViewById(R.id.btnVoltar3);
        btnVoltar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it0 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it0);
            }
        });

        Button btnWeb4 = (Button) findViewById(R.id.btnWeb4);
        btnWeb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.br/Heroes-Feast-Official-Dungeons-Cookbook/dp/1984858904/ref=sr_1_30?__mk_pt_BR=ÅMÅŽÕÑ&crid=A118WJX1LN2S&dchild=1&keywords=d%26d+5e&qid=1624469348&sprefix=d%26d%2Caps%2C298&sr=8-30")));
            }
        });
    }
}