package com.example.android.ahmedabadtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    ArrayList<Attraction> restaurantArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);
        initActivityData();


        ListView restaurantListView = findViewById(R.id.attractionactivity_listview);
        AttractionListItemAdapter restaurantAdapter = new AttractionListItemAdapter(this,restaurantArrayList);
        restaurantListView.setAdapter(restaurantAdapter);

        restaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RestaurantActivity.this,AttractionDetailActivity.class);
                intent.putExtra(AttractionDetailActivity.ATTRACTION_OBJECT,restaurantArrayList.get(i));
                startActivity(intent);
            }
        });
    }

    private void initActivityData() {
        restaurantArrayList= new ArrayList<>();

        restaurantArrayList.add(new Attraction(getString(R.string.agashiye_name),getString(R.string.agashiye_description),new CustomLocation(23.0269515,72.5795285),R.drawable.restaurant_agashiye,Category.CATEGORY_RESTAURANTS));
        restaurantArrayList.add(new Attraction(getString(R.string.chinahouse_name),getString(R.string.chinahouse_description),new CustomLocation(23.0437039,72.5683923),R.drawable.restaurant_chinahouse,Category.CATEGORY_RESTAURANTS));
        restaurantArrayList.add(new Attraction(getString(R.string.neelkanth_name),getString(R.string.neelkanth_description),new CustomLocation(23.0439342,72.5355612),R.drawable.restaurant_patang,Category.CATEGORY_RESTAURANTS));
        restaurantArrayList.add(new Attraction(getString(R.string.villagerest_name),getString(R.string.villagerest_description),new CustomLocation(23.0465678,72.52859),R.drawable.restaurant_village,Category.CATEGORY_RESTAURANTS));
    }
}
