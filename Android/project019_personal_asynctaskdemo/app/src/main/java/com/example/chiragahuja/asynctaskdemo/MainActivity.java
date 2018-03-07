package com.example.chiragahuja.asynctaskdemo;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import com.example.chiragahuja.asynctaskdemo.MyAsyncTask;

public class MainActivity extends Activity {


    public static String TAG = "Beethoven";

    MyAsyncTask task;

    Button startAsyncTaskButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       startAsyncTaskButton = (Button) findViewById(R.id.startAsyncTask);

        View.OnClickListener asyncTaskStartButtonListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.e(TAG, "Inside onClick");
                task = new MyAsyncTask(MainActivity.this);
                task.execute();

            }


        };


        startAsyncTaskButton.setOnClickListener(asyncTaskStartButtonListener);



    }
}