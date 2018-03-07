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

public class NumbersActivity extends AppCompatActivity {

    // convert array to arraylist
    static ArrayList<Word> words;
    MediaPlayer pronouncePlayer;
    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaResources();
        }
    };

    private void releaseMediaResources() {
        if (pronouncePlayer != null) {
            pronouncePlayer.release();
            pronouncePlayer = null;
        }
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        intiArrayListData();

        ListView numbersListView = (ListView) findViewById(R.id.words_listview);
        final WordAdapter wordadapter = new WordAdapter(this, words, R.color.category_numbers);
        numbersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaResources();
                pronouncePlayer = MediaPlayer.create(NumbersActivity.this, wordadapter.getItem(position).getAudioResourceId());
                pronouncePlayer.start();
                pronouncePlayer.setOnCompletionListener(mOnCompletionListener);
            }
        });
        numbersListView.setAdapter(wordadapter);


        /*ListView listview = (ListView) findViewById(R.id.words_listview);
        ArrayAdapter<Word> adapter = new ArrayAdapter<Word>(this,R.layout.numberslist_item,words);
        listview.setAdapter(adapter);*/

        // the below code is for linearlayout. we have instead decided to use listview
        /*LinearLayout rootView = (LinearLayout) findViewById(R.id.words_linearlayout);

        // can also be for(index=0;index<words.size();index++)
        for (String word:words){
            TextView txtView = new TextView(NumbersActivity.this);
            txtView.setText(word);
            rootView.addView(txtView);
        }*/
    }

    private void intiArrayListData() {
        words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "ottiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oy yisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massoka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaResources();
    }
}
