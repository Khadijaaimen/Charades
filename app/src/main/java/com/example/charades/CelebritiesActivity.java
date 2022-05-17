package com.example.charades;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CelebritiesActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 60000;
    private Gyroscope gyroscope;
    TextView foreheadText, timerText, guessesText, secondTimerText;
    String name;
    CountDownTimer countDownTimer;
    int count = 5, index = 0;
    int correctCount = 0, incorrectCount = 0;
    int Max = 97, Min = 1;
    List<String> celebrities;
    Random random;
    long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    ArrayList<String> incorrectList = new ArrayList<>();
    ArrayList<String> correctList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrities);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gyroscope = new Gyroscope(this);
        random = new Random();

        Intent intent = getIntent();
        name = intent.getStringExtra("category");

        foreheadText = findViewById(R.id.forehead);
        timerText = findViewById(R.id.timer);
        guessesText = findViewById(R.id.guesses);
        secondTimerText = findViewById(R.id.secondTimer);

        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long l) {
                timerText.setText(String.valueOf(count));
                count--;
                if (count < 2) {
                    foreheadText.setText("Get Ready!");
                }
            }

            @Override
            public void onFinish() {
                displayData();
            }
        }.start();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long l) {
                mTimeLeftInMillis = l;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                secondTimerText.setVisibility(View.GONE);
                guessesText.setText("Finish!");
                Intent intent = new Intent(CelebritiesActivity.this, ScoreboardActivity.class);
                intent.putExtra("incorrectAns", incorrectCount);
                intent.putExtra("correctAns", correctCount);
                Bundle b = new Bundle();
                b.putSerializable("incorrectList", (Serializable) incorrectList);
                intent.putExtras(b);
                Bundle b2 = new Bundle();
                b2.putSerializable("correctList", (Serializable) correctList);
                intent.putExtras(b2);
                startActivity(intent);
            }
        }.start();
    }

    private void updateCountDownText() {
        int seconds = (int) mTimeLeftInMillis / 1000;
        secondTimerText.setText(String.valueOf(seconds));
    }


    public void displayData() {
        switch (name) {
            case "Celebrities":
                celebrities = new ArrayList<>();
                celebrities.add("Arnold Schwarzenegger");
                celebrities.add("Jim Carrey");
                celebrities.add("Emma Watson");
                celebrities.add("Robert Downey Jr.");
                celebrities.add("Daniel Radcliffe");
                celebrities.add("Chris Evans");
                celebrities.add("Leonardo DiCaprio");
                celebrities.add("Tom Cruise");
                celebrities.add("Brad Pitt");
                celebrities.add("Charles Chaplin");
                celebrities.add("Morgan Freeman");
                celebrities.add("Tom Hanks");
                celebrities.add("Hugh Jackman");
                celebrities.add("Matt Damon");
                celebrities.add("Sylvester Stallone");
                celebrities.add("Will Smith");
                celebrities.add("Clint Eastwood");
                celebrities.add("Cameron Diaz");
                celebrities.add("George Clooney");
                celebrities.add("Steven Spielberg");
                celebrities.add("Harrison Ford");
                celebrities.add("Robert De Niro");
                celebrities.add("Al Pacino");
                celebrities.add("Russell Crowe");
                celebrities.add("Liam Neeson");
                celebrities.add("Kate Winslet");
                celebrities.add("Mark Wahlberg");
                celebrities.add("Natalie Portman");
                celebrities.add("Pierce Brosnan");
                celebrities.add("Sean Connery");
                celebrities.add("Orlando Bloom");
                celebrities.add("Dwayne Johnson");
                celebrities.add("Jackie Chan");
                celebrities.add("Angelina Jolie");
                celebrities.add("Adam Sandler");
                celebrities.add("Scarlett Johansson");
                celebrities.add("Heath Ledger");
                celebrities.add("Anne Hathaway");
                celebrities.add("Jessica Alba");
                celebrities.add("Edward Norton");
                celebrities.add("Keira Knightley");
                celebrities.add("Bradley Cooper");
                celebrities.add("Will Ferrell");
                celebrities.add("Julia Roberts");
                celebrities.add("Nicolas Cage");
                celebrities.add("Daniel Craig");
                celebrities.add("Keanu Reeves");
                celebrities.add("Ian McKellen");
                celebrities.add("Halle Berry");
                celebrities.add("Bruce Willis");
                celebrities.add("Samuel L. Jackson");
                celebrities.add("Ben Stiller");
                celebrities.add("Tommy Lee Jones");
                celebrities.add("Antonio Banderas");
                celebrities.add("Denzel Washington");
                celebrities.add("Steve Carell");
                celebrities.add("Shia LaBeouf");
                celebrities.add("Megan Fox");
                celebrities.add("James Franco");
                celebrities.add("Mel Gibson");
                celebrities.add("Vin Diesel");
                celebrities.add("Tim Allen");
                celebrities.add("Robin Williams");
                celebrities.add("Kevin Spacey");
                celebrities.add("Jason Biggs");
                celebrities.add("Seann William Scott");
                celebrities.add("Jean-Claude Van Damme");
                celebrities.add("Zach Galifianakis");
                celebrities.add("Owen Wilson");
                celebrities.add("Christian Bale");
                celebrities.add("Peter Jackson");
                celebrities.add("Sandra Bullock");
                celebrities.add("Bruce Lee");
                celebrities.add("Drew Barrymore");
                celebrities.add("Macaulay Culkin");
                celebrities.add("Jack Nicholson");
                celebrities.add("Bill Murray");
                celebrities.add("Sigourney Weaver");
                celebrities.add("Jake Gyllenhaal");
                celebrities.add("Jason Statham");
                celebrities.add("Jet Li");
                celebrities.add("Kate Beckinsale");
                celebrities.add("Rowan Atkinson");
                celebrities.add("Marlon Brando");
                celebrities.add("John Travolta");
                celebrities.add("Channing Tatum");
                celebrities.add("Ben Affleck");
                celebrities.add("Shah Rukh Khan");
                celebrities.add("Jennifer Aniston");
                celebrities.add("Jennifer Aniston");
                celebrities.add("Chris Hemsworth");
                celebrities.add("James McAvoy");
                celebrities.add("James Cameron");
                celebrities.add("Amitabh Bachchan");
                celebrities.add("Brendan Fraser");
                celebrities.add("Rachel McAdams");
                celebrities.add("Tom Hiddleston");
                celebrities.add("Aamir Khan");

                Collections.shuffle(celebrities);

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(celebrities.get(0));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 5.0f) {
                            timerPause();
                            incorrectList.add(celebrities.get(index));
                            getWindow().getDecorView().setBackgroundColor(Color.RED);
                            guessesText.setText("Pass");
                            incorrectCount++;
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startTimer();
                                    secondTimerText.setVisibility(View.VISIBLE);
                                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                                    String i = (String) guessesText.getText();
                                    index = celebrities.indexOf(i);
                                    index++;
                                    if (index == 97) index = 0;
                                    guessesText.setText(celebrities.get(index));
                                }
                            }, 1500);
                        } else if (ry < -5.0f) {
                            timerPause();
                            correctList.add(celebrities.get(index));
                            getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                            guessesText.setText("Correct!");
                            correctCount++;
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startTimer();
                                    secondTimerText.setVisibility(View.VISIBLE);
                                    getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                                    String i = (String) guessesText.getText();
                                    index = celebrities.indexOf(i);
                                    index++;
                                    if (index == 97) index = 0;
                                    guessesText.setText(celebrities.get(index));
                                }
                            }, 1500);
                        }
//                        else{
//                            isChecked = false;
//                        }
//
//                        if(!isChecked){
//                            getWindow().getDecorView().setBackgroundColor(Color.WHITE);
//                        }
                    }
                });
        }

    }

    private void timerPause() {
        countDownTimer.cancel();
        secondTimerText.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        gyroscope.register();
    }

    @Override
    protected void onPause() {
        super.onPause();

        gyroscope.unRegister();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gyroscope.unRegister();
        finish();
        finishAffinity();
    }
}