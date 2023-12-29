package com.swaraj.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button startbtn,aboutbtn;
    EditText editTextname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextname = (EditText)findViewById(R.id.enterName);
        editTextname.setOnEditorActionListener(editorListener);
        startbtn = (Button)findViewById(R.id.startBtn);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),QuestionsPage.class);

                String name = editTextname.getText().toString().trim();
                if (name.length()==0 || name.equals("") || name == null || name.isEmpty()){
                    Toast.makeText(getApplicationContext(),"First Enter Your Name to Start a Quiz",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            }
        });
        aboutbtn = (Button)findViewById(R.id.aboutBtn);
        aboutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),About.class);
                startActivity(intent);
            }
        });
    }
    private TextView.OnEditorActionListener editorListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            boolean handled = false;
            if (i==EditorInfo.IME_ACTION_DONE){
                Intent intent = new Intent(getApplicationContext(),QuestionsPage.class);
                String name = editTextname.getText().toString().trim();
                if (name.length()==0 || name.equals("") || name == null || name.isEmpty()){
                    Toast.makeText(getApplicationContext(),"First Enter Your Name to Start a Quiz",Toast.LENGTH_LONG).show();
                }
                else {
                    intent.putExtra("name",name);
                    startActivity(intent);
                }
            }
            return handled;
        }
    };
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }
}