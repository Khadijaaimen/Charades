package com.example.charades.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charades.R;
import com.example.charades.adapter.CorrectAnswersAdapter;
import com.example.charades.adapter.IncorrectAnswersAdapter;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity {

    Integer correct, incorrect;
    String name;
    ArrayList<String> correctList = new ArrayList<>();
    ArrayList<String> incorrectList = new ArrayList<>();
    RecyclerView recyclerView1, recyclerView2;
    TextView incorrectTotal, correctTotal, scoreText;
    CorrectAnswersAdapter correctAnswersAdapter;
    IncorrectAnswersAdapter incorrectAnswersAdapter;
    ImageView buttonRestart, buttonHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView1 = findViewById(R.id.correctAnsRv);
        recyclerView2 = findViewById(R.id.incorrectAnsRv);

        incorrectTotal = findViewById(R.id.totalCountIncorrect);
        correctTotal = findViewById(R.id.totalCountCorrect);
        scoreText = findViewById(R.id.score);

        Intent intent = getIntent();
        correct = intent.getIntExtra("correctAns", 0);
        incorrect = intent.getIntExtra("incorrectAns", 0);
        name = intent.getStringExtra("nameCategory");

        scoreText.setText(String.valueOf(correct));

        buttonRestart = findViewById(R.id.restartButton);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("category", name);
                startActivity(intent);
                correctList.clear();
                incorrectList.clear();
            }
        });

        buttonHome = findViewById(R.id.homeButton);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ScoreboardActivity.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        correctList.clear();
        incorrectList.clear();
    }

    @Override
    protected void onPause() {
        super.onPause();
        startActivity(new Intent(ScoreboardActivity.this, MainActivity.class));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        correctList.clear();
        incorrectList.clear();
        startActivity(new Intent(ScoreboardActivity.this, MainActivity.class));
    }
}