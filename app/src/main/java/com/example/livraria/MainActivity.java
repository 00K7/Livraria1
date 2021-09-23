package com.example.livraria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SensorManager sm;
    SensorEventListener listener;
    Sensor light;
    RelativeLayout tela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tela = (RelativeLayout) findViewById(R.id.tela);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        listener = new SensorEventListener() {

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }

            @Override
            public void onSensorChanged(SensorEvent event) {

                int grayShade = (int) event.values[0];
                if (grayShade > 255) grayShade = 255;

                tela.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
            }
        };

        sm.registerListener(listener, light, SensorManager.SENSOR_DELAY_FASTEST);



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

        Button btnsave = (Button) findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it6 = new Intent(getApplicationContext(), salvar.class);
                startActivity(it6);
            }
        });




    }



}