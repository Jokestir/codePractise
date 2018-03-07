package com.example.android.miwok;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    ArrayList<Word> phrasesArrayList;
    MediaPlayer pronouncePlayer;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initPhrasesList();

        ListView phrasesListView = (ListView) findViewById(R.id.words_listview);
        final WordAdapter phraseAdapter = new WordAdapter(this, phrasesArrayList,R.color.category_phrases);
        phrasesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaResources();
                pronouncePlayer = MediaPlayer.create(PhrasesActivity.this,phraseAdapter.getItem(position).getAudioResourceId());
                pronouncePlayer.start();
                pronouncePlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });
        phrasesListView.setAdapter(phraseAdapter);
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


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, intent)) {
                    TaskStackBuilder.create(this).addNextIntentWithParentStack(intent).startActivities();
                } else {
                    NavUtils.navigateUpTo(this, intent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaResources();
    }
}
