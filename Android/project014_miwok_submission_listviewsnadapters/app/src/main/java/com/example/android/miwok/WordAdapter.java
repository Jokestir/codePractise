package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResourceId;
    // custom constructor
    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int colorId) {
        super(context, 0, words);
        this.colorResourceId = colorId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        // no recycling
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.numberslist_item, parent, false);
        }

        int listBackgroundColor = ContextCompat.getColor(getContext(),colorResourceId);
        listItemView.setBackgroundColor(listBackgroundColor);

        final Word currentWord = this.getItem(position);

        TextView mowakTextView = (TextView) listItemView.findViewById(R.id.mowak_translationnumber);
        mowakTextView.setText(currentWord.getMowakTranslation());


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.english_translationnumber);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageAssociated = (ImageView) listItemView.findViewById(R.id.word_image);

        int imageColor = ContextCompat.getColor(getContext(),R.color.tan_background);
        imageAssociated.setBackgroundColor(imageColor);

        if (currentWord.hasImage()) {
            imageAssociated.setImageResource(currentWord.getImageReourceId());
            imageAssociated.setVisibility(View.VISIBLE);
        } else
            imageAssociated.setVisibility(View.GONE);

        return listItemView;
    }
}
