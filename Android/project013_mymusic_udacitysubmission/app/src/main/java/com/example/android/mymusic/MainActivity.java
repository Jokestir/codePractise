package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView localSongsTextView;
    TextView favoriteSongsTextView;
    TextView SettingsTextView;
    TextView nowPlayingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewAndSetListeners();
    }

    private void initViewAndSetListeners() {
        localSongsTextView = findViewById(R.id.localsongmenu);
        localSongsTextView.setOnClickListener(this);
        favoriteSongsTextView = findViewById(R.id.favoritesongsmenu);
        favoriteSongsTextView.setOnClickListener(this);
        SettingsTextView = findViewById(R.id.settingsmenu);
        SettingsTextView.setOnClickListener(this);
        nowPlayingActivity = findViewById(R.id.now_playing);
        nowPlayingActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.localsongmenu:
                Intent localSongsIntent = new Intent(MainActivity.this, LocalSongsActivity.class);
                startActivity(localSongsIntent);
                break;
            case R.id.settingsmenu:
                Intent settingsMenuIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsMenuIntent);
                break;
            case R.id.favoritesongsmenu:
                Intent favoriteSongsIntent = new Intent(MainActivity.this, PlayListSongsActivity.class);
                startActivity(favoriteSongsIntent);
                break;
            case R.id.now_playing:
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
                break;

        }
    }
}
