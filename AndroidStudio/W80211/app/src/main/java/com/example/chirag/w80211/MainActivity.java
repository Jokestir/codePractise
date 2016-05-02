package com.example.chirag.w80211;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiChannel;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getChannel = (Button) findViewById(R.id.getChannelButton);
        final TextView channelTitle = (TextView) findViewById(R.id.channelTitle);
        final TextView channels = (TextView) findViewById(R.id.channelList);

        View.OnClickListener oclGetChannelBtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            channelTitle.setText(getString(R.string.channelTitle));
                channels.setText(getString(R.string.channels));
            }
        };

        getChannel.setOnClickListener(oclGetChannelBtn);
    }





}
