package com.example.android.ahmedabadtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MuseumActivity extends AppCompatActivity {

    ArrayList<Attraction> museumArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        initActivityData();

        ListView museumListView = findViewById(R.id.attractionactivity_listview);
        AttractionListItemAdapter museumAdapter = new AttractionListItemAdapter(this,museumArrayList);
        museumListView.setAdapter(museumAdapter);

        museumListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MuseumActivity.this,AttractionDetailActivity.class);
                intent.putExtra(AttractionDetailActivity.ATTRACTION_OBJECT,museumArrayList.get(i));
                startActivity(intent);
            }
        });
    }

    private void initActivityData() {
        museumArrayList = new ArrayList<>();

        museumArrayList.add(new Attraction(getString(R.string.calicomuserum_name),getString(R.string.calico_description),new CustomLocation(23.0541796,72.5890665),R.drawable.museum_calico,Category.CATEGORY_MUSEUMS));
        museumArrayList.add(new Attraction(getString(R.string.patangmuseum_name),getString(R.string.patangmuseum_description),new CustomLocation(23.0156314,72.5665971),R.drawable.museum_kite,Category.CATEGORY_MUSEUMS));
        museumArrayList.add(new Attraction(getString(R.string.automuseum_name),getString(R.string.automuseum_description),new CustomLocation(23.057315,72.683302),R.drawable.museum_autoworld,Category.CATEGORY_MUSEUMS));
        museumArrayList.add(new Attraction(getString(R.string.vecharmuseum_name),getString(R.string.vecharmuseum_description),new CustomLocation(22.993861,72.5332849),R.drawable.museum_vechaar,Category.CATEGORY_MUSEUMS));
    }
}
