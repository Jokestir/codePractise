package com.example.android.lifecycledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "chirag";

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG,"onResume called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG,"onStart called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate called");
        setContentView(R.layout.activity_main);
    }
}
