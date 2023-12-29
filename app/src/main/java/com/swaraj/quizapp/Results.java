package com.swaraj.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.util.IndianCalendar;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView corra,wrona,fins;
    Button restartbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        corra = (TextView)findViewById(R.id.correctAnswers);
        wrona = (TextView)findViewById(R.id.wrongAnswers);
        fins = (TextView)findViewById(R.id.finalScore);
        Intent intent = getIntent();
        int corr = intent.getIntExtra("score",0);
        int wron = 5-corr;
        String c = "Correct Answers: " + corr;
        String w = "Wrong Answers: " + wron;
        String f = "Final Score: " + corr;
        corra.setText(c);
        wrona.setText(w);
        fins.setText(f);

        restartbtn = (Button)findViewById(R.id.restartButton);
        restartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}