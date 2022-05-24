package com.example.charades;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CelebritiesActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 60000;
    private Gyroscope gyroscope;
    TextView foreheadText, timerText, guessesText, secondTimerText;
    String name, textCorrect = "", textIncorrect = "", backgroundColor = "purple";
    CountDownTimer countDownTimer;
    int count = 5;
    int correctCount = 0, incorrectCount = 0;
    List<String> namesList;
    int Min = 1, Max;
    Random random;
    long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    ArrayList<String> incorrectList = new ArrayList<>();
    ArrayList<String> correctList = new ArrayList<>();
    TextView warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrities);

        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gyroscope = new Gyroscope(this);
        random = new Random();

        Intent intent = getIntent();
        name = intent.getStringExtra("category");

        foreheadText = findViewById(R.id.forehead);
        timerText = findViewById(R.id.timer);
        guessesText = findViewById(R.id.guesses);
        secondTimerText = findViewById(R.id.secondTimer);
        warning = findViewById(R.id.verticalWarning);

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
                intent.putExtra("nameCategory", name);
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
            case "Hollywood Celebrities":
                namesList = new ArrayList<>();
                namesList.add("Arnold Schwarzenegger");
                namesList.add("Jim Carrey");
                namesList.add("Emma Watson");
                namesList.add("Robert Downey Jr.");
                namesList.add("Daniel Radcliffe");
                namesList.add("Chris Evans");
                namesList.add("Leonardo DiCaprio");
                namesList.add("Tom Cruise");
                namesList.add("Brad Pitt");
                namesList.add("Charles Chaplin");
                namesList.add("Morgan Freeman");
                namesList.add("Tom Hanks");
                namesList.add("Hugh Jackman");
                namesList.add("Matt Damon");
                namesList.add("Sylvester Stallone");
                namesList.add("Will Smith");
                namesList.add("Clint Eastwood");
                namesList.add("Cameron Diaz");
                namesList.add("George Clooney");
                namesList.add("Steven Spielberg");
                namesList.add("Harrison Ford");
                namesList.add("Robert De Niro");
                namesList.add("Al Pacino");
                namesList.add("Russell Crowe");
                namesList.add("Liam Neeson");
                namesList.add("Kate Winslet");
                namesList.add("Mark Wahlberg");
                namesList.add("Natalie Portman");
                namesList.add("Pierce Brosnan");
                namesList.add("Sean Connery");
                namesList.add("Orlando Bloom");
                namesList.add("Dwayne Johnson");
                namesList.add("Jackie Chan");
                namesList.add("Angelina Jolie");
                namesList.add("Adam Sandler");
                namesList.add("Scarlett Johansson");
                namesList.add("Heath Ledger");
                namesList.add("Anne Hathaway");
                namesList.add("Jessica Alba");
                namesList.add("Edward Norton");
                namesList.add("Keira Knightley");
                namesList.add("Bradley Cooper");
                namesList.add("Will Ferrell");
                namesList.add("Julia Roberts");
                namesList.add("Nicolas Cage");
                namesList.add("Daniel Craig");
                namesList.add("Keanu Reeves");
                namesList.add("Ian McKellen");
                namesList.add("Halle Berry");
                namesList.add("Bruce Willis");
                namesList.add("Samuel L. Jackson");
                namesList.add("Ben Stiller");
                namesList.add("Micheal Jackson");
                namesList.add("Tommy Lee Jones");
                namesList.add("Antonio Banderas");
                namesList.add("Denzel Washington");
                namesList.add("Steve Carell");
                namesList.add("Shia LaBeouf");
                namesList.add("Megan Fox");
                namesList.add("James Franco");
                namesList.add("Mel Gibson");
                namesList.add("Vin Diesel");
                namesList.add("Tim Allen");
                namesList.add("Robin Williams");
                namesList.add("Kevin Spacey");
                namesList.add("Jason Biggs");
                namesList.add("Seann William Scott");
                namesList.add("Jean-Claude Van Damme");
                namesList.add("Zach Galifianakis");
                namesList.add("Owen Wilson");
                namesList.add("Christian Bale");
                namesList.add("Peter Jackson");
                namesList.add("Sandra Bullock");
                namesList.add("Bruce Lee");
                namesList.add("Drew Barrymore");
                namesList.add("Macaulay Culkin");
                namesList.add("Jack Nicholson");
                namesList.add("Bill Murray");
                namesList.add("Sigourney Weaver");
                namesList.add("Jake Gyllenhaal");
                namesList.add("Jason Statham");
                namesList.add("Jet Li");
                namesList.add("Kate Beckinsale");
                namesList.add("Rowan Atkinson");
                namesList.add("Marlon Brando");
                namesList.add("John Travolta");
                namesList.add("Channing Tatum");
                namesList.add("Ben Affleck");
                namesList.add("Shah Rukh Khan");
                namesList.add("Jennifer Aniston");
                namesList.add("Jennifer Aniston");
                namesList.add("Chris Hemsworth");
                namesList.add("James McAvoy");
                namesList.add("James Cameron");
                namesList.add("Amitabh Bachchan");
                namesList.add("Brendan Fraser");
                namesList.add("Rachel McAdams");
                namesList.add("Tom Hiddleston");
                namesList.add("Aamir Khan");

                Max = namesList.size();
                int rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });
                break;
            case "Science":
                namesList = new ArrayList<>();

                namesList.add("Abdomen");
                namesList.add("Absorb");
                namesList.add("Acid rain");
                namesList.add("Adapt");
                namesList.add("Air pressure");
                namesList.add("Amphibian");
                namesList.add("Angle");
                namesList.add("Antenna");
                namesList.add("Astronomer");
                namesList.add("Atmosphere");
                namesList.add("Atom");
                namesList.add("Balance");
                namesList.add("Barometer");
                namesList.add("Biologist");
                namesList.add("Boiling point");
                namesList.add("Botanist");
                namesList.add("Camouflage");
                namesList.add("Calorie");
                namesList.add("Carnivore");
                namesList.add("Cell");
                namesList.add("Charge");
                namesList.add("Chemist");
                namesList.add("Chew");
                namesList.add("Chromosome");
                namesList.add("Circuit");
                namesList.add("Cleavage");
                namesList.add("Climate");
                namesList.add("Clockwise");
                namesList.add("Cloud");
                namesList.add("Cold front");
                namesList.add("Comet");
                namesList.add("Compass");
                namesList.add("Compound");
                namesList.add("Compression");
                namesList.add("Condensation");
                namesList.add("Condensation");
                namesList.add("Conductor");
                namesList.add("Constellation");
                namesList.add("Consumer");
                namesList.add("Contract");
                namesList.add("Crater");
                namesList.add("Current");
                namesList.add("Cumulus");
                namesList.add("Cumuli-nimbus");
                namesList.add("Decay");
                namesList.add("Decomposer");
                namesList.add("Degree");
                namesList.add("Desert");
                namesList.add("Digestion");
                namesList.add("Digestive system");
                namesList.add("Dissolve");
                namesList.add("DNA");
                namesList.add("Eardrum");
                namesList.add("Earthquake");
                namesList.add("Eclipse");
                namesList.add("Electricity");
                namesList.add("Elevation");
                namesList.add("Endoskeleton");
                namesList.add("Energy");
                namesList.add("Engineer");
                namesList.add("Environment");
                namesList.add("Equator");
                namesList.add("Erode");
                namesList.add("Estimate");
                namesList.add("Evaporation");
                namesList.add("Exoskeleton");
                namesList.add("Expand");
                namesList.add("Extinct");
                namesList.add("Fiber");
                namesList.add("Flight");
                namesList.add("Float");
                namesList.add("Flower");
                namesList.add("Force");
                namesList.add("Forest");
                namesList.add("Fossil");
                namesList.add("Freeze");
                namesList.add("Friction");
                namesList.add("Fungus");
                namesList.add("Galaxy");
                namesList.add("Gas");
                namesList.add("Geologist");
                namesList.add("Global warming");
                namesList.add("Gills");
                namesList.add("Germinate");
                namesList.add("Grassland");
                namesList.add("Greenhouse effect");
                namesList.add("Habitat");
                namesList.add("Heat");
                namesList.add("Herbivore");
                namesList.add("Humidity");
                namesList.add("Humus");
                namesList.add("Hurricane");
                namesList.add("Ice");
                namesList.add("Igneous rock");
                namesList.add("Insect");
                namesList.add("Joint");
                namesList.add("Kidney");
                namesList.add("Leaf");
                namesList.add("Lever");
                namesList.add("Lift");
                namesList.add("Light");
                namesList.add("Lightning");
                namesList.add("Liquid");
                namesList.add("Magnet");
                namesList.add("Mammal");
                namesList.add("Map");
                namesList.add("Mass");
                namesList.add("Matter");
                namesList.add("Measure");
                namesList.add("Melt");
                namesList.add("Metamorphic rock");
                namesList.add("Metamorphosis");
                namesList.add("Meteor");
                namesList.add("Meter");
                namesList.add("Migrate");
                namesList.add("Mineral");
                namesList.add("Mixture");
                namesList.add("Molecule");
                namesList.add("Moon");
                namesList.add("Motion");
                namesList.add("Muscle");
                namesList.add("Mutualism");
                namesList.add("Ocean");
                namesList.add("Omnivore");
                namesList.add("Orbit");
                namesList.add("Organ");
                namesList.add("Organism");
                namesList.add("Ornithologist");
                namesList.add("Oxygen");
                namesList.add("Parallel circuit");
                namesList.add("Parasite");
                namesList.add("Pendulum");
                namesList.add("Photosynthesis");
                namesList.add("Physicist");
                namesList.add("Planet");
                namesList.add("Plateau");
                namesList.add("Poison");
                namesList.add("Pole");
                namesList.add("Pollution");
                namesList.add("Population");
                namesList.add("Porous");
                namesList.add("Prairie");
                namesList.add("Precipitation");
                namesList.add("Predator");
                namesList.add("Prey");
                namesList.add("Producer");
                namesList.add("Protein");
                namesList.add("Pull");
                namesList.add("Quantity");
                namesList.add("Quartz");
                namesList.add("Radiation");
                namesList.add("Recycle");
                namesList.add("Repel");
                namesList.add("Reptile");
                namesList.add("Resistance");
                namesList.add("Revolve");
                namesList.add("River");
                namesList.add("Rocket");
                namesList.add("Root");
                namesList.add("Rotation");
                namesList.add("Saliva");
                namesList.add("Screw");
                namesList.add("Scale");
                namesList.add("Season");
                namesList.add("Sedimentary rock");
                namesList.add("Seed");
                namesList.add("Series circuit");
                namesList.add("Shadow");
                namesList.add("Skin");
                namesList.add("Soil");
                namesList.add("Solid");
                namesList.add("Solution");
                namesList.add("Sound wave");
                namesList.add("Space");
                namesList.add("Spine");
                namesList.add("Star");
                namesList.add("Static");
                namesList.add("Stem");
                namesList.add("Stomach");
                namesList.add("Sugar");
                namesList.add("Sunset");
                namesList.add("Taste buds");
                namesList.add("Teeth");
                namesList.add("Telescope");
                namesList.add("Temperature");
                namesList.add("Thermometer");
                namesList.add("Thunder");
                namesList.add("Tornado");
                namesList.add("Velocity");
                namesList.add("Vibrate");
                namesList.add("Volume");
                namesList.add("Warm front");
                namesList.add("Waning");
                namesList.add("Water table");
                namesList.add("Waxing");
                namesList.add("Weather");
                namesList.add("Wheel & axl");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });
                break;
            case "Hollywood Movies":
                namesList = new ArrayList<>();

                namesList.add("Vertigo");
                namesList.add("Mad Max: Fury Road");
                namesList.add("Jaws");
                namesList.add("Texas Chainsaw Massacre");
                namesList.add("Kill Bill");
                namesList.add("Mission Impossible");
                namesList.add("Ocean’s 11");
                namesList.add("Top Gun");
                namesList.add("Transcendence");
                namesList.add("Gladiator");
                namesList.add("300");
                namesList.add("Jurassic Park");
                namesList.add("The Lord of the Rings");
                namesList.add("Titanic");
                namesList.add("Gremlins");
                namesList.add("12 Angry Men");
                namesList.add("The Shawshank Redemption");
                namesList.add("Shrek");
                namesList.add("The Godfather");
                namesList.add("The Devil Wears Prada");
                namesList.add("Ghostbusters");
                namesList.add("Saw");
                namesList.add("Skyfall");
                namesList.add("Anna Karenina");
                namesList.add("Zero Dark Thirty");
                namesList.add("Amelie");
                namesList.add("Bridget Jones' Diary");
                namesList.add("The Dark Knight");
                namesList.add("Fight Club");
                namesList.add("Goodfellas");
                namesList.add("Fried Green Tomatoes");
                namesList.add("Pulp Fiction");
                namesList.add("Toy Story 3");
                namesList.add("Lincoln");
                namesList.add("The Matrix");
                namesList.add("Alien");
                namesList.add("Snow White and the Huntsman");
                namesList.add("Home Alone");
                namesList.add("The Lion, the Witch and the Wardrobe");
                namesList.add("Black Beauty");
                namesList.add("Black Swan");
                namesList.add("The Departed");
                namesList.add("Click");
                namesList.add("Inception");
                namesList.add("The Lion King");
                namesList.add("Twilight");
                namesList.add("Argo");
                namesList.add("Aladdin");
                namesList.add("Clueless");
                namesList.add("Django Unchained");
                namesList.add("Kung-Fu Panda");
                namesList.add("X-Men");
                namesList.add("Life of Pi");
                namesList.add("Jaws");
                namesList.add("To Kill A Mockingbird");
                namesList.add("Psycho");
                namesList.add("The Birds");
                namesList.add("On the Waterfront");
                namesList.add("Iron Man");
                namesList.add("Braveheart");
                namesList.add("Lord of the Rings: Return of the King");
                namesList.add("The Little Mermaid");
                namesList.add("Mrs. Doubtfire");
                namesList.add("Beaches");
                namesList.add("The Wizard of Oz");
                namesList.add("Forrest Gump");
                namesList.add("Silver Linings Playbook");
                namesList.add("Hairspray");
                namesList.add("The Lion King");
                namesList.add("Mean Girls");
                namesList.add("Around the World in 80 days");
                namesList.add("Divergent");
                namesList.add("American Beauty");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });

                break;
            case "Activities":
                namesList = new ArrayList<>();
                namesList.add("Dancing a ballet");
                namesList.add("Shopping at the mall");
                namesList.add("Going bowling");
                namesList.add("Building a campfire");
                namesList.add("Filming a movie");
                namesList.add("Finger painting");
                namesList.add("Ironing a shirt");
                namesList.add("Having a food fight");
                namesList.add("Riding a motorcycle");
                namesList.add("Playing hopscotch");
                namesList.add("Watering a garden");
                namesList.add("Feeding the ducks ");
                namesList.add("Milking a cow");
                namesList.add("Rock climbing");
                namesList.add("Flying a kite");
                namesList.add("Playing four square");
                namesList.add("Playing chess");
                namesList.add("Sewing a button");
                namesList.add("Making a pizza");
                namesList.add("Washing clothes");
                namesList.add("Washing dishes");
                namesList.add("Playing soccer");
                namesList.add("Scuba diving");
                namesList.add("Sewing a dress");
                namesList.add("Riding a carousel");
                namesList.add("Visiting the zoo");
                namesList.add("Baking bread");
                namesList.add("Paddling in the canoe");
                namesList.add("Flipping pancakes");
                namesList.add("Hailing a taxi");
                namesList.add("Mowing lawn");
                namesList.add("Building a sandcastle");
                namesList.add("Setting up a tent");
                namesList.add("Delivering mail");
                namesList.add("Sorting laundry");
                namesList.add("Landing an airplane");
                namesList.add("Raking leaves");
                namesList.add("Playing baseball");
                namesList.add("Cooking");
                namesList.add("Fixing a clogged sink");
                namesList.add("Sailing");
                namesList.add("Swimming");
                namesList.add("Flossing");
                namesList.add("Applying makeup");
                namesList.add("Getting dressed/undressed");
                namesList.add("Applying lotion");
                namesList.add("Washing hair");
                namesList.add("Buckling a belt");
                namesList.add("Buttoning a shirt");
                namesList.add("Feeding a baby a bottle");
                namesList.add("Burping a baby");
                namesList.add("Changing a diaper");
                namesList.add("Cutting food with a knife");
                namesList.add("Opening a can");
                namesList.add("Mopping floors");
                namesList.add("Dusting furniture");
                namesList.add("Icing a cake");
                namesList.add("Listening to music");
                namesList.add("Singing");
                namesList.add("Typing");
                namesList.add("Writing");
                namesList.add("Coughing");
                namesList.add("Opening a letter");
                namesList.add("Checking the mail");
                namesList.add("Scratching");
                namesList.add("Shoveling snow");
                namesList.add("Watering plants");
                namesList.add("Lighting candles");
                namesList.add("Blowing out candles");
                namesList.add("Sharpening a pencil");
                namesList.add("Spray painting");
                namesList.add("Watching television");
                namesList.add("Opening a present");
                namesList.add("Making the bed");
                namesList.add("Making tea");
                namesList.add("Vacuuming floors");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });
                break;
            case "English Songs":
                namesList = new ArrayList<>();

                namesList.add("Baby");
                namesList.add("Love You Like a Love");
                namesList.add("Teardrops on My Guitar");
                namesList.add("Waiting Outside The Lines");
                namesList.add("Chasing the Sun");
                namesList.add("Stronger");
                namesList.add("Whip My Hair");
                namesList.add("Firework");
                namesList.add("Unbroken");
                namesList.add("See You Again");
                namesList.add("Sorry");
                namesList.add("Uptown Funk");
                namesList.add("Blank Space");
                namesList.add("Shake It Of");
                namesList.add("Lean On");
                namesList.add("Hello");
                namesList.add("Roar");
                namesList.add("Sugar");
                namesList.add("All About That Bass");
                namesList.add("Dark Horse");
                namesList.add("Counting Stars");
                namesList.add("Chandelier");
                namesList.add("What Do You Mean?");
                namesList.add("Thinking Out Loud");
                namesList.add("Work From Home");
                namesList.add("This Is What You Came For");
                namesList.add("Let Her Go");
                namesList.add("Waka Waka");
                namesList.add("Worth It");
                namesList.add("Love The Way You Lie");
                namesList.add("Closer");
                namesList.add("Party Rock Anthem”");
                namesList.add("Wake Me Up");
                namesList.add("Watch Me");
                namesList.add("Rude");
                namesList.add("Hotline Bling");
                namesList.add("Love Yourself");
                namesList.add("Summer");
                namesList.add("Burn");
                namesList.add("Rolling in the Deep");
                namesList.add("The Lazy Song");
                namesList.add("All of Me");
                namesList.add("On The Floor");
                namesList.add("Thrift Shop");
                namesList.add("Bad Blood");
                namesList.add("The Hills");
                namesList.add("Hey Mama");
                namesList.add("How Deep Is Your Love");
                namesList.add("Faded");
                namesList.add("Problem");
                namesList.add("Diamonds");
                namesList.add("Animals");
                namesList.add("Call Me Maybe");
                namesList.add("Happy");
                namesList.add("Timber");
                namesList.add("Not Afraid");
                namesList.add("Last Friday Night");
                namesList.add("Stressed Out");
                namesList.add("Firework");
                namesList.add("Wrecking Ball");
                namesList.add("Just The Way You Are");
                namesList.add("Somebody That I Used To Know");
                namesList.add("Where Are U Now");
                namesList.add("Bang Bang");
                namesList.add("Work");
                namesList.add("What Makes You Beautiful");
                namesList.add("Someone Like You");
                namesList.add("Side to Side");
                namesList.add("I’m Not The Only One");
                namesList.add("Break Free");
                namesList.add("La La La");
                namesList.add("Bad Romance");
                namesList.add("Fancy");
                namesList.add("I Took a Pill In Ibiza");
                namesList.add("Cheap Thrills");
                namesList.add("Elastic Heart");
                namesList.add("Can’t Remember to Forget You");
                namesList.add("We Don’t Talk Anymore");
                namesList.add("Rain Over Me");
                namesList.add("Wiggle");
                namesList.add("Treat You Better");
                namesList.add("Can’t Feel My Face");
                namesList.add("November Rain");
                namesList.add("We Can’t Stop");
                namesList.add("Stitches");
                namesList.add("Play Hard");
                namesList.add("Starboy");
                namesList.add("Beauty and a Beat");
                namesList.add("I’m an Albatraoz");
                namesList.add("Stay With Me");
                namesList.add("Cheerleader");
                namesList.add("Pillowtalk");
                namesList.add("Cold Water");
                namesList.add("Hymn For The Weekend");
                namesList.add("You Belong With Me");
                namesList.add("We Found Love");
                namesList.add("Paradise");
                namesList.add("Heathens");
                namesList.add("Focus");
                namesList.add("23");
                namesList.add("Anaconda");
                namesList.add("Titanium");
                namesList.add("The Fox");
                namesList.add("Just Give Me A Reason");
                namesList.add("Super Bass");
                namesList.add("Never Say Never");
                namesList.add("Turn Down For What");
                namesList.add("Bad");
                namesList.add("Royals");
                namesList.add("Radioactive");
                namesList.add("Don’t Let Me Down");
                namesList.add("I Need Your Love");
                namesList.add("Loyal");
                namesList.add("One More Night");
                namesList.add("Wide Awake");
                namesList.add("Grenade");
                namesList.add("Boyfriend");
                namesList.add("Give Me Everything");
                namesList.add("What’s My Name?");
                namesList.add("Scream & Shout");
                namesList.add("Stay");
                namesList.add("Drag Me Down");
                namesList.add("Only Girl");
                namesList.add("International Love");
                namesList.add("This Is How We Do");
                namesList.add("Part Of Me");
                namesList.add("A Thousand Years");
                namesList.add("Party In The U.S.A");
                namesList.add("Story of My Life");
                namesList.add("Single Ladies");
                namesList.add("Blame");
                namesList.add("Hot N Cold");
                namesList.add("Price Tag");
                namesList.add("Bangrang");
                namesList.add("Wildest Dreams");
                namesList.add("Trap Queen");
                namesList.add("No Type");
                namesList.add("Chop Suey!");
                namesList.add("Live While We’re Young");
                namesList.add("One Thing");
                namesList.add("Post To Be");
                namesList.add("Come & Get It");
                namesList.add("Let It Go”");
                namesList.add("Russian Roulette");
                namesList.add("One Time");
                namesList.add("Adventure of a Lifetime");
                namesList.add("Love Me Again");
                namesList.add("Habits");
                namesList.add("Smells Like Teen Spirit");
                namesList.add("When I Was Your Man");
                namesList.add("24K Magic");
                namesList.add("When I’m Gone");
                namesList.add("Can’t Hold Us");
                namesList.add("7 Years");
                namesList.add("The One That Got Away");
                namesList.add("Moves Like Jagger");
                namesList.add("Zombie");
                namesList.add("Blurred Lines");
                namesList.add("Numb");
                namesList.add("Demons");
                namesList.add("We Are Young");
                namesList.add("The Heart Wants What It Wants");
                namesList.add("Locked Away");
                namesList.add("Lush Life");
                namesList.add("It Will Rain");
                namesList.add("Rockabye");
                namesList.add("We Are Never Ever Getting Back Together");
                namesList.add("Black Widow");
                namesList.add("Into You");
                namesList.add("Sexy and I Know It");
                namesList.add("Mirror");
                namesList.add("Heart Attack");
                namesList.add("Lips Are Movin");
                namesList.add("Rap God");
                namesList.add("Mirrors");
                namesList.add("Black Beatles");
                namesList.add("Give Me Love");
                namesList.add("Get Low");
                namesList.add("Hips Don’t Lie");
                namesList.add("It’s My Life");
                namesList.add("Drunk In Love");
                namesList.add("Outside");
                namesList.add("Poker Face");
                namesList.add("Whistle");
                namesList.add("Payphone");
                namesList.add("One Call Away");
                namesList.add("I Will Always Love You");
                namesList.add("Wild Ones");
                namesList.add("Sorry for Party Rocking");
                namesList.add("Girlfriend");
                namesList.add("Hideaway");
                namesList.add("Four Five Seconds");
                namesList.add("Airplanes");
                namesList.add("Maps");
                namesList.add("The Time");
                namesList.add("Barbie Girl");
                namesList.add("Don’t Cry");
                namesList.add("Flashlight");
                namesList.add("Dangerous Woman");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });
                break;
            case "Miscellaneous Items":
                namesList = new ArrayList<>();

                namesList.add("Dance");
                namesList.add("Chair");
                namesList.add("Ice cream cone");
                namesList.add("Clap");
                namesList.add("Pinch");
                namesList.add("Prayer");
                namesList.add("Doll");
                namesList.add("Balloon");
                namesList.add("Draw");
                namesList.add("Stop");
                namesList.add("Mosquito");
                namesList.add("Skip");
                namesList.add("Robot");
                namesList.add("Scissors");
                namesList.add("Jump");
                namesList.add("Circle");
                namesList.add("Sleep");
                namesList.add("Kick");
                namesList.add("Book");
                namesList.add("Sneeze");
                namesList.add("Wave");
                namesList.add("Toothrush");
                namesList.add("Jumping jack");
                namesList.add("Cheek");
                namesList.add("Drink");
                namesList.add("Pillow");
                namesList.add("Camera");
                namesList.add("Eat");
                namesList.add("Blink");
                namesList.add("Point");
                namesList.add("Glasses");
                namesList.add("Telephone");
                namesList.add("Door");
                namesList.add("Baby");
                namesList.add("Ring");
                namesList.add("Ghost");
                namesList.add("Socks");
                namesList.add("Coat");
                namesList.add("Kite");
                namesList.add("Milk");
                namesList.add("Skateboard");
                namesList.add("Star");
                namesList.add("Spoon");
                namesList.add("Sun");
                namesList.add("Cup");
                namesList.add("Flower");
                namesList.add("Pie");
                namesList.add("Snowflake");
                namesList.add("Jar");
                namesList.add("Light");
                namesList.add("Tree");
                namesList.add("Slide");
                namesList.add("Shoe");
                namesList.add("Water");
                namesList.add("Hat");
                namesList.add("Bird");
                namesList.add("Ball");
                namesList.add("Bed");
                namesList.add("Cookie");
                namesList.add("Spider Web");
                namesList.add("Hula Loop");
                namesList.add("Whisper");
                namesList.add("Earthquake");
                namesList.add("Rain");
                namesList.add("Chop");
                namesList.add("Seesaw");
                namesList.add("Blind");
                namesList.add("Twist");
                namesList.add("Tickle");
                namesList.add("Soap");
                namesList.add("Fang");
                namesList.add("Lipstick");
                namesList.add("Popsicle");
                namesList.add("Yo-yo");
                namesList.add("Beg");
                namesList.add("Fetch");
                namesList.add("Shovel");
                namesList.add("Saddle");
                namesList.add("Bicycle");
                namesList.add("Puppet");
                namesList.add("Salute");
                namesList.add("Banana Peel");
                namesList.add("Slam Dunk");
                namesList.add("Newspaper");
                namesList.add("Wink");
                namesList.add("Coin");
                namesList.add("Money");
                namesList.add("Braid");
                namesList.add("");
                namesList.add("");
                namesList.add("");
                namesList.add("");
                namesList.add("");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });

                break;
            case "Animals":
                namesList = new ArrayList<>();

                namesList.add("Dog");
                namesList.add("Alligator");
                namesList.add("Cat");
                namesList.add("Bee");
                namesList.add("Snake");
                namesList.add("Fish");
                namesList.add("Cow");
                namesList.add("Horse");
                namesList.add("Rabbit");
                namesList.add("Spider");
                namesList.add("Bird");
                namesList.add("Owl");
                namesList.add("Monkey");
                namesList.add("Penguin");
                namesList.add("Elephant");
                namesList.add("Giraffe");
                namesList.add("Lion");
                namesList.add("Tiger");
                namesList.add("Squirrel");
                namesList.add("Pig");
                namesList.add("Lion");
                namesList.add("Chicken");
                namesList.add("Chimpanzee");
                namesList.add("Parrot");
                namesList.add("Bear");
                namesList.add("Hippo");
                namesList.add("Warthog");
                namesList.add("Zebra");
                namesList.add("Deer");
                namesList.add("Deer");
                namesList.add("Frog");
                namesList.add("Butterfly");
                namesList.add("Worm");
                namesList.add("Panda");
                namesList.add("Gorilla");
                namesList.add("Rhino");
                namesList.add("Cheetah");
                namesList.add("Meerkat");
                namesList.add("Emu");
                namesList.add("Camel");
                namesList.add("Wolf");
                namesList.add("Platypus");
                namesList.add("Moose");
                namesList.add("Bison");
                namesList.add("Scorpion");
                namesList.add("Spider");
                namesList.add("Caterpillar");
                namesList.add("Praying-Mantis ");
                namesList.add("Chipmunk");
                namesList.add("Flamingo");
                namesList.add("Tortoise");
                namesList.add("Toucan");
                namesList.add("Sloth");
                namesList.add("Lemur");
                namesList.add("Koala");
                namesList.add("Hyena");
                namesList.add("Eagle");
                namesList.add("Hamster");
                namesList.add("Goldfish");
                namesList.add("Snail");
                namesList.add("Hedgehog");
                namesList.add("Budgie");
                namesList.add("Lizard");
                namesList.add("Alpaca");
                namesList.add("Mouse");
                namesList.add("Octopus");
                namesList.add("Turtle");
                namesList.add("Jellyfish");
                namesList.add("Oyster");
                namesList.add("Squid");
                namesList.add("Cow");
                namesList.add("Sheep");
                namesList.add("Elephant");
                namesList.add("Duck");
                namesList.add("Rooster");
                namesList.add("Donkey");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });

                break;
            case "Sports/Leisure Activities":
                namesList = new ArrayList<>();

                namesList.add("Skiing");
                namesList.add("Ice skating");
                namesList.add("Diving off diving board");
                namesList.add("Cheerleading");
                namesList.add("Pogo stick");
                namesList.add("Running/jogging");
                namesList.add("Baseball");
                namesList.add("Basketball");
                namesList.add("Tennis");
                namesList.add("Football");
                namesList.add("Frisbee");
                namesList.add("Golf");
                namesList.add("Swimming");
                namesList.add("Skateboarding");
                namesList.add("Riding a bike");
                namesList.add("Riding a scooter");
                namesList.add("Jumping rope");
                namesList.add("Hiking");
                namesList.add("Cricket");
                namesList.add("Lawn Bowls");
                namesList.add("Hockey");
                namesList.add("Karate");
                namesList.add("Darts");
                namesList.add("Table Tennis");
                namesList.add("Volley Ball");
                namesList.add("Archery");
                namesList.add("Horseback riding");
                namesList.add("Figure skating");
                namesList.add("Doing yoga");
                namesList.add("Surfing");
                namesList.add("Water skiing");
                namesList.add("Playing hacky sack");
                namesList.add("Playing pool/billiards");
                namesList.add("Bowling");
                namesList.add("Fishing");
                namesList.add("Ballet dancing");
                namesList.add("Tap dancing");
                namesList.add("Salsa dancing");
                namesList.add("Playing corn hole");
                namesList.add("Playing horseshoes");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });
                break;
            case "Jobs/Personalities":
                namesList = new ArrayList<>();

                namesList.add("Cashier");
                namesList.add("Bartender");
                namesList.add("Lumberjack");
                namesList.add("Car mechanic");
                namesList.add("Teacher");
                namesList.add("Computer coder");
                namesList.add("Police officer");
                namesList.add("Doctor/nurse");
                namesList.add("Pro wrestler");
                namesList.add("Beauty queen");
                namesList.add("Hair stylist");
                namesList.add("Makeup artist");
                namesList.add("President");
                namesList.add("Firefighter");
                namesList.add("Waiter/server");
                namesList.add("Lifeguard");
                namesList.add("Music conductor");
                namesList.add("Accountant");
                namesList.add("Architect");
                namesList.add("Author");
                namesList.add("Baker");
                namesList.add("Butcher");
                namesList.add("Carpenter");
                namesList.add("Chef/Cook");
                namesList.add("Cleaner");
                namesList.add("Dentist");
                namesList.add("Electrician");
                namesList.add("Farmer");
                namesList.add("Florist");
                namesList.add("Gardener");
                namesList.add("Fisherman");
                namesList.add("Journalist");
                namesList.add("Judge");
                namesList.add("Lawyer");
                namesList.add("Model");
                namesList.add("Painter");
                namesList.add("Pharmacist");
                namesList.add("Photographer");
                namesList.add("Pilot");
                namesList.add("Plumber");
                namesList.add("Politician");
                namesList.add("Postman");
                namesList.add("Receptionist");
                namesList.add("Scientist");
                namesList.add("Tailor");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });

                break;
            case "Musical Instruments":
                namesList = new ArrayList<>();

                namesList.add("Violin");
                namesList.add("Guitar");
                namesList.add("Drums");
                namesList.add("Trumpet");
                namesList.add("Flute");
                namesList.add("Trombone");
                namesList.add("Clarinet/recorder");
                namesList.add("Saxophone");
                namesList.add("Stand-up bass");
                namesList.add("Tuba");
                namesList.add("Piano");
                namesList.add("Accordion");
                namesList.add("Bagpipes");
                namesList.add("Banjo");
                namesList.add("Bugle");
                namesList.add("Cello");
                namesList.add("Cymbals");
                namesList.add("French horn");
                namesList.add("Harmonica");
                namesList.add("Harp");
                namesList.add("Maracas");
                namesList.add("Organ");
                namesList.add("Sitar");
                namesList.add("Tambourine");
                namesList.add("Trumpet");
                namesList.add("Xylophone");
                namesList.add("Bassoon");
                namesList.add("Castanets");
                namesList.add("Didgeridoo");
                namesList.add("Double bass");
                namesList.add("Gong");
                namesList.add("Harpsichord");
                namesList.add("Lute");
                namesList.add("Mandolin");
                namesList.add("Oboe");
                namesList.add("Piccolo");
                namesList.add("Viola");
                namesList.add("Keyboard");
                namesList.add("Bongo-drums");
                namesList.add("Chime");
                namesList.add("Cowbell");
                namesList.add("Euphonium");
                namesList.add("Lyre");
                namesList.add("Marimba");
                namesList.add("Timpani");
                namesList.add("Ukulele");
                namesList.add("Hammered dulcimer");
                namesList.add("Triangle");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });

                break;
            case "Emotions":
                namesList = new ArrayList<>();
                namesList.add("Afraid");
                namesList.add("Anxious/Worried");
                namesList.add("Cautious");
                namesList.add("Frightened");
                namesList.add("Terrified");
                namesList.add("Uncertain");
                namesList.add("Angry");
                namesList.add("Enraged");
                namesList.add("Exasperated");
                namesList.add("Irritated");
                namesList.add("Confident");
                namesList.add("Courageous");
                namesList.add("Optimistic");
                namesList.add("Confused");
                namesList.add("Curious");
                namesList.add("Interested");
                namesList.add("Amused");
                namesList.add("Excited");
                namesList.add("Enthusiastic");
                namesList.add("Happy");
                namesList.add("Proud");
                namesList.add("Bored");
                namesList.add("Disgusted");
                namesList.add("Embarrassed");
                namesList.add("Guilty");
                namesList.add("Hopeful");
                namesList.add("Indifferent");
                namesList.add("Innocent");
                namesList.add("Jealous");
                namesList.add("Self-Conscious");
                namesList.add("Shocked");
                namesList.add("Shy");
                namesList.add("Arrogant");
                namesList.add("Depressed");
                namesList.add("Disappointed");
                namesList.add("Grieving");
                namesList.add("Hurt");
                namesList.add("Lonely");
                namesList.add("Sorry");
                namesList.add("Sad");
                namesList.add("Satisfied");
                namesList.add("Relieved");
                namesList.add("Silly");

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });
                break;
            case "TV Shows":
                namesList = new ArrayList<>();

                namesList.add("Supernatural");
                namesList.add("Supernatural");
                namesList.add("The Simpsons");
                namesList.add("Top Gear");
                namesList.add("South Park");
                namesList.add("The IT Crowd");
                namesList.add("Suits");
                namesList.add("Game of Thrones");
                namesList.add("The Wire");
                namesList.add("Gossip Girl");
                namesList.add("Frasier");
                namesList.add("Arrested Development");
                namesList.add("Veronica Mars");
                namesList.add("Revenge");
                namesList.add("The Sopranos");
                namesList.add("That '70s Show");
                namesList.add("Friends");
                namesList.add("Inspector Rex");
                namesList.add("House");
                namesList.add("Dexter");
                namesList.add("Sex and the City");
                namesList.add("Modern Family");
                namesList.add("It's Always Sunny in Philadelphia");
                namesList.add("The Newsroom");
                namesList.add("The West Wing");
                namesList.add("Breaking Bad");
                namesList.add("Entourage");
                namesList.add("The OC");
                namesList.add("Toddlers and Tiaras");
                namesList.add("Fawlty Towers");
                namesList.add("Homeland");
                namesList.add("Dance Moms");
                namesList.add("Seinfeld");
                namesList.add("Scrubs");
                namesList.add("Family Guy");
                namesList.add("How I Met Your Mother");
                namesList.add("The Saddle Club");
                namesList.add("Curb Your Enthuiasm");
                namesList.add("Dora the Explorer");
                namesList.add("Grey's Anatomy");
                namesList.add("The Amazing Race");
                namesList.add("Wipeout");
                namesList.add("The Office");
                namesList.add("Star Trek");
                namesList.add("Neighbours");
                namesList.add("Mr Bean");
                namesList.add("Flight of the Concords");
                namesList.add("The Big Bang Theory");
                namesList.add("Futurama");
                namesList.add("Lost");
                namesList.add("Kim Possible");
                namesList.add("Doctor Who");
                namesList.add("Keeping Up With the Kardashians");
                namesList.add("Deadwood");
                namesList.add("Mythbusters");
                namesList.add("Downton Abbey");
                namesList.add("Big Brother");
                namesList.add("The X Files");
                namesList.add("I Love Lucy");
                namesList.add("Smallville");
                namesList.add("Survivor");
                namesList.add("Summer Heights High");
                namesList.add("Dark");
                namesList.add("The Vikings");
                namesList.add("Silicon Valley");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });

                break;
            case "Books":
                namesList = new ArrayList<>();

                namesList.add("Harry Potter");
                namesList.add("Angels and Demons");
                namesList.add("The Handmaid's Tale");
                namesList.add("The Lion, the Witch, and the Wardrobe");
                namesList.add("The Hitchhiker's Guide to the Galaxy");
                namesList.add("The Five People You Meet In Heaven");
                namesList.add("The Da Vinci Code");
                namesList.add("The Grapes of Wrath");
                namesList.add("Jane Eyre");
                namesList.add("Little Women");
                namesList.add("Catch-22");
                namesList.add("The Catcher in the Rye");
                namesList.add("The Code of the Woosters");
                namesList.add("The Pillars of the Earth");
                namesList.add("Watership Down");
                namesList.add("A Clockwood Orange");
                namesList.add("The Very Hungry Caterpillar");
                namesList.add("A Thousand Splendid Suns");
                namesList.add("Gone With the Wind");
                namesList.add("50 Shades of Grey");
                namesList.add("The Wind in the Willows");
                namesList.add("Charlie and the Chocolate Factory");
                namesList.add("Eclipse");
                namesList.add("Nineteen Eighty-Four");
                namesList.add("The Cat in the Hat");
                namesList.add("Breaking Dawn");
                namesList.add("The Girl With the Dragon Tattoo");
                namesList.add("The Hunger Games");
                namesList.add("New Moon");
                namesList.add("Brave New World");
                namesList.add("The Secret");
                namesList.add("Rebecca");
                namesList.add("A Tale of Two Cities");
                namesList.add("Charlotte's Web");
                namesList.add("The Hobbit");
                namesList.add("Pride and Prejudice");
                namesList.add("The Duke and I");
                namesList.add("Outlander");
                namesList.add("Red, White & Royal Blue");
                namesList.add("Me Before You");
                namesList.add("The Notebook");
                namesList.add("The Bride Test");
                namesList.add("Jane Eyre");
                namesList.add("Eleanor & Park");
                namesList.add("Wuthering Heights");
                namesList.add("The Wedding Date");
                namesList.add("The Time Traveler's Wife");
                namesList.add("Call Me By Your Name");
                namesList.add("Boyfriend Material");
                namesList.add("The Ex Talk");
                namesList.add("If I Never Met You");
                namesList.add("The Giver of Stars");
                namesList.add("The Kiss Quotient");
                namesList.add("The Devil Wears Black");
                namesList.add("A Study in Scarlet");
                namesList.add("The Maltese Falcon");
                namesList.add("The Sweetness at the Bottom of the Pie");
                namesList.add("Dark Sky");
                namesList.add("The Thursday Murder Club");
                namesList.add("Heartbreak Bay");
                namesList.add("The Big Sleep");
                namesList.add("Gone Girl");
                namesList.add("The Postman Always Rings Twice");
                namesList.add("Tinker, Tailor, Soldier, Spy");
                namesList.add("The Woman in White");
                namesList.add("The Rebecca Notebook: and Other Memories");
                namesList.add("Big Little Lies");
                namesList.add("Transient Desires");
                namesList.add("Case Histories");
                namesList.add("Murder on the Orient Express");
                namesList.add("The Daughter of Time");
                namesList.add("In The Woods");
                namesList.add("The Day of the Jackal");
                namesList.add("The Lord of the Rings");
                namesList.add("The Lies of Locke Lamora");
                namesList.add("A Song of Ice and Fire");
                namesList.add("The Golem and the Djinni");
                namesList.add("The Dark Tower: The Gunslinger");
                namesList.add("The Last Unicorn");
                namesList.add("His Dark Materials");
                namesList.add("Circle");
                namesList.add("Earthlings");
                namesList.add("Dune");
                namesList.add("The Blazing World");
                namesList.add("Foundation");
                namesList.add("Snow Crash");
                namesList.add("The Stars My Destination");
                namesList.add("Fahrenheit 451");
                namesList.add("The Moon is a Harsh Mistress");
                namesList.add("A Scanner Darkly");
                namesList.add("The Left Hand of Darkness");
                namesList.add("The Resisters");
                namesList.add("The Guest List");
                namesList.add("Later");
                namesList.add("The Haunting of Hill House");
                namesList.add("Pet Sematary");
                namesList.add("The Silent Patient");
                namesList.add("Something Wicked This Way Comes");
                namesList.add("Let The Right One In");
                namesList.add("The Turn of the Screw");
                namesList.add("I Am Legend");
                namesList.add("Hell House");
                namesList.add("The Family Upstairs");
                namesList.add("Nine Perfect Strangers");
                namesList.add("In A Dark, Dark Wood");
                namesList.add("The Cutting Seasons");
                namesList.add("Behind Closed Doors");
                namesList.add("An Untamed State");
                namesList.add("Before I Go to Sleep");
                namesList.add("The Hunting Party");
                namesList.add("The Imposter");
                namesList.add("Atomic Habits");
                namesList.add("The Alchemist");
                namesList.add("Awaken The Giant Within");
                namesList.add("Choose Yourself");
                namesList.add("Where the Wild Things Are");
                namesList.add("Diary of a Wimpy Kid");
                namesList.add("Little Miss Sunshine");
                namesList.add("The Princess Diaries");
                namesList.add("The Chronicles of Narnia");
                namesList.add("Alice's Adventures in Wonderland");
                namesList.add("The BFG");
                namesList.add("Inkheart");
                namesList.add("A Series of Unfortunate Events");
                namesList.add("The Tale of Peter Rabbit");
                namesList.add("Winnie the Pooh");
                namesList.add("Goodnight Moon");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });

                break;

            case "Famous Places":
                namesList = new ArrayList<>();

                namesList.add("The Eiffel Tower");
                namesList.add("The Burj Khalifa Tower");
                namesList.add("The Great Wall of China");
                namesList.add("The Sahara Desert");
                namesList.add("The Taj Mahal");
                namesList.add("The Golden Gate Bridge");
                namesList.add("The Statue of Liberty");
                namesList.add("Mt. Everest");
                namesList.add("The North Pole");
                namesList.add("The Amazon Rainforest");
                namesList.add("The Leaning Tower of Pisa");
                namesList.add("The Pyramids of Egypt");
                namesList.add("The Grand Canyon");
                namesList.add("London Bridge");
                namesList.add("The Sydney Opera House");
                namesList.add("Hanging Gardens of Babylon");
                namesList.add("Lighthouse of Alexandria");
                namesList.add("Colossus of Rhodes");
                namesList.add("Statue of Zeus at Olympia");
                namesList.add("Mausoleum at Halicarnassus");
                namesList.add("Temple of Artemis at Olympia");
                namesList.add("The Colosseum in Rome");
                namesList.add("Christ the Redeemer Statue");
                namesList.add("Machu Picchu");
                namesList.add("Chichen Itza");
                namesList.add("Petra");
                namesList.add("Cliffs of Moher");
                namesList.add("Niagara Falls");
                namesList.add("The Louvre");
                namesList.add("Kremlin Wall");
                namesList.add("Moai Statues");
                namesList.add("Angkor");
                namesList.add("Mount Rushmore National Memorial");
                namesList.add("Mont Saint-Michel");
                namesList.add("St. Basil's Cathedral");
                namesList.add("The Acropolis");
                namesList.add("Easter Island");
                namesList.add("Golden Gate Bridge");
                namesList.add("Neuschwanstein Castle");
                namesList.add("Victoria Falls");
                namesList.add("The Western Wall");
                namesList.add("Giant's Causeway");
                namesList.add("La Sagrada Familia");
                namesList.add("Blue Mosque");
                namesList.add("The Grand Palace");
                namesList.add("Ha Long Bay");
                namesList.add("Stonehenge");
                namesList.add("Blue Domes of Oia");

                Max = namesList.size();

                rndNum = (int) (Math.random() * (Max - Min));

                timerText.setVisibility(View.GONE);
                foreheadText.setVisibility(View.GONE);
                secondTimerText.setVisibility(View.VISIBLE);
                guessesText.setVisibility(View.VISIBLE);

                guessesText.setText(namesList.get(rndNum));
                startTimer();

                gyroscope = new Gyroscope(this);

                gyroscope.register();

                gyroscope.setListener(new Gyroscope.Listener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRotation(float rx, float ry, float rz) {
                        if (ry > 8.0) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                                backgroundColor = "red";
                                textIncorrect = (String) guessesText.getText();
                                guessesText.setText("Pass");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textIncorrect);
                                        incorrectList.add(textIncorrect);
                                        namesList.remove(index);
                                        incorrectCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if (backgroundColor.equals("green")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                            }
                        } else if (ry < -8.0f) {
                            timerPause();
                            if (backgroundColor.equals("purple")) {
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#44D14A"));
                                backgroundColor = "green";
                                textCorrect = (String) guessesText.getText();
                                guessesText.setText("Correct");
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        int index = namesList.indexOf(textCorrect);
                                        correctList.add(textCorrect);
                                        namesList.remove(index);
                                        correctCount++;
                                        startTimer();
                                        Max = namesList.size();
                                        secondTimerText.setVisibility(View.VISIBLE);
                                        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#FFBB86FC"));
                                        backgroundColor = "purple";
                                        int rndNum2 = (int) (Math.random() * (Max - Min));
                                        guessesText.setText(namesList.get(rndNum2));
                                    }
                                }, 1000);
                            } else if(backgroundColor.equals("red")){
                                getWindow().getDecorView().setBackgroundColor(Color.parseColor("#D63434"));
                            }
                        }
                    }
                });
                break;
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

