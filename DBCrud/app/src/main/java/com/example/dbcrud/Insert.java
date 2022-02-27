package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insert extends AppCompatActivity {

    Button button;
    EditText name, address, phone, email;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);

        button = findViewById(R.id.button);

        db = openOrCreateDatabase("db", MODE_PRIVATE, null);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    db.execSQL("INSERT INTO persons VALUES(?, ?, ?, ?);",
                            new String[]{name.getText().toString(),
                                    address.getText().toString(),
                                    phone.getText().toString(),
                                    email.getText().toString()});

                    Toast.makeText(getApplicationContext(), "Insert Successful!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Insert Failed!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
}