package com.example.saveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button save, get, delete;
    EditText LName;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.btn_save);
        get=findViewById(R.id.btn_get);
        delete=findViewById(R.id.btn_delete);
        LName=findViewById(R.id.edit_text_id);
        sp = getSharedPreferences("Data", MODE_PRIVATE);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("LName", LName.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sp.contains("LName")){
                    LName.setText(sp.getString("LName", ""));
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sp.edit();
                editor.clear();
                editor.commit();
                LName.setText("");
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void secondActivity(View view) {
        Intent intent = new Intent(this, ImagesActivity.class);
        startActivity(intent);
    }
}