package com.example.android.ahmedabadtourguide;


import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AttractionListItemAdapter extends ArrayAdapter<Attraction> {

    public AttractionListItemAdapter(@NonNull Context context,@NonNull ArrayList<Attraction> objects) {
        super(context, 0 , objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.attractions_listitem_adapter,parent,false);
        }

        Attraction currentAttraction = getItem(position);

        TextView attractionName = convertView.findViewById(R.id.attraction_textstringname);
        attractionName.setText(currentAttraction.getName());

        ImageView imageName = convertView.findViewById(R.id.attraction_thumbnail);
        imageName.setImageResource(currentAttraction.getImageResourceId());
        imageName.setScaleType(ImageView.ScaleType.CENTER_CROP);

        return convertView;
    }
}
