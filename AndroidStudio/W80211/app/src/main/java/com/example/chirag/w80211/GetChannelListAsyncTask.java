package com.example.chirag.w80211;

import android.app.Activity;
import android.os.AsyncTask;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by chirag.ahuja on 5/9/2016.
 */
public class GetChannelListAsyncTask extends AsyncTask{


    // global app context declaration to access UI
    private Activity appContext;

    // get wifimanager object

    WifiManager mWifiManager;

    // channellists
    ArrayList<String> channels24ghzList;
    ArrayList<String> channels5ghzList;

    // log tag
    private static String TAG = "Beethoven";


    // Over ride constructor to get activity context and initialize objects to be used in asynctask

    public GetChannelListAsyncTask(Context context) {

        super();

        // // global app initialization to access UI

        this.appContext = (Activity) context;

        // get wifimanager for reflection

        mWifiManager =  (WifiManager) this.appContext.getSystemService(Context.WIFI_SERVICE);

        // initialize wifi channels arrayLists to empty everytime button is pressed.

        channels5ghzList.clear();
        channels24ghzList.clear();


        Log.e(TAG,"Constructor AsyncTask");
    }


    @Override
    protected void onPreExecute() {

        super.onPreExecute();


        Log.e(TAG,"OnPreExecute");
    }

    @Override
    protected Object doInBackground(Object[] objects) {



        Log.e(TAG,"doInBackGround");

        return null;
    }

    @Override
    protected void onPostExecute(Object o) {

        super.onPostExecute(o);

        Log.e(TAG,"OnPostExecute");

    }
}



