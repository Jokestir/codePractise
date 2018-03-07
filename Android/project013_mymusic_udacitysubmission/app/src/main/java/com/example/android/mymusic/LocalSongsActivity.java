package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LocalSongsActivity extends AppCompatActivity {

    TextView song1_view;
    TextView song2_view;
//    Button nowPlayingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_songs);
        intiViewAndSetViewListeners();
    }

    private void intiViewAndSetViewListeners() {
        song1_view = findViewById(R.id.local_samplesong_1);
        song2_view = findViewById(R.id.local_samplesong_2);
//        nowPlayingBtn = findViewById(R.id.backto_nowplayingactivity);

        /*nowPlayingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalSongsActivity.this,NowPlayingActivity.class);
                startActivity(intent);
            }
        });
*/
        song1_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalSongsActivity.this, NowPlayingActivity.class);
                Toast.makeText(LocalSongsActivity.this, getResources().getString(R.string.nowplayingsong) + song1_view.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        song2_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LocalSongsActivity.this, NowPlayingActivity.class);
                Toast.makeText(LocalSongsActivity.this, getResources().getString(R.string.nowplayingsong) + song2_view.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}
