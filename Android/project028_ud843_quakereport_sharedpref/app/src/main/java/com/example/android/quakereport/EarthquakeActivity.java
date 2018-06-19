/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.LoaderManager;
import android.content.Loader;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks <List<EarthquakeEvent>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    public static final String urlString = "https://earthquake.usgs.gov/fdsnws/event/1/query";
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private EarthquakeArrayAdapter mAdapter;

    private TextView mEmptyView;
    private ProgressBar earthquakeProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(LOG_TAG,"inside oncreate of activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        mEmptyView = (TextView) findViewById(R.id.empty_view);
        earthquakeProgressBar = (ProgressBar) findViewById(R.id.progress_earthquakedownload);

        final ListView earthquakeListView = (ListView) findViewById(R.id.list_earthquake);
        earthquakeListView.setEmptyView(mEmptyView);

        mAdapter = new EarthquakeArrayAdapter(EarthquakeActivity.this,new ArrayList <EarthquakeEvent>());
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(mAdapter);
        // Populate earthquake data & update ui

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                EarthquakeEvent currentquake = mAdapter.getItem(position);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(currentquake.getWebsiteUrl()));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        //check if there is internet connection. else do not spin off a loader

        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();

        if(isConnected) {
            // create asynctask and execute
            getLoaderManager().restartLoader(EARTHQUAKE_LOADER_ID, null, this);
        }
        else {
            earthquakeProgressBar.setVisibility(View.GONE);
            mEmptyView.setText(R.string.no_internet);
        }
    }

    @Override
    public Loader <List <EarthquakeEvent>> onCreateLoader(int id, Bundle args) {
        Log.e(LOG_TAG,"inside oncreate loader");

        SharedPreferences sharedpref = PreferenceManager.getDefaultSharedPreferences(this);
        String minMagnitude = sharedpref.getString(getString(R.string.settings_min_magnitude_key),getString(R.string.settings_min_magnitude_default));

        String orderBy = sharedpref.getString(
                getString(R.string.settings_order_by_key),
                getString(R.string.settings_order_by_default)
        );

        Uri baseUri = Uri.parse(urlString);
        Uri.Builder builder = baseUri.buildUpon();

        builder.appendQueryParameter("format","geojson");
        builder.appendQueryParameter("limit", "10");
        builder.appendQueryParameter("minmag",minMagnitude);
        builder.appendQueryParameter("orderby",orderBy);

        EarthquakeAsyncLoader earthquakeAsyncLoader = new EarthquakeAsyncLoader(this,builder.toString());
        return earthquakeAsyncLoader;
    }

    @Override
    public void onLoadFinished(Loader <List <EarthquakeEvent>> loader, List <EarthquakeEvent> data) {
        mEmptyView.setText(R.string.no_earthquakes_to_show);
        earthquakeProgressBar.setVisibility(View.GONE);

        if(data != null && !data.isEmpty() && mAdapter!=null) {
            mAdapter.clear();
            mAdapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader <List <EarthquakeEvent>> loader) {
        Log.e(LOG_TAG,"inside onloaderreset. remove all data");
        if(mAdapter!=null){
            mAdapter.clear();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Intent settingsIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /*private void updateUi(List<EarthquakeEvent> earthquakeEvents) {
        if(earthquakeEvents!=null){
            earthQuakeData = earthquakeEvents;

        }
    }*/

   /* private class EarthQuakeDownloaderAsyncTask extends AsyncTask<String,Void,List<EarthquakeEvent>>{
        public EarthQuakeDownloaderAsyncTask(EarthquakeActivity earthquakeActivity, String urlString) {
        }

        @Override
        protected List <EarthquakeEvent> doInBackground(String... urls) {
            List<EarthquakeEvent> earthquakes = new ArrayList<EarthquakeEvent>();

            if(urls.length < 1 || urls[0]==null)
                return null;

            earthquakes = QueryUtils.extractEarthquakes(urls[0]);
            return earthquakes;
        }

        @Override
        protected void onPostExecute(List <EarthquakeEvent> earthquakeEvents) {
            //clear all previous data
            mAdapter.clear();

            //populate adapter to update ui
            if(earthquakeEvents!=null && !earthquakeEvents.isEmpty()){
                mAdapter.addAll(earthquakeEvents);
            }
        }
    }*/
}
