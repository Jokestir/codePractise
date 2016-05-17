package com.example.chirag.w80211;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.reflect.*;
import java.util.ArrayList;

import android.net.wifi.WifiManager;
import android.content.Context;
import com.example.chirag.w80211.GetChannelListAsyncTask;


public class MainActivity extends Activity {

    GetChannelListAsyncTask getChannelListAsyncTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // create the content of the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getChannel = (Button) findViewById(R.id.getChannelButton);


        View.OnClickListener oclGetChannelBtn = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // execute asynctask to get channels and display

                getChannelListAsyncTask = new GetChannelListAsyncTask(MainActivity.this);

                getChannelListAsyncTask.execute();

            }
        };

        getChannel.setOnClickListener(oclGetChannelBtn);
    }
}
