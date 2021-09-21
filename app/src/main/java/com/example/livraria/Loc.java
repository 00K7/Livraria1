package com.example.livraria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class Loc<locationManager> extends AppCompatActivity {

    private TextView txtlat;
    private TextView txtlon;
    private TextView txtcid;
    private TextView txtest;
    private TextView txtp;

    private Location location;
    private LocationManager locationManager;

    private Address endereco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);

        txtlat = (TextView) findViewById(R.id.txtlat);
        txtlon = (TextView) findViewById(R.id.txtlon);
        txtcid = (TextView) findViewById(R.id.txtcid);
        txtest = (TextView) findViewById(R.id.txtest);
        txtp = (TextView) findViewById(R.id.txtp);

        double latitude = 0.0;
        double longitude = 0.0;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

        } else {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }

        if (location != null) {
            longitude = location.getLongitude();
            latitude = location.getLatitude();
        }

        txtlat.setText("Latitude:" + latitude);
        txtlon.setText("Longitude:" + longitude);

        try {
            endereco = buscarEndereco(latitude, longitude);

            txtcid.setText("Cidade:" + endereco.getLocality());
            txtest.setText("Estado:" + endereco.getAdminArea());
            txtp.setText("País:" + endereco.getCountryName());
        } catch (IOException e) {
            Log.i("GPS", e.getMessage());
        }
    }

    private Address buscarEndereco(double latitude, double longitude) throws IOException{
        Geocoder geocoder;
        Address address = null;
        List<Address> adresses;

        geocoder = new Geocoder(getApplicationContext());

        adresses = geocoder.getFromLocation(latitude, longitude, 1);
        if(adresses.size()>0) {
            address =adresses.get(0);
        }
        return address;
    }
}