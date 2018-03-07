package com.example.android.mymusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class PaymentsActivity extends AppCompatActivity {

    Button backToNowPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
        initViewsAndSetListeners();
    }

    private void initViewsAndSetListeners() {
        backToNowPlaying = findViewById(R.id.back_to_nowplayingactivity);

        backToNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentsActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }
}
