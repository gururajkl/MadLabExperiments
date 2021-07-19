package com.example.program5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt;
    Button start, stop;
    int count = 0;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.startbtn);
        start.setOnClickListener(this);

        stop = findViewById(R.id.stopbtn);
        stop.setOnClickListener(this);

        txt = findViewById(R.id.countertxt);
    }

    public void onClick( View v) {

        if (v.equals(start)) {
            count = 0;
            running = true;
            new MyCounter().start();
        }

        else {
            running = false;
        }
    }

    Handler handler = new Handler() {
        public void handleMessage(Message m) {
            txt.setText(String.valueOf(m.what));
        }
    };

    class MyCounter extends Thread {
        public void run() {
            while (running) {
                count ++;
                handler.sendEmptyMessage(count);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        }
    }
}