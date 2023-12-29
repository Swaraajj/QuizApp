package com.swaraj.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class QuestionsPage extends AppCompatActivity {

    Button fragbtn,quitbtn;
    TextView enteredname,questiontext,score;
    String[] question = {"Which method can be defined only once in a program?",
            "Which keyword is used by method to refer to the current object that invoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package‘pkg’?",
            "What is the return type of Constructors?"};
    private ItemViewModel viewModel;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions_page);
        score = (TextView)findViewById(R.id.score);
        enteredname = (TextView)findViewById(R.id.enteredName);
        questiontext = (TextView)findViewById(R.id.question);
        questiontext.setText(question[0]);
        Intent intent = getIntent();
        String strname = intent.getStringExtra("name");
        String name = "Hello " + strname;
        enteredname.setText(name);
        final int[] i = {0};
        //calling first fragment
        loadFragment(new Question1());
        AtomicInteger a = new AtomicInteger();
        viewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        viewModel.getSelectedItem().observe(this, item ->{
            a.set(item);
        });
        final int[] flag = {0};
        score.setText(""+flag[0]);
        //Creating nextques button
        fragbtn = (Button)findViewById(R.id.nextques);
        fragbtn.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
                if (i[0] == 0) {
                    //changing fragment
                    loadFragment(new Question2());
                    //changing question
                    questiontext.setText(question[1]);
                    //correct and wrong toast
                    if (a.get()==1){
                        Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                        flag[0]++;
                        score.setText(""+flag[0]);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                    }
                }
                if (i[0] == 1) {
                    loadFragment(new Question3());
                    questiontext.setText(question[2]);
                    if (a.get()==1){
                        Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                        flag[0]++;
                        score.setText(""+flag[0]);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                    }
                }
                if (i[0] == 2) {
                    loadFragment(new Question4());
                    questiontext.setText(question[3]);
                    if (a.get()==1){
                        Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                        flag[0]++;
                        score.setText(""+flag[0]);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                    }
                }
                if (i[0] == 3) {
                    loadFragment(new Question5());
                    questiontext.setText(question[4]);
                    if (a.get()==1){
                        Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                        flag[0]++;
                        score.setText(""+flag[0]);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                    }
                }
                if (i[0] == 4){
                    if (a.get()==1){
                        Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                        flag[0]++;
                        score.setText(""+flag[0]);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                    }
                    Intent intent1 = new Intent(getApplicationContext(),Results.class);
                    intent1.putExtra("score",flag[0]);
                    startActivity(intent1);
                }
                i[0]++;
            }
        });
        //Creating quit button
        quitbtn = (Button)findViewById(R.id.quit);
        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Results.class);
                intent1.putExtra("score",flag[0]);
                startActivity(intent1);
            }
        });
    }
    //fragmenttransaction function
    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_section,fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}