package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int scoreTeamA;
    private int scoreTeamB;
    /**
     * Displays the given score for Team A.
     */

    public void plusThreeA(View view){
        this.scoreTeamA = this.scoreTeamA + 3;
        this.displayForTeamA(this.scoreTeamA);
    }

    public void plusTwoA(View view){
        this.scoreTeamA = this.scoreTeamA + 2;
        this.displayForTeamA(this.scoreTeamA);
    }

    public void plusOneA(View view){
        this.scoreTeamA = this.scoreTeamA + 1;
        this.displayForTeamA(this.scoreTeamA);
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamApoints);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB (int score) {
        TextView scoreView = (TextView) findViewById(R.id.teamBpoints);
        scoreView.setText(String.valueOf(score));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void plusThreeB(View view) {
        this.scoreTeamB = this.scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void plusTwoB(View view) {
        this.scoreTeamB = this.scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void plusOneB(View view) {
        this.scoreTeamB = this.scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void resetPoints(View view) {
        this.scoreTeamB = 0;
        this.scoreTeamA = 0;
        displayForTeamB(this.scoreTeamB);
        displayForTeamA(this.scoreTeamA);
    }
}
