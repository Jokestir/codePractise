package com.example.android.ahmedabadtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class OutdoorActivities extends AppCompatActivity {

    ArrayList<Attraction> outdoorItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        initActivityData();

        ListView outdoorListView = findViewById(R.id.attractionactivity_listview);
        AttractionListItemAdapter outDoorAdapter = new AttractionListItemAdapter(this,outdoorItemArrayList);
        outdoorListView.setAdapter(outDoorAdapter);

        outdoorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(OutdoorActivities.this,AttractionDetailActivity.class);
                intent.putExtra(AttractionDetailActivity.ATTRACTION_OBJECT,outdoorItemArrayList.get(i));
                startActivity(intent);
            }
        });

    }

    private void initActivityData() {
        outdoorItemArrayList = new ArrayList<>();

        outdoorItemArrayList.add(new Attraction(getString(R.string.sunsetcinema_name),getString(R.string.sunsetcinema_description),new CustomLocation(23.0492775,72.5102879),R.drawable.outdoor_drivein,Category.CATEGORY_OUTDOOR));
        outdoorItemArrayList.add(new Attraction(getString(R.string.lawgarden_name),getString(R.string.lawgarden_description),new CustomLocation(23.0273795,72.5584604),R.drawable.outdoor_lawgarden,Category.CATEGORY_OUTDOOR));
        outdoorItemArrayList.add(new Attraction(getString(R.string.vastrapurlake_name),getString(R.string.vastrapurlake_description),new CustomLocation(23.0384031,72.5267135),R.drawable.outdoor_vastrapurlake,Category.CATEGORY_OUTDOOR));
        outdoorItemArrayList.add(new Attraction(getString(R.string.kankarialake_name),getString(R.string.kankarialake_description),new CustomLocation(23.0062201,72.5989987),R.drawable.outdoor_kankaria,Category.CATEGORY_OUTDOOR));
        outdoorItemArrayList.add(new Attraction(getString(R.string.sabarmatiriverfront_name),getString(R.string.sabaramtiashram_description),new CustomLocation(23.0355777,72.5802623),R.drawable.outdoor_riverfront,Category.CATEGORY_OUTDOOR));
    }
}
