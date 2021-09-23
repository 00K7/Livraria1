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

public class Livro4Activity extends AppCompatActivity {
    SensorManager sm;
    SensorEventListener listener;
    Sensor light;
    ConstraintLayout tela4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro4);
        tela4 = (ConstraintLayout) findViewById(R.id.tela4);
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

                tela4.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
            }
        };

        sm.registerListener(listener, light, SensorManager.SENSOR_DELAY_FASTEST);

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