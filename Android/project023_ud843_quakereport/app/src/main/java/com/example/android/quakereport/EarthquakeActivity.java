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

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    public static final String urlString = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    private EarthquakeArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        final ListView earthquakeListView = (ListView) findViewById(R.id.list);

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

        // create asynctask and execute
        new EarthQuakeDownloaderAsyncTask().execute(urlString);
    }

    /*private void updateUi(List<EarthquakeEvent> earthquakeEvents) {
        if(earthquakeEvents!=null){
            earthQuakeData = earthquakeEvents;

        }
    }*/

    private class EarthQuakeDownloaderAsyncTask extends AsyncTask<String,Void,List<EarthquakeEvent>>{
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
    }
}
