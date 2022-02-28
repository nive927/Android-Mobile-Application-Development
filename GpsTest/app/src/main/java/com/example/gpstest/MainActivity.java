package com.example.gpstest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lat;
    TextView lng;

    Button b;

    LocationManager locationManager;
    LocationListener locationListener;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.getCurrentLocation);
        lat = findViewById(R.id.latitude);
        lng = findViewById(R.id.longitude);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//                Log. i ("here", String.valueOf(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)));
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {


                    locationListener = new LocationListener() {
                        @Override
                        public void onLocationChanged(@NonNull Location location) {

                            lat.setText(String.valueOf(location.getLatitude()));
                            lng.setText(String.valueOf(location.getLongitude()));

                        }
                    };

                    if (ActivityCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(MainActivity.this, new
                                String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    } else {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000,
                                10, locationListener);

                    }
                }
            }

        });
    }
}