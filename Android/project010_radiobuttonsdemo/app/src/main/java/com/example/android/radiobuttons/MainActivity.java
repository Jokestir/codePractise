package com.example.android.radiobuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioGroup genderSelectRadioGrp;
    Button genderApplyButton;
    TextView genderSubmittedMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        genderSelectRadioGrp = findViewById(R.id.gender_select_radio_group);
        genderApplyButton = findViewById(R.id.apply_gender_button);
        genderSubmittedMessageTextView = findViewById(R.id.gender_selection_applied_message_textview);
    }

    /*Called when apply button is clicked. Check out onClick attr of button in layout.xml*/
    public void genderApplyButtonClicked(View view) {
        RadioButton radioButton = findViewById(genderSelectRadioGrp.getCheckedRadioButtonId());
        genderSubmittedMessageTextView.setVisibility(View.VISIBLE);
        genderSubmittedMessageTextView.setText("Selected Gender: " + radioButton.getText().toString());

    }
}
