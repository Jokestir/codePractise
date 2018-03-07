package com.example.android.miwok;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    static ArrayList<Word> phrasesArrayList;
    MediaPlayer pronouncePlayer;
    private AudioManager mAudioManager;

    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaResources();
        }
    };

    private void releaseMediaResources() {
        if(pronouncePlayer != null){
            pronouncePlayer.release();
            pronouncePlayer = null;
        }
    }

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootview = inflater.inflate(R.layout.activity_words,container,false);
        mAudioManager = (AudioManager) getActivity().getSystemService(getActivity().AUDIO_SERVICE);

        initPhrasesList();

        ListView phrasesListView = (ListView) rootview.findViewById(R.id.words_listview);
        final WordAdapter phraseAdapter = new WordAdapter(getActivity(), phrasesArrayList,R.color.category_phrases);
        phrasesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaResources();
                pronouncePlayer = MediaPlayer.create(getActivity(),phraseAdapter.getItem(position).getAudioResourceId());
                pronouncePlayer.start();
                pronouncePlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });
        phrasesListView.setAdapter(phraseAdapter);


       return rootview;
    }

    private void initPhrasesList() {
        phrasesArrayList = new ArrayList<>();

        phrasesArrayList.add(new Word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        phrasesArrayList.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        phrasesArrayList.add(new Word("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        phrasesArrayList.add(new Word(" How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        phrasesArrayList.add(new Word("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        phrasesArrayList.add(new Word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        phrasesArrayList.add(new Word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        phrasesArrayList.add(new Word("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        phrasesArrayList.add(new Word("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        phrasesArrayList.add(new Word("Come here.", "әnni'nem",R.raw.phrase_come_here));
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaResources();
    }
}
