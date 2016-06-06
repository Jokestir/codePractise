package com.example.chiragahuja.numberpickerdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity {

    NumberPicker intPicker;

    TextView numberDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intPicker = (NumberPicker) findViewById(R.id.intPicker);

        numberDisplay =  (TextView) findViewById(R.id.numberDisplay);


        intPicker.setMaxValue(10);

        intPicker.setMinValue(0);

        intPicker.setWrapSelectorWheel(true);

        intPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                numberDisplay.setText(String.valueOf(i1));

            }
        });
    }
}