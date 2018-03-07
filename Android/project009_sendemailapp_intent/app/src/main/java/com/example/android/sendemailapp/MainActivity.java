package com.example.android.sendemailapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText recepientEmailAddress;
    EditText subjectLine;
    EditText emailContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recepientEmailAddress = (EditText) findViewById(R.id.recepientemailaddress);
        subjectLine = (EditText) findViewById(R.id.subjectlineaddress);
        emailContent = (EditText) findViewById(R.id.contentedittext);
    }

    public void sendEmail(String receipientAddress, String subjectLine, String contentText){
        String[] tempArray = new String[]{receipientAddress};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,subjectLine);
        intent.putExtra(Intent.EXTRA_EMAIL,tempArray);
        intent.putExtra(Intent.EXTRA_TEXT,contentText);

        if(intent.resolveActivity(getPackageManager()) != null)
            startActivity(Intent.createChooser(intent,"Send email via..."));
        else
            Log.v("sendemailapp","no app to handle emails");
    }

    public void sendemailbuttonclicked(View view) {
        this.sendEmail(recepientEmailAddress.getText().toString(),subjectLine.getText().toString(),emailContent.getText().toString());
    }
}
