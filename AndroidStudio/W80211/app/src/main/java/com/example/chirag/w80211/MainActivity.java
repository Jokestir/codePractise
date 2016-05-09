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


public class MainActivity extends Activity {

    WifiManager mWifiManger;
    ArrayList<String> channels24ghzList;
    ArrayList<String> channels5ghzList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        channels24ghzList = new ArrayList<String>();
        channels5ghzList = new ArrayList<String>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWifiManger = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        Button getChannel = (Button) findViewById(R.id.getChannelButton);
        final TextView channel24ghzTitle = (TextView) findViewById(R.id.channel24ghzTitle);
        final TextView channels24ghz = (TextView) findViewById(R.id.channels24ghzList);
        final TextView channel5ghzTitle = (TextView) findViewById(R.id.channel5ghzTitle);
        final TextView channels5ghz  = (TextView) findViewById(R.id.channels5ghzList);

        View.OnClickListener oclGetChannelBtn = new View.OnClickListener() {
            //String channelString;





            @Override
            public void onClick(View view) {

                // reset the arrays

                channels5ghzList.clear();
                channels24ghzList.clear();

                // reflection code

                try {
                    // load the class

                    //Class wifiChannelClass = Class.forName("android.net.wifi.WifiChannel");




                    // create an instance of


                   //Object WifiChannel = wifiChannelClass.newInstance();


                    // find getChannelList() method from Wifimanager

                    Method getChannelListMethod = WifiManager.class.getMethod("getChannelList",null);

                    ArrayList<?> listOfWifiChannelObjects = (ArrayList<?>) getChannelListMethod.invoke(mWifiManger,null);

                    for (Object wifiChannelObject : listOfWifiChannelObjects){

                        Field channelNumField = wifiChannelObject.getClass().getDeclaredField("channelNum");

                        String channelNum = channelNumField.get(wifiChannelObject).toString();



                        if(Integer.parseInt(channelNum) <= 14){

                            channels24ghzList.add(channelNum);

                        }

                        else{

                            channels5ghzList.add(channelNum);

                        }


                    }

                    //String channels24ghz = TextUtils.join(", ", channels24ghzList);

                    //String channels5ghz = TextUtils.join(", ", channels5ghzList);

                    //channelString = channelString.substring(0,channelString.length()-2);

                    //Log.e("CHIRAG"," " + getChannelListMethod.invoke(mWifiManger,null).getClass());



                    //channelString = wifichannels.toString();






                }

                catch(Exception exception){

                    exception.printStackTrace();
                }


                channel24ghzTitle.setText("2.4ghz channels");
                channels24ghz.setText(android.text.TextUtils.join(", ", channels24ghzList));
                channel5ghzTitle.setText("5 Ghz channels");
                channels5ghz.setText(android.text.TextUtils.join(", ", channels5ghzList));

            }
        };

        getChannel.setOnClickListener(oclGetChannelBtn);
    }





}
