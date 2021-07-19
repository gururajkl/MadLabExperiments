package com.example.program6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnxml, btnjson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnxml = findViewById(R.id.button);
        btnxml.setOnClickListener(this);
        btnjson = findViewById(R.id.button2);
        btnjson.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.equals(btnxml)) {
            Intent intent = new Intent(this, viewactivity.class);
            intent.putExtra("mode", 1);
            startActivity(intent);
        }

        if (v.equals(btnjson)) {
            Intent intent = new Intent(this, viewactivity.class);
            intent.putExtra("mode", 2);
            startActivity(intent);
        }
    }
}