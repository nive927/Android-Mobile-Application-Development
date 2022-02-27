package com.example.alarm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker tp;
    Button set, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp = findViewById(R.id.timePicker);
        set = findViewById(R.id.setButton);
        stop = findViewById(R.id.stopButton);

        set.setOnClickListener(new View.OnClickListener() {

//            Added
            @RequiresApi(api = Build.VERSION_CODES.M)

            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                cal.set(cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH),
                        tp.getHour(),
                        tp.getMinute(),
                        0);
                long timeInMillis = cal.getTimeInMillis();
                AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent= new Intent(MainActivity.this, Alarm.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent);
                Toast.makeText(MainActivity.this,"Your Alarm is Set",Toast.LENGTH_LONG).show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent= new Intent(MainActivity.this, Alarm.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
                alarmManager.cancel(pendingIntent);
                Toast.makeText(MainActivity.this,"Your Alarm is Cancelled",Toast.LENGTH_LONG).show();
            }
        });

    }
}