package com.example.charades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity {

    String correct, incorrect;
    Integer correctNum, incorrectNum;
    ArrayList<String> correctList = new ArrayList<>();
    ArrayList<String> incorrectList = new ArrayList<>();
    RecyclerView recyclerView1, recyclerView2;
    TextView incorrectTotal, correctTotal;
    CorrectAnswersAdapter correctAnswersAdapter;
    IncorrectAnswersAdapter incorrectAnswersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView1 = findViewById(R.id.correctAnsRv);
        recyclerView2 = findViewById(R.id.incorrectAnsRv);

        incorrectTotal = findViewById(R.id.totalCountIncorrect);
        correctTotal = findViewById(R.id.totalCountCorrect);

        Intent intent = getIntent();
        correct = intent.getStringExtra("incorrectAns");
        incorrect = intent.getStringExtra("correctAns");

        correctNum = Integer.parseInt(correct);
        incorrectNum = Integer.parseInt(incorrect);

        Bundle b = getIntent().getExtras();
        correctList = (ArrayList<String>) b.getSerializable("correctList");
        incorrectList = (ArrayList<String>) b.getSerializable("incorrectList");

        recyclerView1.setLayoutManager(new LinearLayoutManager(ScoreboardActivity.this));
        correctAnswersAdapter = new CorrectAnswersAdapter(correctList, this);
        recyclerView1.setAdapter(correctAnswersAdapter);

        recyclerView2.setLayoutManager(new LinearLayoutManager(ScoreboardActivity.this));
        incorrectAnswersAdapter = new IncorrectAnswersAdapter(incorrectList, this);
        recyclerView2.setAdapter(incorrectAnswersAdapter);

        correctTotal.setText(correct);
        incorrectTotal.setText(incorrect);



    }
}