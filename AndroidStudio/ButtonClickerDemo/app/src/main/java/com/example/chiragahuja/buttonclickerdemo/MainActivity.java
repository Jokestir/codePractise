package com.example.chiragahuja.buttonclickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button okButton = (Button) findViewById(R.id.okButton);

        Button cancelButton = (Button) findViewById(R.id.cancelButton);

        final TextView textOutput = (TextView) findViewById(R.id.textOutput);

        View.OnClickListener okBtnListenerObject = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textOutput.setText("Ok presseed");

            }
        };


        okButton.setOnClickListener(okBtnListenerObject);

        View.OnClickListener cancelBtnOcl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textOutput.setText("Cancel Button Pressed");
            }
        };


        cancelButton.setOnClickListener(cancelBtnOcl);
    }
}
