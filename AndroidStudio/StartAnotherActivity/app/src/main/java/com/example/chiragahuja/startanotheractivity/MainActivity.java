package com.example.chiragahuja.startanotheractivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static  final String EXTRA_MESSAGE = "com.example.chiragahuja.startanotheractivity.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        Button button = (Button) findViewById(R.id.staer_activity);

        View.OnClickListener launchActivityListener = new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Button pressed",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,secondary.class);

                intent.putExtra(EXTRA_MESSAGE, "hello second activity");

                startActivity(intent);




            }
        };


        button.setOnClickListener(launchActivityListener);

    }
}
