package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PlayListSongsActivity extends AppCompatActivity {

    //    Button playingActivity;
    TextView favoriteSongView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_songs);
        initViewsAndSetListeners();
    }

    private void initViewsAndSetListeners() {

        favoriteSongView = findViewById(R.id.favorite_song1);

        favoriteSongView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayListSongsActivity.this, NowPlayingActivity.class);
                Toast.makeText(PlayListSongsActivity.this, getResources().getString(R.string.nowplayingsong) + favoriteSongView.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

//        playingActivity = findViewById(R.id.nowplayingact);
//
//        playingActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(PlayListSongsActivity.this, NowPlayingActivity.class);
//                startActivity(intent);
//            }
//        });
    }
}
