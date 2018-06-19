package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static com.example.android.quakereport.QueryUtils.extractEarthquakes;

public class EarthquakeAsyncLoader extends AsyncTaskLoader<List<EarthquakeEvent>> {

    public static final String LOG_TAG = EarthquakeAsyncLoader.class.getSimpleName();
    private String mUrl;

    public EarthquakeAsyncLoader(Context context,String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List <EarthquakeEvent> loadInBackground() {
        Log.e(LOG_TAG,"inside loadinbackground");
        if(mUrl ==null || mUrl.trim().isEmpty()) {
            return null;
        }

        List<EarthquakeEvent> earthquakeEventList = QueryUtils.extractEarthquakes(mUrl);
        return earthquakeEventList;
    }

    @Override
    protected void onStartLoading() {
        Log.e(LOG_TAG,"inside onstartloading");
        forceLoad();
    }
}
