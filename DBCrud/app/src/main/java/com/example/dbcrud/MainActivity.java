package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bc, bi, br, bu, bd;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bc = findViewById(R.id.create);
        bi = findViewById(R.id.insert);
        br = findViewById(R.id.retrieve);
        bu = findViewById(R.id.update);
        bd = findViewById(R.id.delete);

        db = openOrCreateDatabase("db", MODE_PRIVATE, null);

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("DROP TABLE IF EXISTS persons;");
                db.execSQL("CREATE TABLE persons(name VARCHAR(50), address VARCHAR(50), phone VARCHAR(50), email VARCHAR(50));");
                Toast.makeText(getApplicationContext(), "Created Table persons!", Toast.LENGTH_SHORT).show();
            }
        });

        bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Insert.class);
                startActivity(myIntent);
            }
        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Retrieve.class);
                startActivity(myIntent);
            }
        });

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Update.class);
                startActivity(myIntent);
            }
        });

        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Delete.class);
                startActivity(myIntent);
            }
        });

    }
}