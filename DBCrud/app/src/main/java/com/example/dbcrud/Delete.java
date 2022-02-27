package com.example.dbcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    SQLiteDatabase db;

    Button button;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        db = openOrCreateDatabase("db", MODE_PRIVATE, null);

        button = findViewById(R.id.buttonD);
        name = findViewById(R.id.nameD);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    db.execSQL("DELETE FROM persons WHERE name = ?;", new String []{name.getText().toString()});
                    Toast.makeText(getApplicationContext(), "Delete Successful!", Toast.LENGTH_SHORT).show();

                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "Delete Failed!", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
    }
}