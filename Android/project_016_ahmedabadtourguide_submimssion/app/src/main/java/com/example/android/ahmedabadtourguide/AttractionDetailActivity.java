package com.example.android.ahmedabadtourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AttractionDetailActivity extends AppCompatActivity {

    // these strings are not userfacing and hence dont need to be translated. so not in strings.xml
    public static final String ATTRACTION_OBJECT = "ATTRACTION_OBJECT";
    private static final String GEOLOCATION_MIME = "geo:";

    private Attraction currentAttraction;
    ImageView imageView;
    TextView attractionNameTextView;
    TextView attractionDescriptionTextView;
    Button directionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);
        intiViewsAndListeners();

        Intent intent = this.getIntent();
        if(intent!=null){
            currentAttraction = (Attraction) intent.getSerializableExtra(ATTRACTION_OBJECT);
        }

        if(currentAttraction!=null){
            attractionNameTextView.setText(currentAttraction.getName());
            imageView.setImageResource(currentAttraction.getImageResourceId());
            attractionDescriptionTextView.setText(currentAttraction.getDescription());
        }

        directionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(Uri.parse(AttractionDetailActivity.GEOLOCATION_MIME + currentAttraction.getLocation().toString()));
            }
        });
    }

    private void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    private void intiViewsAndListeners() {
        attractionNameTextView = findViewById(R.id.attraction_nametext);
        imageView = findViewById(R.id.attraction_headerimage);
        attractionDescriptionTextView = findViewById(R.id.attraction_desc);
        directionButton = findViewById(R.id.directionImageButton);
    }

}
