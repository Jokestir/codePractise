package com.example.android.miwok;

import android.annotation.TargetApi;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    ArrayList<Word> familyList;
    MediaPlayer pronouncePlayer;
    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaResources();
        }
    };

    private void releaseMediaResources() {
        if (pronouncePlayer != null){
            pronouncePlayer.release();
            pronouncePlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initFamilyList();

        ListView familyListView = (ListView) findViewById(R.id.words_listview);
        final WordAdapter familyAdapter = new WordAdapter(this, familyList,R.color.category_family);
        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaResources();
                pronouncePlayer = MediaPlayer.create(FamilyActivity.this,familyAdapter.getItem(position).getAudioResourceId());
                pronouncePlayer.start();
                pronouncePlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });
        familyListView.setAdapter(familyAdapter);
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
    protected void onStop() {
        super.onStop();
        releaseMediaResources();
    }
}
