package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText writeFileName, readFileName, writeFileContent, readFileContent;
    Button read, write;

    File sdcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeFileName = findViewById(R.id.writeFileName);
        readFileName = findViewById(R.id.readFileName);
        writeFileContent = findViewById(R.id.writeFileContent);
        readFileContent = findViewById(R.id.readFileContent);

        read = findViewById(R.id.readButton);
        write = findViewById(R.id.writeButton);

//        File with name
        sdcard = getExternalFilesDir("SDdirectory");

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                    FileWriter writer = new FileWriter(sdcard.getAbsolutePath() + "/" + writeFileName.getText().toString().trim(), false);
                    writer.write(writeFileContent.getText().toString());
                    writer.close();

                    Toast.makeText(getApplicationContext(), "Write complete!", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Write error!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                try {
                    File file = new File(sdcard, readFileName.getText().toString().trim());
                    Scanner r = new Scanner(file);
//                    for multiline text
                    r.useDelimiter("\\Z");
                    readFileContent.setText(r.next());
                    Toast.makeText(getApplicationContext(), "Read complete!", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    readFileContent.setText("");
                    Toast.makeText(getApplicationContext(), "File does not exist!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}