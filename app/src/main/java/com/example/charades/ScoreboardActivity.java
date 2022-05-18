package com.example.charades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity {

    Integer correct, incorrect;
    String name;
    ArrayList<String> correctList = new ArrayList<>();
    ArrayList<String> incorrectList = new ArrayList<>();
    RecyclerView recyclerView1, recyclerView2;
    TextView incorrectTotal, correctTotal;
    CorrectAnswersAdapter correctAnswersAdapter;
    IncorrectAnswersAdapter incorrectAnswersAdapter;
    ImageView buttonRestart;

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
        correct = intent.getIntExtra("incorrectAns", 0);
        incorrect = intent.getIntExtra("correctAns", 0);
        name = intent.getStringExtra("nameCategory");

        buttonRestart = findViewById(R.id.restartButton);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CelebritiesActivity.class);
                intent.putExtra("category", name);
                startActivity(intent);
            }
        });

        Bundle b = getIntent().getExtras();
        correctList = (ArrayList<String>) b.getSerializable("correctList");
        incorrectList = (ArrayList<String>) b.getSerializable("incorrectList");

        recyclerView1.setLayoutManager(new LinearLayoutManager(ScoreboardActivity.this));
        correctAnswersAdapter = new CorrectAnswersAdapter(correctList, this);
        recyclerView1.setAdapter(correctAnswersAdapter);

        recyclerView2.setLayoutManager(new LinearLayoutManager(ScoreboardActivity.this));
        incorrectAnswersAdapter = new IncorrectAnswersAdapter(incorrectList, this);
        recyclerView2.setAdapter(incorrectAnswersAdapter);

        correctTotal.setText(String.valueOf(correct));
        incorrectTotal.setText(String.valueOf(incorrect));
    }
}