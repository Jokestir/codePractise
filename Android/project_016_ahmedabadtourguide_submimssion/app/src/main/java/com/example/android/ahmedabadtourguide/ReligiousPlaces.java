package com.example.android.ahmedabadtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ReligiousPlaces extends AppCompatActivity {

    ArrayList<Attraction> religiousArrayListAttractions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        intiActvityData();

        ListView religiousListView = findViewById(R.id.attractionactivity_listview);
        AttractionListItemAdapter religiousAdapter = new AttractionListItemAdapter(this,religiousArrayListAttractions);
        religiousListView.setAdapter(religiousAdapter);

        religiousListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ReligiousPlaces.this,AttractionDetailActivity.class);
                intent.putExtra(AttractionDetailActivity.ATTRACTION_OBJECT,religiousArrayListAttractions.get(i));
                startActivity(intent);
            }
        });
    }

    private void intiActvityData() {
        religiousArrayListAttractions = new ArrayList<>();

        religiousArrayListAttractions.add(new Attraction(getString(R.string.hatheetemple_name),getString(R.string.hatheetemple_description),new CustomLocation(23.0408774,72.5875215),R.drawable.religion_hatheesingh,Category.RELIGIOUS_PLACES));
        religiousArrayListAttractions.add(new Attraction(getString(R.string.jamamasjid_name),getString(R.string.jamamasjid_description),new CustomLocation(23.0096013,72.510906),R.drawable.religion_jama_masjid,Category.RELIGIOUS_PLACES));
        religiousArrayListAttractions.add(new Attraction(getString(R.string.iskontemple_name),getString(R.string.iskontemple_description),new CustomLocation(23.0410249,72.5196689),R.drawable.religion_iskon,Category.RELIGIOUS_PLACES));
        religiousArrayListAttractions.add(new Attraction(getString(R.string.sidijali_name),getString(R.string.sidijali_description),new CustomLocation(23.0269899,72.5788043),R.drawable.religion_jalisidi,Category.RELIGIOUS_PLACES));
        religiousArrayListAttractions.add(new Attraction(getString(R.string.akshardham_name),getString(R.string.akshardham_description),new CustomLocation(23.2293154,72.6719424),R.drawable.religion_akshardham,Category.RELIGIOUS_PLACES));
    }
}
