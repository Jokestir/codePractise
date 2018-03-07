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


public class FamilyFragment extends Fragment {

    static ArrayList<Word> familyList;
    MediaPlayer pronouncePlayer;
    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaResources();
        }
    };

    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                pronouncePlayer.pause();
                pronouncePlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                pronouncePlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaResources();
            }
        }
    };

    private void releaseMediaResources() {
        if (pronouncePlayer != null){
            pronouncePlayer.release();
            pronouncePlayer = null;
        }
    }


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_words,container,false);
        initFamilyList();
        mAudioManager = (AudioManager) getActivity().getSystemService(getActivity().AUDIO_SERVICE);

        ListView familyListView = (ListView) rootview.findViewById(R.id.words_listview);
        final WordAdapter familyAdapter = new WordAdapter(getActivity(), familyList,R.color.category_family);
        familyListView.setAdapter(familyAdapter);
        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaResources();
                pronouncePlayer = MediaPlayer.create(getActivity(),familyAdapter.getItem(position).getAudioResourceId());
                pronouncePlayer.start();
                pronouncePlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });

        return rootview;
    }

    private void initFamilyList() {
        familyList = new ArrayList<>();

        familyList.add(new Word("father", "әpә", R.drawable.family_father,R.raw.family_father));
        familyList.add(new Word("mother", "әṭa", R.drawable.family_mother,R.raw.family_mother));
        familyList.add(new Word("son", "angsi", R.drawable.family_son,R.raw.family_son));
        familyList.add(new Word("daughter", "tune", R.drawable.family_daughter,R.raw.family_daughter));
        familyList.add(new Word("older brother", "taachi", R.drawable.family_older_brother,R.raw.family_older_brother));
        familyList.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother,R.raw.family_younger_brother));
        familyList.add(new Word("older sister", "teṭe", R.drawable.family_older_sister,R.raw.family_older_sister));
        familyList.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        familyList.add(new Word("grandmother", "ama", R.drawable.family_grandmother,R.raw.family_grandmother));
        familyList.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,R.raw.family_grandfather));
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaResources();
    }
}
