package com.example.chirag.w80211;

import android.app.Activity;
import android.os.AsyncTask;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class GetChannelListAsyncTask extends AsyncTask{


    /******* global objects in class
    ****/


    private static String TAG = "Beethoven";
    private Activity appContext;


    WifiManager mWifiManager;

    ArrayList<String> channels24ghzList;
    ArrayList<String> channels5ghzList;

    TextView channel24ghzTitle;
    TextView channels24ghz;
    TextView channel5ghzTitle;
    TextView channels5ghz;






    public GetChannelListAsyncTask(Context context) {
        super();

        //get calling app
        this.appContext = (Activity) context;


        mWifiManager =  (WifiManager) this.appContext.getSystemService(Context.WIFI_SERVICE);

        //initialize UI

        TextView channel24ghzTitle = (TextView) this.appContext.findViewById(R.id.channel24ghzTitle);
        TextView channels24ghz = (TextView) this.appContext.findViewById(R.id.channels24ghzList);
        TextView channel5ghzTitle = (TextView) this.appContext.findViewById(R.id.channel5ghzTitle);
        TextView channels5ghz  = (TextView) this.appContext.findViewById(R.id.channels5ghzList);


    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // clear channel list everytime
        channels5ghzList.clear();
        channels24ghzList.clear();
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        // reflection code to populate lists
        try{

            Method getChannelListMethod = WifiManager.class.getMethod("getChannelList");
            ArrayList<?> listOfWifiChannelObjects = (ArrayList)getChannelListMethod.invoke(mWifiManager,null);

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
        channels5ghz.setText(android.text.TextUtils.join(", ", channels5ghzList));
    }
}



