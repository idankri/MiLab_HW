package com.example.milab_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton starks_button = findViewById(R.id.starks_button);
        ImageButton lannisters_button = findViewById(R.id.lanisters_button);

        starks_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), StarksGalleryActivity.class);
                startActivity(intent);
            }
        });
        lannisters_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LanistersGalleryActivity.class);
                startActivity(intent);
            }
        });

        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,
                                                        R.raw.south_park_wiener_song);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });
        mediaPlayer.start();
    }
}