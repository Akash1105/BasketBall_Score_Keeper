package com.example.basketball_score_keeper;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int scoreTeamA = 0; //Tracks score for team A
    int scoreTeamB = 0; //Tracks score for team B

    Button Three_pointer, Two_pointer, Free_throw, Three_Pointer_B, Two_Pointer_B, Free_Throw_B;
    TextView scoreView, scoreViewB,Timer_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Three_pointer = findViewById(R.id.Three_point);
        Two_pointer = findViewById(R.id.two_point);
        Free_throw = findViewById(R.id.free_throw);

        Three_pointer.setOnClickListener(this);
        Two_pointer.setOnClickListener(this);
        Free_throw.setOnClickListener(this);

        Three_Pointer_B = findViewById(R.id.Three_point_B);
        Two_Pointer_B = findViewById(R.id.two_point_B);
        Free_Throw_B = findViewById(R.id.free_throw_B);

        Three_Pointer_B.setOnClickListener(this);
        Two_Pointer_B.setOnClickListener(this);
        Free_Throw_B.setOnClickListener(this);


        Timer_tv = findViewById(R.id.textView2);

    }


    public void startTimer(View v)
    {
        CountDownTimer countDownTimer =new CountDownTimer(60 * 1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Timer_tv.setText("Countdown :" + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {

            Timer_tv.setText("0");
            }
        }.start();
    }

    public void resetScore(View v)      //Resets score for both teams
    {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        scoreViewB = findViewById(R.id.team_b_score);
        scoreViewB.setText(String.valueOf(score));

    }

    @Override
    public void onClick(View v) {

        if (v == Three_pointer) {
            scoreTeamA = scoreTeamA + 3;    //Increase Team A score by 3
            displayForTeamA(scoreTeamA);

        } else if (v == Two_pointer) {
            scoreTeamA = scoreTeamA + 2;    //Increase Team A score by 2
            displayForTeamA(scoreTeamA);

        } else if (v == Free_throw) {
            scoreTeamA = scoreTeamA + 1;    //Increase Team A score by 1
            displayForTeamA(scoreTeamA);
        } else if (v == Three_Pointer_B) {
            scoreTeamB = scoreTeamB + 3;   //Increase Team B score by 3
            displayForTeamB(scoreTeamB);

        } else if (v == Two_Pointer_B) {
            scoreTeamB = scoreTeamB + 2;   //Increase Team B score by 2
            displayForTeamB(scoreTeamB);

        } else {
            scoreTeamB = scoreTeamB + 1;   //Increase Team B score by 1
            displayForTeamB(scoreTeamB);
        }
    }
}
