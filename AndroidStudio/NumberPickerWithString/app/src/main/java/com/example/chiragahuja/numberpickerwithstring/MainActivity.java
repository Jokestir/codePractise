package com.example.chiragahuja.numberpickerwithstring;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    TextView stringDisplay;

    NumberPicker stringPicker;

    final String[] stringValues = {"Red","Blue","Green","Yellow","Orange"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringDisplay = (TextView) findViewById(R.id.stringDisplay);
        stringPicker = (NumberPicker) findViewById(R.id.stringPicker);

        stringPicker.setMinValue(0);
        stringPicker.setMaxValue(stringValues.length -1);

        stringPicker.setWrapSelectorWheel(true);

        stringPicker.setDisplayedValues(stringValues);

        stringPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){

            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {

                stringDisplay.setText(stringValues[newValue]);


            }
        });



    }
}
