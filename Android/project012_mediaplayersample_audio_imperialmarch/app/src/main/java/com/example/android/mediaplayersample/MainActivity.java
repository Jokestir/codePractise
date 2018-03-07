package com.example.android.mediaplayersample;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer imperialMarchPlayer;

    Button playButton;
    Button pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActivity();
    }

    private void initActivity() {
        imperialMarchPlayer = MediaPlayer.create(this,R.raw.imperial_march);
        playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(this);
        pauseButton = findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.play_button:
                imperialMarchPlayer.start();
                imperialMarchPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        imperialMarchPlayer.release();
                    }
                });
                break;
            case R.id.pause_button:
                imperialMarchPlayer.pause();
                break;
        }
    }
}
