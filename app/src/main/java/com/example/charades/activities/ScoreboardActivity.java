package com.example.charades.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charades.R;
import com.example.charades.adapter.CorrectAnswersAdapter;
import com.example.charades.adapter.IncorrectAnswersAdapter;
import com.example.charades.helper.DatabaseHelper;
import com.example.charades.javaClass.AppPreferences;

import java.util.ArrayList;

public class ScoreboardActivity extends AppCompatActivity {

    Integer correct, incorrect, countWon, countLost, countDraw;
    String name;
    ArrayList<String> correctList = new ArrayList<>();
    ArrayList<String> incorrectList = new ArrayList<>();
    RecyclerView recyclerView1, recyclerView2;
    TextView incorrectTotal, correctTotal, scoreText;
    CorrectAnswersAdapter correctAnswersAdapter;
    IncorrectAnswersAdapter incorrectAnswersAdapter;
    ImageView buttonRestart, buttonHome;
    DatabaseHelper databaseHelper;
    Cursor wonCount, lostCount, drawCount;
    String won, lost, draw, play;

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

        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        correct = intent.getIntExtra("correctAns", 0);
        incorrect = intent.getIntExtra("incorrectAns", 0);
        name = intent.getStringExtra("nameCategory");

        scoreText.setText(String.valueOf(correct));

//        wonCount = databaseHelper.getWon();
//        drawCount = databaseHelper.getDraw();
//        lostCount = databaseHelper.getLost();

        lost = AppPreferences.islostButtonCLicked(this);
        won = AppPreferences.isWonButtonCLicked(this);
        draw = AppPreferences.isDrawButtonCLicked(this);
        play = AppPreferences.isPlayButtonCLicked(this);

//        if (lostCount.moveToFirst())
//            lost = lostCount.getInt(0);
//        else
//            lost = 0;
//
//        if (wonCount.moveToFirst())
//            won = wonCount.getInt(0);
//        else
//            won = 0;
//
//        if (drawCount.moveToFirst())
//            draw = drawCount.getInt(0);
//        else
//            draw = 0;

        countWon = Integer.parseInt(won);
        countDraw = Integer.parseInt(draw);
        countLost = Integer.parseInt(lost);

        if (correct > incorrect) {
            countWon++;
            won = countWon.toString();
            AppPreferences.setWonButtonCLicked(this, won);
//            if (wonCount.moveToFirst()) {
//                won = wonCount.getInt(0);
//                won++;
//                databaseHelper.saveGamesWon(won);
//            } else {
//                databaseHelper.saveGamesWon(1);
//                won = 1;
//            }
        } else if (correct.equals(incorrect)) {
            countDraw++;
            draw = countDraw.toString();
            AppPreferences.seDrawButtonCLicked(this, draw);
//            if (drawCount.moveToFirst()) {
//                draw = drawCount.getInt(0);
//                draw++;
//                databaseHelper.saveGamesDrawn(draw);
//            } else {
//                databaseHelper.saveGamesDrawn(1);
//                draw = 1;
//            }
        } else {
            countLost++;
            lost = countLost.toString();
            AppPreferences.setLostButtonCLicked(this, lost);
//            if (lostCount.moveToFirst()) {
//                lost = lostCount.getInt(0);
//                lost++;
//                databaseHelper.saveGamesLost(lost);
//            } else {
//                databaseHelper.saveGamesLost(1);
//                lost = 1;
//            }
        }

        int total = countLost + countWon + countDraw;
        String s = String.valueOf(total);
        AppPreferences.setPlayButtonCLicked(this, s);
//        databaseHelper.saveGamesPlayed(total);

        buttonRestart = findViewById(R.id.restartButton);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctList.clear();
                incorrectList.clear();
                Intent intent = new Intent(ScoreboardActivity.this, GameActivity.class);
                intent.putExtra("category", name);
                startActivity(intent);
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        correctList.clear();
        incorrectList.clear();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        correctList.clear();
        incorrectList.clear();
        startActivity(new Intent(ScoreboardActivity.this, MainActivity.class));
    }
}