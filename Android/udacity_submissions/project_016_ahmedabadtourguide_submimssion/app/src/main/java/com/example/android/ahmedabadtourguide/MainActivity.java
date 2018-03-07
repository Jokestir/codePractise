package com.example.android.ahmedabadtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Category> categoryArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiArrayListData();

        ListView categoryListView = findViewById(R.id.mainactivity_rootlistview);
        categoryListView.setAdapter(new CategoryAdapter(this,categoryArrayList));
        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (categoryArrayList.get(i).getType()){
                    case Category.HISTORICAL_PLACES:
                        Intent historyIntent = new Intent(MainActivity.this,HistoricalPlacesActivity.class);
                        startActivity(historyIntent);
                        break;
                    case Category.CATEGORY_MUSEUMS:
                        Intent museumIntent = new Intent(MainActivity.this,MuseumActivity.class);
                        startActivity(museumIntent);
                        break;
                    case Category.CATEGORY_OUTDOOR:
                        Intent outdoorIntent = new Intent(MainActivity.this,OutdoorActivities.class);
                        startActivity(outdoorIntent);
                        break;
                    case Category.RELIGIOUS_PLACES:
                        Intent religionIntent = new Intent(MainActivity.this,ReligiousPlaces.class);
                        startActivity(religionIntent);
                        break;
                    case Category.CATEGORY_RESTAURANTS:
                        Intent restaurantIntent = new Intent(MainActivity.this,RestaurantActivity.class);
                        startActivity(restaurantIntent);
                        break;
                }
            }
        });

    }

    private void intiArrayListData() {
        categoryArrayList = new ArrayList<>();

        categoryArrayList.add(new Category(Category.RELIGIOUS_PLACES,getString(R.string.religion_category),R.drawable.ic_religion_24dp));
        categoryArrayList.add(new Category(Category.CATEGORY_RESTAURANTS,getString(R.string.restaurant_category),R.drawable.ic_restaurant_black_48dp));
        categoryArrayList.add(new Category(Category.HISTORICAL_PLACES,getString(R.string.historicalplaces_category),R.drawable.ic_historical));
        categoryArrayList.add(new Category(Category.CATEGORY_OUTDOOR,getString(R.string.outdoor_category),R.drawable.ic_outdoor_48dp));
        categoryArrayList.add(new Category(Category.CATEGORY_MUSEUMS,getString(R.string.museum_category),R.drawable.ic_mueseum_black_48dp));
    }
}
