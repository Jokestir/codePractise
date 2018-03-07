package com.example.android.cookies;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ImageView cookieimgview;
    TextView msgtextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cookieimgview = (ImageView) findViewById(R.id.android_cookie_image_view);
        msgtextview = (TextView) findViewById(R.id.status_text_view);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        msgtextview.setText("I'm so full");
        cookieimgview.setImageResource(R.drawable.after_cookie);


    }
}