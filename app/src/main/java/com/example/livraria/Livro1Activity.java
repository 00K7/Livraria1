package com.example.livraria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Livro1Activity extends AppCompatActivity {

    SensorManager sm;
    SensorEventListener listener;
    Sensor light;
    ConstraintLayout tela1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro1);
        tela1 = (ConstraintLayout) findViewById(R.id.tela1);
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

                tela1.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
            }
        };

        sm.registerListener(listener, light, SensorManager.SENSOR_DELAY_FASTEST);




        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it0 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it0);
            }
        });

        Button btnWeb1 = (Button) findViewById(R.id.btnWeb1);
        btnWeb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.br/Dungeons-Dragons-Dungeon-Masters-Português/dp/8568059325/ref=sr_1_5?__mk_pt_BR=ÅMÅŽÕÑ&crid=A118WJX1LN2S&dchild=1&keywords=d%26d+5e&qid=1624469014&sprefix=d%26d%2Caps%2C298&sr=8-5")));
            }
        });
    }
}