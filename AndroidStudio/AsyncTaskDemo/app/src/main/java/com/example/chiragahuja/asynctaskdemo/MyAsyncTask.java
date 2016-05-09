package com.example.chiragahuja.asynctaskdemo;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;




public class MyAsyncTask extends AsyncTask{

    public static String TAG = "Beethoven";

    private Activity appActivity;

    private TextView output;

    public MyAsyncTask(Context appcontext) {
        super();
        this.appActivity = (Activity) appcontext;

    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        Log.e(TAG,"Inside onPreExecute");
        output = (TextView) appActivity.findViewById(R.id.textOutput);
        output.setText("Begin");

    }

    @Override
    protected Object doInBackground(Object[] objects) {
        Log.e(TAG,"Inside doInBackground");
        try {
            TimeUnit.SECONDS.sleep(9);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.e(TAG,"Inside onPostExecute");
        output.setText("End");
    }
}

