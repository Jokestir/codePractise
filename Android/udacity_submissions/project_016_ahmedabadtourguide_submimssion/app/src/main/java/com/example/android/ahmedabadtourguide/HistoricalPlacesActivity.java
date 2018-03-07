package com.example.android.ahmedabadtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricalPlacesActivity extends AppCompatActivity {

    ArrayList<Attraction> historicalPlacesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        initActivityData();

        ListView historicalPlacesListView = findViewById(R.id.attractionactivity_listview);
        AttractionListItemAdapter historyAdapter = new AttractionListItemAdapter(this,historicalPlacesArrayList);
        historicalPlacesListView.setAdapter(historyAdapter);

        historicalPlacesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(HistoricalPlacesActivity.this,AttractionDetailActivity.class);
                intent.putExtra(AttractionDetailActivity.ATTRACTION_OBJECT,historicalPlacesArrayList.get(i));
                startActivity(intent);
            }
        });
    }

    private void initActivityData() {
        historicalPlacesArrayList = new ArrayList<>();

        historicalPlacesArrayList.add(new Attraction(getString(R.string.adalajstepwellname),getString(R.string.adalajstep_description),new CustomLocation(23.1667233,72.5778997),R.drawable.history_adalaj,Category.HISTORICAL_PLACES));
        historicalPlacesArrayList.add(new Attraction(getString(R.string.dadaharirstep_name),getString(R.string.dadaharirstep_description),new CustomLocation(23.0407078,72.6035296),R.drawable.history_dadaharirstepwell,Category.HISTORICAL_PLACES));
        historicalPlacesArrayList.add(new Attraction(getString(R.string.sabaramtiashram_name),getString(R.string.sabarmatiashram_description),new CustomLocation(23.0607772,72.5786981),R.drawable.history_sabarmatiashram,Category.HISTORICAL_PLACES));
        historicalPlacesArrayList.add(new Attraction(getString(R.string.bhadrafort_name),getString(R.string.bhadrafort_description),new CustomLocation(23.024012,72.5785996),R.drawable.history_bhadrafort,Category.HISTORICAL_PLACES));
    }
}

