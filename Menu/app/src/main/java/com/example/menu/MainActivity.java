package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.name:
                Intent intent1 = new Intent(MainActivity.this, Name.class);
                startActivity(intent1);
                break;
            case R.id.phone:
                Intent intent2 = new Intent(MainActivity.this, Phone.class);
                startActivity(intent2);
                break;
            case R.id.college:
                Intent intent3 = new Intent(MainActivity.this, College.class);
                startActivity(intent3);
                break;
            default: return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);

    }
}