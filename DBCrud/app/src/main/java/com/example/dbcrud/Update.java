package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor rs;

    Button button;
    EditText name, address, phone, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = findViewById(R.id.nameU);
        address = findViewById(R.id.addressU);
        phone = findViewById(R.id.phoneU);
        email = findViewById(R.id.emailU);

        button = findViewById(R.id.buttonU);

        db = openOrCreateDatabase("db", MODE_PRIVATE, null);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    rs = db.rawQuery("SELECT * FROM persons WHERE name = ?;", new String[]{name.getText().toString()});

                    rs.moveToNext();

                    db.execSQL("UPDATE persons SET address = ?, phone = ?, email = ? WHERE name = ?;",
                            new String[]{address.getText().toString(),
                                    phone.getText().toString(),
                                    email.getText().toString(),
                                    name.getText().toString()});

                    Toast.makeText(getApplicationContext(), "Update Successful!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Update Failed!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        });

    }
}