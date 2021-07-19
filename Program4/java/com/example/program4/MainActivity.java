package com.example.program4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity  {

    Button wall;
    boolean runnable;
    int i = 0;
    int imgarr[] = new int[] {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.eight
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wall = findViewById(R.id.button);

        wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Timer().schedule(new ChangeWallpaper(), 0, 1000);
            }
        });
    }

    class ChangeWallpaper extends TimerTask {
        public void run() {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());

            try {
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(), imgarr[i]));
                i ++;
                if (i == 6) {
                    i = 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}