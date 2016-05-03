package com.example.chirag.w80211;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Objects;

import android.net.wifi.WifiManager;
import android.content.Context;


public class MainActivity extends Activity {

    WifiManager mWifiManger;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWifiManger = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        Button getChannel = (Button) findViewById(R.id.getChannelButton);
        final TextView channelTitle = (TextView) findViewById(R.id.channelTitle);
        final TextView channels = (TextView) findViewById(R.id.channelList);

        View.OnClickListener oclGetChannelBtn = new View.OnClickListener() {
            String channelString;
            @Override
            public void onClick(View view) {

                // reset the string
                channelString = "";
                // reflection code

                try {
                    // load the class

                    Class wifiChannelClass = Class.forName("android.net.wifi.WifiChannel");




                    // create an instance of


                   //Object WifiChannel = wifiChannelClass.newInstance();


                    // find getChannelList() method from Wifimanager

                    Method getChannelListMethod = WifiManager.class.getMethod("getChannelList",null);

                    ArrayList<?> listOfWifiChannelObjects = (ArrayList<?>) getChannelListMethod.invoke(mWifiManger,null);

                    for (Object object : listOfWifiChannelObjects){

                        Field channelNumField = object.getClass().getDeclaredField("channelNum");

                        channelString = channelString.concat(channelNumField.get(object).toString());


                        channelString = channelString.concat(", ");


                    }

                    channelString = channelString.substring(0,channelString.length()-2);

                    //Log.e("CHIRAG"," " + getChannelListMethod.invoke(mWifiManger,null).getClass());



                    //channelString = wifichannels.toString();






                }

                catch(Exception exception){

                    exception.printStackTrace();
                }


            channelTitle.setText(getString(R.string.channelTitle));
                channels.setText(channelString);
            }
        };

        getChannel.setOnClickListener(oclGetChannelBtn);
    }





}
