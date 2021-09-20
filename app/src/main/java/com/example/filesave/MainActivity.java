package com.example.filesave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String FILE_NAME = "helo_file";
    EditText inputan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputan = findViewById(R.id.inputanText);
    }
    public void save(View v){
        String textDisimpan = inputan.getText().toString();
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(textDisimpan.getBytes());
            inputan.getText().clear();
            Log.d("WriteFile","Succes");
            Log.d("Directory_File", "File disimmpan di "+getFilesDir()+ "/"+FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load (View v){
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            int c;
            String temp = "";
            while ((c = fis.read())!= -1){
                temp = temp + Character.toString((char)c);
            }
            inputan.setText(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}