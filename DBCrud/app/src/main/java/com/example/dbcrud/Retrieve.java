package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Retrieve extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor rs;

    Button button;
    TextView textViewR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        db = openOrCreateDatabase("db", MODE_PRIVATE, null);

        textViewR = findViewById(R.id.TextViewR);

        button = findViewById(R.id.buttonR);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    rs = db.rawQuery("SELECT * FROM persons;", null);
//                    rs = db.rawQuery("SELECT * FROM persons WHERE phone = ?;", new String[]{9445502654});

                    String msg = "";

//                    For only one record
//                    rs.moveToFirst()

                    while(rs.moveToNext())
                    {
                        msg += rs.getString(0) + " " + rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + "\n";
                    }

                    textViewR.setText(msg);

                    if(msg == ""){
                        textViewR.setText("No records inserted!");
                    }

                    Toast.makeText(getApplicationContext(), "Retrieve Successful!", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Retrieve Failed!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
}