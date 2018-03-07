package com.example.android.ahmedabadtourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CategoryAdapter extends ArrayAdapter {

    public CategoryAdapter(@NonNull Context context, @NonNull ArrayList<Category> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.category_listview_item,parent,false);
        }

        Category currentCategory = (Category) this.getItem(position);

        TextView txtview = listItemView.findViewById(R.id.category_namestring);
        txtview.setText(currentCategory.getName());

        ImageView imgView = listItemView.findViewById(R.id.category_image);
        imgView.setImageResource(currentCategory.getIconResourceId());

        return  listItemView;
    }
}
