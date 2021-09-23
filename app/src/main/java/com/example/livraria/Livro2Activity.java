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

public class Livro2Activity extends AppCompatActivity {
    SensorManager sm;
    SensorEventListener listener;
    Sensor light;
    ConstraintLayout tela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livro2);
        tela2 = (ConstraintLayout) findViewById(R.id.tela2);
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

                tela2.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
            }
        };

        sm.registerListener(listener, light, SensorManager.SENSOR_DELAY_FASTEST);

        Button btnVoltar1 = (Button) findViewById(R.id.btnVoltar1);
        btnVoltar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it0 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it0);
            }
        });

        Button btnWeb2 = (Button) findViewById(R.id.btnWeb2);
        btnWeb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com.br/Players-Handbook-Wizards-RPG-Team/dp/0786965606/ref=sr_1_34?__mk_pt_BR=ÅMÅŽÕÑ&crid=A118WJX1LN2S&dchild=1&keywords=d%26d+5e&qid=1624469348&sprefix=d%26d%2Caps%2C298&sr=8-34")));
            }
        });
    }
}