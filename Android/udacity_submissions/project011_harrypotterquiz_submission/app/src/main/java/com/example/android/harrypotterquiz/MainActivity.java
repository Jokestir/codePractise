package com.example.android.harrypotterquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    String[] answerKey = new String[]{"DiademNagini", "8", "Snape", "Mrs Norris", "Stag"};
    int numberOfQuestionsCorrect;
    Boolean[] questionsWrong = new Boolean[5];

    CheckBox question1option1;
    CheckBox question1option2;
    CheckBox question1option3;

    EditText question2EditText;
    RadioGroup question3RadioGrp;
    RadioGroup question4RadioGrp;
    RadioGroup question5RadioGrp;

    TextView resultsummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        question1option1 = findViewById(R.id.ques1_option1);
        question1option2 = findViewById(R.id.ques1_option2);
        question1option3 = findViewById(R.id.ques1_option3);

        question2EditText = findViewById(R.id.horcrux_qty_editext);
        question3RadioGrp = findViewById(R.id.dumblee_killer_options_radiogroup);
        question4RadioGrp = findViewById(R.id.argus_finchcat_options_radiogroup);
        question5RadioGrp = findViewById(R.id.harry_patronushape_radiogroup);
        resultsummary = findViewById(R.id.resultsummary);
    }

    public int calculateScore() {
        int score = 0;

        RadioButton r3 = findViewById(question3RadioGrp.getCheckedRadioButtonId());
        RadioButton r4 = findViewById(question4RadioGrp.getCheckedRadioButtonId());
        RadioButton r5 = findViewById(question5RadioGrp.getCheckedRadioButtonId());

        if (question1option1.isChecked() && question1option2.isChecked() && !question1option3.isChecked()) {
            score += 1;
            this.questionsWrong[0] = true;
        } else {
            this.questionsWrong[0] = false;
        }


        if (question2EditText.getText() != null) {
            if (question2EditText.getText().toString().trim().equals("8")) {
                score += 1;
                this.questionsWrong[1] = true;
            }
        } else {
            this.questionsWrong[1] = false;
        }

        if (r3 != null) {
            if (r3.getText().equals(answerKey[2])) {
                score += 1;
                this.questionsWrong[2] = true;
            }
        } else {
            this.questionsWrong[2] = false;
        }

        if (r4 != null) {
            if (r4.getText().equals(answerKey[3])) {
                score += 1;
                this.questionsWrong[3] = true;
            }
        } else {
            this.questionsWrong[3] = false;
        }

        if (r5 != null) {
            if (r5.getText().equals(answerKey[4])) {
                score += 1;
                this.questionsWrong[4] = true;
            }
        } else {
            this.questionsWrong[4] = false;
        }
        this.numberOfQuestionsCorrect = score;
        return score;
    }

    public void grade(View view) {
        int numberOfQuestionsCorrect = calculateScore();

        String wrongQuestionIndex = "";

        for (int i = 0; i < 5; i++) {
            if (questionsWrong[i] != null) {
                if (questionsWrong[i].booleanValue() == false)
                    wrongQuestionIndex += Integer.toString(++i) + ",";
            }
        }

        if (wrongQuestionIndex != null && !wrongQuestionIndex.isEmpty())
            wrongQuestionIndex = wrongQuestionIndex.substring(0, wrongQuestionIndex.length() - 1);

        String result = numberOfQuestionsCorrect + " out of 5 answers correct\n" + "Question number for wrong answers: " + wrongQuestionIndex;
        resultsummary.setVisibility(View.VISIBLE);
        resultsummary.setText(result);

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();

    }
}
