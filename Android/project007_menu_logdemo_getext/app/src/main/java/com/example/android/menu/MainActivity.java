package com.example.android.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView txtview1 = (TextView) findViewById(R.id.menu_item_1);
        TextView txtview2 = (TextView) findViewById(R.id.menu_item_2);
        TextView txtview3 = (TextView) findViewById(R.id.menu_item_3);

        Log.e("CHIRAG",txtview1.getText().toString());
        // Find second menu item TextView and print the text to the logs
        Log.e("CHIRAG",txtview2.getText().toString());
    // Find third menu item TextView and print the text to the logs
        Log.e("CHIRAG",txtview3.getText().toString());
    }
}
