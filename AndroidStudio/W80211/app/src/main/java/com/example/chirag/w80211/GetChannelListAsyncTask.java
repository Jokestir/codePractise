package com.example.chirag.w80211;

import android.Manifest;
import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.net.wifi.WifiInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class GetChannelListAsyncTask extends AsyncTask{


    /******* global objects in class****/


    private static String TAG = "Beethoven";
    private Activity appContext;


    WifiManager mWifiManager;

    ArrayList<String> channels24ghzList;
    ArrayList<String> channels5ghzList;

    TextView channel24ghzTitle;
    TextView channels24ghz;
    TextView channel5ghzTitle;
    TextView channels5ghz;
    TextView getCountry;
    TextView countryCodeTitle;
    TextView MacAddressTitle;
    TextView MACID;
    String macAddress;
    String country;



    /********** Constructor*********/

    public GetChannelListAsyncTask(Context context) {
        super();

        //get calling app
        this.appContext = (Activity) context;


        mWifiManager =  (WifiManager) this.appContext.getSystemService(Context.WIFI_SERVICE);

        //initialize UI

        channel24ghzTitle = (TextView) this.appContext.findViewById(R.id.channel24ghzTitle);
        channels24ghz = (TextView) this.appContext.findViewById(R.id.channels24ghzList);
        channel5ghzTitle = (TextView) this.appContext.findViewById(R.id.channel5ghzTitle);
        channels5ghz  = (TextView) this.appContext.findViewById(R.id.channels5ghzList);
        getCountry = (TextView) this.appContext.findViewById(R.id.getCountry);
        countryCodeTitle = (TextView) this.appContext.findViewById(R.id.CountryCodeTitle);


        MacAddressTitle = (TextView) this.appContext.findViewById(R.id.CountryCodeTitle);
        MACID = (TextView) this.appContext.findViewById(R.id.CountryCodeTitle);


    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        // initialize arraylist

        channels24ghzList = new ArrayList<String>();
        channels5ghzList = new ArrayList<String>();



        // clear channel list

        /*if(channels5ghzList != null && channels24ghzList != null) {
            channels5ghzList.clear();
            channels24ghzList.clear();
        }*/
    }

    @Override
    protected Object doInBackground(Object[] objects) {


        WifiInfo wifiInfo= mWifiManager.getConnectionInfo();

        macAddress = wifiInfo.getMacAddress();

        // reflection code to populate lists
        try{

            Method getChannelListMethod = WifiManager.class.getMethod("getChannelList");
            ArrayList<?> listOfWifiChannelObjects = (ArrayList)getChannelListMethod.invoke(mWifiManager,null);

            Method getCountryMethod = WifiManager.class.getMethod("getCountryCode");




            country = (String) getCountryMethod.invoke(mWifiManager,null);
            //Log.e(TAG,"Country:" + country);

            for (Object wifichannelObject : listOfWifiChannelObjects){

                Field channelNumField = wifichannelObject.getClass().getField("channelNum");
                String channelNum = channelNumField.get(wifichannelObject).toString();

                if(Integer.parseInt(channelNum) <= 14){
                    channels24ghzList.add(channelNum);
                }
                else{
                    channels5ghzList.add(channelNum);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {

        super.onPostExecute(o);

        // update UX
        channel24ghzTitle.setText("2.4ghz channels");
        channels24ghz.setText(android.text.TextUtils.join(", ", channels24ghzList));
        channel5ghzTitle.setText("5 Ghz channels");


        if(channels5ghzList.isEmpty()) {
            channels5ghz.setTextColor(Color.rgb(200,0,0));
            channels5ghz.setText("NA");
        }
        else {
            channels5ghz.setText(android.text.TextUtils.join(", ", channels5ghzList));
        }


        countryCodeTitle.setText("Country Code");
        MacAddressTitle.setText("MACID");

        // display country
        if (country!=null){
            getCountry.setText(country);
        }

        else{
            getCountry.setText("null");

        }

        //display MACID

        MACID.setText(macAddress);



    }
}



