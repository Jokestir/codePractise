package com.example.android.sonic_copy;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    /*TAG FOR LOG MESSAGES*/
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    /*URL for data fetch */
    public static final String URLSTRING = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2012-01-01&endtime=2012-12-01&minmagnitude=6";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TsunamiAsyncTask tsunamiAsyncTask = new TsunamiAsyncTask();
        tsunamiAsyncTask.execute();
    }

    private void updateUi(Event event) {
        Log.e(LOG_TAG,"inside update ui");
        TextView eventdata = (TextView) findViewById(R.id.eventdata);
        TextView datedata = (TextView) findViewById(R.id.date_data);
        TextView tsunamidata = (TextView) findViewById(R.id.tsunamialert_data);
        eventdata.setText(event.getEventTitle());
        datedata.setText(formatDate(event.getUnixTimeInMillis()));
        tsunamidata.setText(getTsunamiAlertString(event.getHasTsunmaiAlert()));
    }

    private String getTsunamiAlertString(int hasTsunmaiAlert) {
        switch (hasTsunmaiAlert){
            case 0:
                return getString(R.string.alert_no);
            case 1:
                return getString(R.string.alert_yes);
            default:
                return getString(R.string.alert_not_available);
        }
    }

    private String formatDate(long unixTimeInMillis) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy 'at' HH:mm:ss z");
        Date dateObj = new Date(unixTimeInMillis);
        return formatter.format(dateObj);
    }

    private class TsunamiAsyncTask extends AsyncTask <URL, Void, Event> {


        String jsonResponse = null;

        @Override
        protected Event doInBackground(URL... urls) {
            Log.e(LOG_TAG,"inside do in background");
            String jsonResponse = null;
            URL url = createURL(URLSTRING);
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            Event event = extractFeatureFromJson(jsonResponse);
            return event;
        }

        private Event extractFeatureFromJson(String jsonResponse) {
            Log.e(LOG_TAG,"inside extractfeaturefromstring");
            if(TextUtils.isEmpty(jsonResponse)){
                Log.e(LOG_TAG,"jsonstring is empty inside extractfeaturefromjson. returning null");
                return null;
            }

            try {
                JSONObject rootjsonObject = new JSONObject(jsonResponse);
                JSONArray featuresArray = rootjsonObject.getJSONArray("features");
                if(featuresArray.length() > 0){
                    JSONObject firstEvent = featuresArray.getJSONObject(0);
                    JSONObject properties = firstEvent.getJSONObject("properties");
                    String title = properties.getString("title");
                    long time = properties.getLong("time");
                    int tsunami = properties.getInt("tsunami");
                    return new Event(title,time,tsunami);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.e(LOG_TAG,"returning null from extracteventfromjson");
            return null;
        }

        private URL createURL(String urlstring) {
            Log.e(LOG_TAG,"inside createurl");
            URL url = null;

            try {
                url = new URL(urlstring);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return url;
        }

        private String makeHttpRequest(URL url) throws IOException {
            Log.e(LOG_TAG,"inside makehttprequest");
            String jsonResponse = null;
            InputStream inputStream = null;
            HttpURLConnection httpconnection = null;

            /* Return early if url is null*/
            if (url == null) {
                Log.e(LOG_TAG,"url is null inside makehttp");
                return null;
            }

            try {
                httpconnection = (HttpURLConnection) url.openConnection();
                httpconnection.setRequestMethod("GET");
                httpconnection.setConnectTimeout(10000);// 10s
                httpconnection.setReadTimeout(15000);//15s
                httpconnection.connect();

                // if the response code is 200, read the input stream else log an error
                if (httpconnection.getResponseCode() == 200) {
                    inputStream = httpconnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                }
                else {
                    Log.e(LOG_TAG,"http response is not 200 ok");
                }

            } catch (IOException ioex) {
                ioex.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (httpconnection != null)
                    httpconnection.disconnect();
                if (inputStream != null) //calling func to handle IOEx here
                    inputStream.close();
            }

            Log.e(LOG_TAG,"httpconnection returning json: " + jsonResponse);
            return jsonResponse;
        }

        private String readFromStream(InputStream inputStream) throws IOException {
            Log.e(LOG_TAG,"inside readFromStream");
            StringBuilder output = new StringBuilder();

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            Log.e(LOG_TAG,"output string: " + output.toString());
            return output.toString();
        }

        @Override
        protected void onPostExecute(Event event) {
            Log.e(LOG_TAG,"inside onpostexecute");
            if (event == null){
                Log.e(LOG_TAG,"event is null inside postexecute");
                return;
            }
            updateUi(event);
        }
    }

}
