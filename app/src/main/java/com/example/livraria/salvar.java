package com.example.livraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class salvar extends AppCompatActivity {
    SensorManager sm;
    SensorEventListener listener;
    Sensor light;
    RelativeLayout tela6;
    EditText editTextFileName,editTextData;
    Button saveButton,readButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salvar);
        tela6 = (RelativeLayout) findViewById(R.id.tela6);
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

                tela6.setBackgroundColor(Color.rgb(grayShade, grayShade, grayShade));
            }
        };

        sm.registerListener(listener, light, SensorManager.SENSOR_DELAY_FASTEST);

        editTextFileName=findViewById(R.id.editText1);
        editTextData=findViewById(R.id.editText2);
        saveButton=findViewById(R.id.button1);
        readButton=findViewById(R.id.button2);

        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String filename=editTextFileName.getText().toString();
                String data=editTextData.getText().toString();

                FileOutputStream fos;
                try {
                    fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    //default mode is PRIVATE, can be APPEND etc.
                    fos.write(data.getBytes());
                    fos.close();

                    Toast.makeText(getApplicationContext(),filename + " - " + data + " saved",
                            Toast.LENGTH_LONG).show();


                } catch (FileNotFoundException e) {e.printStackTrace();}
                catch (IOException e) {e.printStackTrace();}

            }

        });

        readButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String filename=editTextFileName.getText().toString();
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    //Attaching BufferedReader to the FileInputStream by the help of InputStreamReader
                    BufferedReader inputReader = new BufferedReader(new InputStreamReader(
                            openFileInput(filename)));
                    String inputString;
                    //Reading data line by line and storing it into the stringbuffer
                    while ((inputString = inputReader.readLine()) != null) {
                        stringBuffer.append(inputString + "\n");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //Displaying data on the toast
                Toast.makeText(getApplicationContext(),stringBuffer.toString(),Toast.LENGTH_LONG).show();

            }

        });


        Button btnVoltar6 = (Button) findViewById(R.id.btnVoltar6);
        btnVoltar6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it0 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it0);
            }
        });
    }
}