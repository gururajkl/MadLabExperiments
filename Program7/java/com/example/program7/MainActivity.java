package com.example.program7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button speak;
    TextView txt;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speak = findViewById(R.id.btn_speak);
        speak.setOnClickListener(this);

        txt = findViewById(R.id.editText);
        textToSpeech = new TextToSpeech (getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_LONG).show();
                }
            }
        });
        textToSpeech.setLanguage(Locale.UK);
    }

    public void onClick(View v) {
        String text = txt.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH,null);
    }

}