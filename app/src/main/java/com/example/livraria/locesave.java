package com.example.livraria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class locesave extends AppCompatActivity {



    EditText editTextFileName,editTextData;
    Button saveButton,readButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_locesave);

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
