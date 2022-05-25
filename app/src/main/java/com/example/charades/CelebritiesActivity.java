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
                namesList.add("Jennifer Aniston");
                namesList.add("Jennifer Lawrence");
                namesList.add("Chris Hemsworth");
                namesList.add("James McAvoy");
                namesList.add("James Cameron");
                namesList.add("Brendan Fraser");
                namesList.add("Rachel McAdams");
                namesList.add("Tom Hiddleston");
                namesList.add("Johnny Depp");
                namesList.add("Margot Robbie");
                namesList.add("Jared Leto");
                namesList.add("Ryan Reynolds");
                namesList.add("Ryan Gosling");
                namesList.add("Paul Rudd");
                namesList.add("Matthew Mcconaughey");
                namesList.add("Tom Hardy");
                namesList.add("Jammie Foxx");
                namesList.add("Emma Stone");
                namesList.add("Chris Pratt");
                namesList.add("Samuel L. Jackson");
                namesList.add("Tom Holland");
                namesList.add("Tyler Peryy");
                namesList.add("Gal Gadot");
                namesList.add("Idris Elba");
                namesList.add("Cara Delevinge");
                namesList.add("Melissa Mccarthy");
                namesList.add("Charlize Theron");
                namesList.add("Anna Kendrick");
                namesList.add("Amy Poehler");
                namesList.add("Mark Wahlberg");
                namesList.add("Jonah Hill");
                namesList.add("Daisy Ridley");
                namesList.add("Jessica Chastain");
                namesList.add("Kristen Wiig");
                namesList.add("James Mcavoy");
                namesList.add("Denzel Washington");
                namesList.add("Felicity Jones");
                namesList.add("Richard Gere");
                namesList.add("Catherine Zeta-Jones");
                namesList.add("Clive Owen");
                namesList.add("Guy Pearce");
                namesList.add("Meg Ryan");
                namesList.add("Nicole Kidman");
                namesList.add("Gerard Butler");
                namesList.add("Simon Baker");
                namesList.add("Katherine Heigl");
                namesList.add("Eddie Murphy");
                namesList.add("Meryl Streep");
                namesList.add("Anthony Hopkins");
                namesList.add("Martin Lawrence");
                namesList.add("Salma Hayek");
                namesList.add("Penelope Cruz");
                namesList.add("Cuba Gooding Jr.");
                namesList.add("Jack Black");
                namesList.add("Lindsay Lohan");
                namesList.add("Kevin Costner");
                namesList.add("Steve Martin");
                namesList.add("Michelle Rodriguez");
                namesList.add("Milla Jovovich");
                namesList.add("Elijah Wood");
                namesList.add("Demi Moore");
                namesList.add("Eva Mendes");
                namesList.add("Kirsten Dunst");
                namesList.add("Leslie Nielsen");
                namesList.add("Liv Tyler");
                namesList.add("Robert Redford");
                namesList.add("Ewan McGregor");
                namesList.add("Lucy Liu");
                namesList.add("Paul Newman");
                namesList.add("Zooey Deschanel");
                namesList.add("Danny Devito");
                namesList.add("Michelle Pfeiffer");
                namesList.add("Michael J Fox");
                namesList.add("Sharon Stone");
                namesList.add("Amanda Bynes");
                namesList.add("Winona Ryder");
                namesList.add("Jane Fonda");
                namesList.add("Jessica Biel");
                namesList.add("Rosario Dawson");
                namesList.add("Kim Basinger");
                namesList.add("Monica Bellucci");
                namesList.add("Sarah Michelle Geller");
                namesList.add("Carla Gugino");
                namesList.add("Andie MacDowell");
                namesList.add("Carmen Electra");
                namesList.add("Cristina Ricci");
                namesList.add("Alicia Silverstone");
                namesList.add("Mike Myers");
                namesList.add("Stella Warren");
                namesList.add("Rebecca Romijn-Stamos");
                namesList.add("Sienna Guillory");

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
            case "TV Shows":
                namesList = new ArrayList<>();

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

            case "Gadgets":
                namesList = new ArrayList<>();

                namesList.add("Alarm clock");
                namesList.add("Antenna");
                namesList.add("Calculator");
                namesList.add("Computer");
                namesList.add("Digital camera");
                namesList.add("DVD player");
                namesList.add("Earbuds");
                namesList.add("Ebook");
                namesList.add("Floppy disc");
                namesList.add("Game console");
                namesList.add("Hard drive");
                namesList.add("Headphones");
                namesList.add("Laptop");
                namesList.add("Memory card");
                namesList.add("Memory stick");
                namesList.add("Microphone");
                namesList.add("Mouse");
                namesList.add("Mp3 player");
                namesList.add("Photo camera");
                namesList.add("Printer");
                namesList.add("Projector");
                namesList.add("Remote control");
                namesList.add("Router");
                namesList.add("Scanner");
                namesList.add("Smart Board");
                namesList.add("Tablet PC");
                namesList.add("Usb stick");
                namesList.add("Video Camera");
                namesList.add("Webcam");
                namesList.add("Smartphone");
                namesList.add("Satellite phones");
                namesList.add("Tablets");
                namesList.add("E-reader");
                namesList.add("Bulb");
                namesList.add("Radiator");
                namesList.add("Toaster");
                namesList.add("Curling Iron");
                namesList.add("Radio");
                namesList.add("Lamp");
                namesList.add("Refrigerator");
                namesList.add("Cooker");
                namesList.add("Safe");
                namesList.add("Scale");
                namesList.add("Sewing Machine");
                namesList.add("Smart TV");
                namesList.add("PEncil Sharpener");
                namesList.add("Electric Guitar");
                namesList.add("Timer");
                namesList.add("Speaker");
                namesList.add("Telephone");
                namesList.add("Flashlight");
                namesList.add("USB");
                namesList.add("Fan");
                namesList.add("Washing Machine");
                namesList.add("CCTV");
                namesList.add("Iron");
                namesList.add("Smartwatch");
                namesList.add("Drone");
                namesList.add("Oven");
                namesList.add("Dishwasher");
                namesList.add("Drill");
                namesList.add("Electric Grill");
                namesList.add("Hair Dryer");
                namesList.add("Juicer");
                namesList.add("Piano");
                namesList.add("Keyboard");
                namesList.add("Generator");
                namesList.add("Joystick");
                namesList.add("Electric Cars");

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
            case "Pakistani Celebrities":
                namesList = new ArrayList<>();

                namesList.add("Aaminah Haq");
                namesList.add("Armeena Khan");
                namesList.add("Aamina Sheikh");
                namesList.add("Aiman Khan");
                namesList.add("Ainy Jaffri");
                namesList.add("Alishba Yousuf");
                namesList.add("Angeline Malik");
                namesList.add("Anjuman Shehzadi");
                namesList.add("Anum Fayyaz");
                namesList.add("Anoushey Ashraf");
                namesList.add("Arjumand Rahim");
                namesList.add("Arisha Razi");
                namesList.add("Asha Posley");
                namesList.add("Atiqa Odho");
                namesList.add("Ayesha Khan");
                namesList.add("Ayesha Omar");
                namesList.add("Ayesha Sana");
                namesList.add("Ayeza Khan");
                namesList.add("Ayyan Ali");
                namesList.add("Azra Sherwani");
                namesList.add("Arij Fatyma");
                namesList.add("Abdullah Ejaz");
                namesList.add("Abdullah Kadwani");
                namesList.add("Abdur Rashid Kardar");
                namesList.add("Abid Ali");
                namesList.add("Abid Kashmiri");
                namesList.add("Abid Khan");
                namesList.add("Adeeb");
                namesList.add("Adeel Hussain");
                namesList.add("Adil Murad");
                namesList.add("Adnan Khan");
                namesList.add("Adnan Jaffar");
                namesList.add("Adnan Malik");
                namesList.add("Adnan Siddiqui");
                namesList.add("Afzal Khan");
                namesList.add("Ahad Raza Mir");
                namesList.add("Ahmed Ali Butt");
                namesList.add("Ahmed Butt");
                namesList.add("Ahmed Jahanzeb");
                namesList.add("Ahsan Khan");
                namesList.add("Aijaz Aslam");
                namesList.add("Ajab Gul");
                namesList.add("Akmal Khan");
                namesList.add("Alamzeb Mujahid");
                namesList.add("Albela");
                namesList.add("Ali Abbas");
                namesList.add("Ali Haider");
                namesList.add("Ali Ejaz");
                namesList.add("Ali Rehman Khan");
                namesList.add("Ali Zafar");
                namesList.add("Allauddin");
                namesList.add("Alyy Khan");
                namesList.add("Anwar Solangi");
                namesList.add("Asad Malik");
                namesList.add("Asif Raza Mir");
                namesList.add("Aslam Pervaiz");
                namesList.add("Ather Shah Khan Jaidi");
                namesList.add("Ayaz Samoo");
                namesList.add("Azfar Rehman");
                namesList.add("Babra Sharif");
                namesList.add("Badar Khalil");
                namesList.add("Bahar Begum");
                namesList.add("Begum Khurshid Mirz");
                namesList.add("Bushra Ansari");
                namesList.add("Bushra Farrukh");
                namesList.add("Deeba");
                namesList.add("Deedar");
                namesList.add("Babar Ali");
                namesList.add("Babar Khan");
                namesList.add("Badar Munir");
                namesList.add("Bilal Ashraf");
                namesList.add("Bilal Khan");
                namesList.add("Behroze Sabzwari");
                namesList.add("Babu Baral");
                namesList.add("Cezanne Khan");
                namesList.add("Danish Nawaz");
                namesList.add("Danish Taimoor");
                namesList.add("Darpan");
                namesList.add("Ejaz Durrani");
                namesList.add("Emi Khan");
                namesList.add("Farah Shah");
                namesList.add("Fatima Effendi Kanwar");
                namesList.add("Fazila Qazi");
                namesList.add("Ghana Ali");
                namesList.add("Gori");
                namesList.add("Fahad Mustafa");
                namesList.add("Faisal Rehman");
                namesList.add("Faisal Qureshi");
                namesList.add("Farhan Saeed");
                namesList.add("Farooq Qaiser");
                namesList.add("Fawad Khan");
                namesList.add("Faysal Qureshi");
                namesList.add("Feroze Khan");
                namesList.add("Firdous Jamal");
                namesList.add("Firdous Jamal");
                namesList.add("Faizan Khawaja");
                namesList.add("Faizan Shahzad Khan");
                namesList.add("Hajra Yamin");
                namesList.add("Hareem Farooq");
                namesList.add("Hina Dilpazeer");
                namesList.add("Hina Shaheen");
                namesList.add("Humaima Malik");
                namesList.add("Husna");
                namesList.add("Hania Amir");
                namesList.add("Ghulam Mohiuddin");
                namesList.add("Ghayyur Akhtar");
                namesList.add("Gohar Rasheed");
                namesList.add("Goher Mumtaz");
                namesList.add("Hamza Ali Abbasi");
                namesList.add("Habib-ur-Rehman");
                namesList.add("Hameed Sheikh");
                namesList.add("Hamid Rana");
                namesList.add("Hassam Khan");
                namesList.add("Hasan Jahangir");
                namesList.add("Hayatullah Khan Durrani");
                namesList.add("Humayun Saeed");
                namesList.add("Iffat Rahim");
                namesList.add("Iman Ali");
                namesList.add("Ismat Zaidi");
                namesList.add("Iqra Aziz");
                namesList.add("Jana Malik");
                namesList.add("Javeria Abbasi");
                namesList.add("Javeria Saud");
                namesList.add("Juggan Kazim");
                namesList.add("Iftikhar Thakur");
                namesList.add("Ilyas Kashmiri");
                namesList.add("Imran Abbas Naqvi");
                namesList.add("Imran Ashraf");
                namesList.add("Imran Aslam");
                namesList.add("Inayat Hussain Bhatti");
                namesList.add("Iqbal Theba");
                namesList.add("Irfan Khoosat");
                namesList.add("Ismael Shah");
                namesList.add("Ismail Tara");
                namesList.add("Ismail Shahid");
                namesList.add("Jamal Shah");
                namesList.add("Izhar Qazi");
                namesList.add("Jamil Fakhri");
                namesList.add("Jamshed Ansari");
                namesList.add("Javed Sheikh");
                namesList.add("Jawad Bashir");
                namesList.add("Junaid Khan");
                namesList.add("Kaveeta");
                namesList.add("Khalida Riyasat");
                namesList.add("Khushboo");
                namesList.add("Komal Rizvi");
                namesList.add("Laila Khan");
                namesList.add("Laila Zuberi");
                namesList.add("Kader Khan");
                namesList.add("Kaifee");
                namesList.add("Kamal Irani");
                namesList.add("Kanwar Arsalan");
                namesList.add("Kashif Mehmood");
                namesList.add("Khalid Abbas Dar");
                namesList.add("Khayyam Sarhadi");
                namesList.add("Kumail Nanjiani");
                namesList.add("Latif Kapadia");
                namesList.add("Lehri");
                namesList.add("Liaquat Soldier");
                namesList.add("Madeeha Gauhar");
                namesList.add("Madiha Iftikhar");
                namesList.add("Madiha Imam");
                namesList.add("Madiha Shah");
                namesList.add("Maham Amir");
                namesList.add("Mahira Khan");
                namesList.add("Maheen Rizvi");
                namesList.add("Mahnoor Baloch");
                namesList.add("Maira Khan");
                namesList.add("Mansha Pasha");
                namesList.add("Maria Wasti");
                namesList.add("Marina Khan");
                namesList.add("Mariyam Khalif");
                namesList.add("Maryam Fatima");
                namesList.add("Maryam Nafees");
                namesList.add("Mathira");
                namesList.add("Mawra Hocane");
                namesList.add("Maya Ali");
                namesList.add("Meera");
                namesList.add("Meesha Shafi");
                namesList.add("Mehr Hassan");
                namesList.add("Mehreen Raheel");
                namesList.add("Mehwish Hayat");
                namesList.add("Mishi Khan");
                namesList.add("Mizna Waqas");
                namesList.add("Momal Sheikh");
                namesList.add("Musarrat Nazir");
                namesList.add("Musarrat Shaheen");
                namesList.add("Mahmood Ali");
                namesList.add("Mehmood Akhtar");
                namesList.add("Munawar Zarif");
                namesList.add("Malik Anokha");
                namesList.add("Murtaza Hassan");
                namesList.add("Mehmood Aslam");
                namesList.add("Mikaal Zulfiqar");
                namesList.add("Moammar Rana");
                namesList.add("Mohammad Ali");
                namesList.add("Mohammed Ehteshamuddin");
                namesList.add("Mohib Mirza");
                namesList.add("Mohsin Abbas Haider");
                namesList.add("Moin Akhter");
                namesList.add("Mukarram");
                namesList.add("Murtaza Hassan");
                namesList.add("Mustafa Qureshi");
                namesList.add("Mustansar Hussain Tarar");
                namesList.add("Nadira");
                namesList.add("Nadia Afghan");
                namesList.add("Nadia Hussain");
                namesList.add("Nadia Khan");
                namesList.add("Nadia Jamil");
                namesList.add("Naheed Shabbir");
                namesList.add("Nargis");
                namesList.add("Naveen Tajik");
                namesList.add("Naveen Waqar");
                namesList.add("Nayyar Sultana");
                namesList.add("Neelam Muneer");
                namesList.add("Neeli");
                namesList.add("Neelo");
                namesList.add("Nida Yasir");
                namesList.add("Nimra Bucha");
                namesList.add("Nirma");
                namesList.add("Noor Bukhari");
                namesList.add("Noor Jehan");
                namesList.add("Nabeel");
                namesList.add("Nadeem Baig");
                namesList.add("Naeem Haq");
                namesList.add("Naeem Hashmi");
                namesList.add("Najeebullah Anjum");
                namesList.add("Naseem Vicky");
                namesList.add("Nasir Chinyoti");
                namesList.add("Nayyar Ejaz");
                namesList.add("Nazir Ahmed Khan");
                namesList.add("Nirala");
                namesList.add("Noman Ijaz");
                namesList.add("Noman Masood");
                namesList.add("Noor Hassan Rizvi");
                namesList.add("Nouman Javaid");
                namesList.add("Omer Shahzad");
                namesList.add("Osman Khalid Butt");
                namesList.add("Qavi Khan");
                namesList.add("Qazi Wajid");
                namesList.add("Qandeel Baloch");
                namesList.add("Rabia Butt");
                namesList.add("Rani");
                namesList.add("Reema Khan");
                namesList.add("Resham");
                namesList.add("Rozina");
                namesList.add("Rubina Ashraf");
                namesList.add("Rubya Chaudhry");
                namesList.add("Rahman Syed");
                namesList.add("Rasheed Naz");
                namesList.add("Rauf Khalid");
                namesList.add("Rauf Lala");
                namesList.add("Rizwan Wasti");
                namesList.add("Saba Hameed");
                namesList.add("Saba Qamar");
                namesList.add("Sabiha Khanum");
                namesList.add("Saboor Ali");
                namesList.add("Sadia Imam");
                namesList.add("Saeeda Imtiaz");
                namesList.add("Sahiba Afzal");
                namesList.add("Saima Noor");
                namesList.add("Saira Khan");
                namesList.add("Sajal Ali");
                namesList.add("Salma Mumtaz");
                namesList.add("Salma Agha");
                namesList.add("Saloni");
                namesList.add("Samina Ahmad");
                namesList.add("Samina Peerzada");
                namesList.add("Samiya Mumtaz");
                namesList.add("Sana Askari");
                namesList.add("Sana Nawaz");
                namesList.add("Saman Ansari");
                namesList.add("Sanam Baloch");
                namesList.add("Sanam Chaudhry");
                namesList.add("Sanam Jung");
                namesList.add("Sanam Saeed");
                namesList.add("Sangeeta");
                namesList.add("Sania Saeed");
                namesList.add("Sara Loren");
                namesList.add("Sarah Khan");
                namesList.add("Sarwat Gilani");
                namesList.add("Savera Nadeem");
                namesList.add("Shabnam");
                namesList.add("Shagufta Ejaz");
                namesList.add("Shamim Ara");
                namesList.add("Shamim Bano");
                namesList.add("Shehnaz Sheikh");
                namesList.add("Sitara");
                namesList.add("Sobia Khan");
                namesList.add("Sohai Ali Abro");
                namesList.add("Somy Ali");
                namesList.add("Sonia Khan");
                namesList.add("Sonia Mishal");
                namesList.add("Sonya Jehan");
                namesList.add("Sumbul Iqbal");
                namesList.add("Suzain Fatima");
                namesList.add("Swaran Lata");
                namesList.add("Syra Yousuf");
                namesList.add("Saad Haroon");
                namesList.add("Saeed Khan Rangeela");
                namesList.add("Sheheryar Munawar Siddiqui");
                namesList.add("Sahir Lodhi");
                namesList.add("Sajjad Ali");
                namesList.add("Sajjad Kishwar");
                namesList.add("Sajid Hasan");
                namesList.add("Salahuddin Toofani");
                namesList.add("Saleem Sheikh");
                namesList.add("Salim Nasir");
                namesList.add("Salman Shahid");
                namesList.add("Sami Shah");
                namesList.add("Sami Khan");
                namesList.add("Santosh Kumar");
                namesList.add("Sarmad Khoosat");
                namesList.add("Saud");
                namesList.add("Shaan Shahid");
                namesList.add("Shabbir Jan");
                namesList.add("Shafi Muhammad Shah");
                namesList.add("Shafqat Cheema");
                namesList.add("Shahid Hameed");
                namesList.add("Shehroz Sabzwari");
                namesList.add("Shahood Alvi");
                namesList.add("Shahzad Noor");
                namesList.add("Shaz Khan");
                namesList.add("Shakeel Hussain Khan");
                namesList.add("Shakeel Yousuf");
                namesList.add("Shamil Khan");
                namesList.add("Shamil Khan");
                namesList.add("Shamoon Abbasi");
                namesList.add("Shehzad Sheikh");
                namesList.add("Sikander Rizvi");
                namesList.add("Sikandar Sanam");
                namesList.add("Sohail Ahmed");
                namesList.add("Subhani ba Yunus");
                namesList.add("Sudhir");
                namesList.add("Sultan Rahi");
                namesList.add("Syed Ishrat Abbas");
                namesList.add("Syed Kamal");
                namesList.add("Syed Musa Raza");
                namesList.add("Tooba Siddiqui");
                namesList.add("Ushna Shah");
                namesList.add("Uzra Butt");
                namesList.add("Urwa Hocane");
                namesList.add("Umer Sharif");
                namesList.add("Usman Peerzada");
                namesList.add("Vasay Chaudhry");
                namesList.add("Vaneeza Ahmad");
                namesList.add("Veena Malik");
                namesList.add("Yumna Zaidi");
                namesList.add("Waheed Murad");
                namesList.add("Waqar Zaka");
                namesList.add("Waseem Abbas");
                namesList.add("Yasir Hussain");
                namesList.add("Yousuf Khan");
                namesList.add("Zainub Qayyum");
                namesList.add("Zara Noor Abbas");
                namesList.add("Zara Sheikh[");
                namesList.add("Zeba");
                namesList.add("Zeba Ali");
                namesList.add("Shaheen Bano");
                namesList.add("Zhalay Sarhadi");
                namesList.add("Zarnish Khan");
                namesList.add("Zain Afzal");
                namesList.add("Zia Mohyeddin");
                namesList.add("Zuhab Khan");

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
            case "Pakistani Dramas":
                namesList = new ArrayList<>();

                namesList.add("Dil Lagi");
                namesList.add("Sange Mar Mar");
                namesList.add("Alif Allah Aur Insaan");
                namesList.add("Pyarey Afzal");
                namesList.add("Aisi Hai Tanhai");
                namesList.add("Humsafar");
                namesList.add("Zindagi Gulzar Hai");
                namesList.add("Shehr-e-Zaat");
                namesList.add("Meri Zaat Zarrae Benishan");
                namesList.add("Khuda Aur Mohabbat");
                namesList.add("Dastaan");
                namesList.add("Mann Mayal");
                namesList.add("Udaari");
                namesList.add("Sadqay Tumhare");
                namesList.add("Bin Roye");
                namesList.add("Bashar Momin");
                namesList.add("Aunn Zara");
                namesList.add("Mehndi");
                namesList.add("Daam");
                namesList.add("Laag");
                namesList.add("Alpha Bravo Charlie");
                namesList.add("Tum Kon Piya");
                namesList.add("Kuch Pyar Ka Pagalpan Bhi Tha");
                namesList.add("Qaid-e-Tanhai");
                namesList.add("Jackson Heights ");
                namesList.add("Mera Pehla Pyaar");
                namesList.add("Akbari Asghari");
                namesList.add("Doraha");
                namesList.add("Diyar-e-Dil");
                namesList.add("Suno Chanda");
                namesList.add("Baaghi");
                namesList.add("Khamoshi");
                namesList.add("Baydardi");
                namesList.add("Haiwan");
                namesList.add("Khaani");
                namesList.add("Khasara");
                namesList.add("Inkaar");
                namesList.add("Ehd-e-Wafa");
                namesList.add("Tajdeed e Wafa");
                namesList.add("Do Bol");
                namesList.add("Dil Mom Ka Diya");
                namesList.add("Woh Mera Dil Tha");
                namesList.add("Rasmeduniya");
                namesList.add("Ranjha Ranjha Kardi");
                namesList.add("Durr-e-shahwar");
                namesList.add("Cheekh");
                namesList.add("Gul-e-Rana");
                namesList.add("Munafiq");
                namesList.add("Pyare Afzal");
                namesList.add("Ramz-e-Ishq");
                namesList.add("Main Abdul Qadir Hoon");
                namesList.add("Kankar");
                namesList.add("Chup Raho");
                namesList.add("Meray Qatil Meray Dilbar");
                namesList.add("Raaz-e-Ulfat");
                namesList.add("Meray Pass Tum Ho");
                namesList.add("Alif");
                namesList.add("Mora Piya");
                namesList.add("Thakan");
                namesList.add("Maat");
                namesList.add("Ishq Gumshuda");
                namesList.add("Roag");
                namesList.add("Marasim");
                namesList.add("Azar Ki Ayegi Baraat");
                namesList.add("Ek Nazar Meri Taraf");
                namesList.add("Mera Saaein");
                namesList.add("Saat Pardon Main");
                namesList.add("Yakeen Ka Safar");
                namesList.add("Dil e Muztar");
                namesList.add("Musht e Khaak");
                namesList.add("Yeh Dil Mera");
                namesList.add("Jalan");
                namesList.add("Ishqiya");
                namesList.add("Asmano Pay Likha");
                namesList.add("Dil Kiya Karay");
                namesList.add("Parizaad");
                namesList.add("Ye Raha Dil");
                namesList.add("Sabaat");
                namesList.add("Chupke Chupke");
                namesList.add("Hum Kahan Ke Sachy Thay");
                namesList.add("Mushk");
                namesList.add("Raqs e Bismil");
                namesList.add("O Rangreza");
                namesList.add("Mehram");
                namesList.add("Pyar Ke Sadqay");
                namesList.add("Malaal-e-Yaar");
                namesList.add("Zara Yaad Kar");
                namesList.add("Aangan");
                namesList.add("Digest Writer");
                namesList.add("Alvida");
                namesList.add("Muhabbat Subh ka Sitara");

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
            case "Bollywood Celebrities":
                namesList = new ArrayList<>();

                namesList.add("Priyanka Chopra");
                namesList.add("Aamir Khan");
                namesList.add("Aditya Roy Kapur");
                namesList.add("Ajay Devgn");
                namesList.add("Akhsgay Kumar");
                namesList.add("Amit Sadh");
                namesList.add("Amitabh Bachan");
                namesList.add("Anil Kapoor");
                namesList.add("Arjun Kapoor");
                namesList.add("Arjun Rampal");
                namesList.add("Aditi Rao Hyderi");
                namesList.add("Aishwarya Rai");
                namesList.add("Alia Bhatt");
                namesList.add("Amy Jackson");
                namesList.add("Anushka Sharma");
                namesList.add("Asin Thottumkal");
                namesList.add("Chitraganda Singh");
                namesList.add("Deepika Padukone");
                namesList.add("Diana Penty");
                namesList.add("Amrish Puri");
                namesList.add("Nana Patekar");
                namesList.add("Shah Rukh Khan");
                namesList.add("Mithun Chakraborty");
                namesList.add("Rajinikanth");
                namesList.add("Govinda");
                namesList.add("Boman Irani");
                namesList.add("Hrithik Roshan");
                namesList.add("Johny Lever");
                namesList.add("Shatrughan Sinha");
                namesList.add("Shakti Kapoor");
                namesList.add("Nawazuddin Siddiqui");
                namesList.add("Kishore Kumar");
                namesList.add("Shahid Kapoor");
                namesList.add("Ranbir Kapoor");
                namesList.add("Salman Khan");
                namesList.add("Rajpal Naurang Yadav");
                namesList.add("Saif Ali Khan");
                namesList.add("Arshad Warsi");
                namesList.add("Suniel Shetty");
                namesList.add("Ranveer Singh");
                namesList.add("Abhishek Bachchan");
                namesList.add("Riteish Deshmukh");
                namesList.add("Shekhar Suman");
                namesList.add("Rakesh Roshan");
                namesList.add("Vidya Balan");
                namesList.add("Kangana Ranaut");
                namesList.add("Kareena Kapoor");
                namesList.add("Rani Mukerji");
                namesList.add("Sonam Kapoor");
                namesList.add("Lara Dutta");
                namesList.add("Konkona Sen Sharma");
                namesList.add("Sameera Reddy");
                namesList.add("Katrina Kaif");
                namesList.add("Bipasha Basu");
                namesList.add("Esha Gupta");
                namesList.add("Jacqueline Fernandez");
                namesList.add("Amrita Rao");
                namesList.add("Ayesha Takia");
                namesList.add("Dia Mirza");
                namesList.add("Sonakshi Sinha");
                namesList.add("Shraddha Kapoor");
                namesList.add("Nargis Fakhri");
                namesList.add("Shriya Pilgaonkar");
                namesList.add("Mallika Sherawat");
                namesList.add("Parineeti Chopra");
                namesList.add("Yami Gautam");
                namesList.add("Neha Dhupia");
                namesList.add("Disha Patani");
                namesList.add("Huma Qureshi");
                namesList.add("Minissha Lamba");
                namesList.add("Kajal Aggarwal");
                namesList.add("Ileana D'Cruz");
                namesList.add("Kim Sharma");
                namesList.add("Riya Sen");
                namesList.add("Isha Koppikar");
                namesList.add("Shriya Saran");
                namesList.add("Aarti Chhabria");
                namesList.add("Genelia D'Souza");
                namesList.add("Celina Jaitly");
                namesList.add("Kriti Sanon");
                namesList.add("Ameesha Patel");
                namesList.add("sha Deol");
                namesList.add("Daisy Shah");
                namesList.add("Amrita Arora");
                namesList.add("Vaani Kapoor");
                namesList.add("Nushrratt Bharuccha");
                namesList.add("Sonnalli Seygall");
                namesList.add("Sneha Ullal");
                namesList.add("Bhoomika Chawla");
                namesList.add("Lisa Haydon");
                namesList.add("Zareen Khan");
                namesList.add("Sana Khan");
                namesList.add("Shazahn Padamsee");
                namesList.add("Nimrat Kaur");
                namesList.add("Preeti Jhangiani");
                namesList.add("Radhika Apte");
                namesList.add("Anjana Sukhani");
                namesList.add("Mugdha Godse");
                namesList.add("Shruti Haasan");
                namesList.add("Anushka Shetty");
                namesList.add("Tamannaah Bhatia");
                namesList.add("Kalki Koechlin");
                namesList.add("Priyanka Bose");
                namesList.add("Sunny Leone");
                namesList.add("Dharmendra");
                namesList.add("Rishi Kapoor");
                namesList.add("Rajesh Khanna");
                namesList.add("Kunal Kapoor");
                namesList.add("Vivek Oberoi");
                namesList.add("Zayed Khan");
                namesList.add("Anil Kapoor");
                namesList.add("Arbaaz Khan");
                namesList.add("John Abraham");
                namesList.add("Prabhu Deva");
                namesList.add("Ayushmann Khurrana");
                namesList.add("Naseeruddin Shah");
                namesList.add("Varun Dhavan");
                namesList.add("Dissharth Malhothra");
                namesList.add("Sara Ali Khan");
                namesList.add("Kiara Advani");
                namesList.add("Tiger Shroff");
                namesList.add("Jacky Shroff");
                namesList.add("Madhuri Dixit");
                namesList.add("Shilpa Shetty");
                namesList.add("Kajol");
                namesList.add("Sonu Sood");
                namesList.add("Preeti Zinta");
                namesList.add("Raveen Tandon");
                namesList.add("Emraan Hashmi");
                namesList.add("Irrfan Khan");
                namesList.add("Karisma Kapoor");
                namesList.add("Tabu");
                namesList.add("Sushmita Sen");
                namesList.add("Vdyut Jammwal");
                namesList.add("Farhan Akhtar");
                namesList.add("Twinkle Khanna");
                namesList.add("Rajkummar Rao");
                namesList.add("Manoj Bajoayee");
                namesList.add("Suuny Deol");
                namesList.add("Sonali Bendre");
                namesList.add("Bobby Deol");
                namesList.add("Pankaj Tripati");
                namesList.add("Juhi Chawla");
                namesList.add("Paresh Rawal");
                namesList.add("Imran Khan");
                namesList.add("Pulkit Samrat");
                namesList.add("Rajesh Khanna");
                namesList.add("Hema Malini");
                namesList.add("Amjad Khan");
                namesList.add("Amol Palekar");
                namesList.add("Abhay Deol");
                namesList.add("Akshaye Khanna");
                namesList.add("Atul Kulkarni");
                namesList.add("Govardhan Asrani");
                namesList.add("Aruna Irani");
                namesList.add("Annu Kapoor");
                namesList.add("Adil Hussain");
                namesList.add("Anupam Kher");
                namesList.add("Amole Gupte");
                namesList.add("Balraj Sahni");
                namesList.add("Bharat Bhushan");
                namesList.add("Chiranjeevi");
                namesList.add("Darsheel Safary");
                namesList.add("Deepak Tijori");
                namesList.add("Dimple Kapadia");
                namesList.add("Dev Anand");
                namesList.add("Dilip Kumar");
                namesList.add("Farooq Shaikh");
                namesList.add("Feroz Khan");
                namesList.add("Farida Jalal");
                namesList.add("Guru Dutt");
                namesList.add("Gulshan Grover");
                namesList.add("Gurpreet Ghuggi");
                namesList.add("Jeetendra");
                namesList.add("Johny Lever");
                namesList.add("Kader Khan");
                namesList.add("Kay Kay Menon");
                namesList.add("Kapil Sharma");
                namesList.add("Karuna Bannerjee");
                namesList.add("Mukesh Tiwari");
                namesList.add("Mammootty");
                namesList.add("Madhavan");
                namesList.add("Manoj Joshi");
                namesList.add("Mohnish Bahl");
                namesList.add("Mukul Dev");
                namesList.add("Madhubala");
                namesList.add("Meena Kumari");
                namesList.add("Mala Sinha");
                namesList.add("Manoj Pahwa");
                namesList.add("Manoj Kumar");
                namesList.add("Nandita Das");
                namesList.add("Nargis");
                namesList.add("Nirupa Roy");
                namesList.add("Nutan");
                namesList.add("Om Puri");
                namesList.add("Prakash Raj");
                namesList.add("Rekha");
                namesList.add("Rajendra Kumar Tuli");
                namesList.add("Raaj Kumar");
                namesList.add("Raj Kapoor");
                namesList.add("Rakhee Gulzar");
                namesList.add("Randeep Hooda");
                namesList.add("Shabana Azmi");
                namesList.add("Shakti Kapoor");
                namesList.add("Sunil Dutt");
                namesList.add("Shashi Kapoor");
                namesList.add("Sharmila Tagore");
                namesList.add("Sridevi");
                namesList.add("Utpal Dutt");
                namesList.add("Vijay Raaz");
                namesList.add("Vikram Gokhale");
                namesList.add("Vinod Khanna");
                namesList.add("Vyjayanthimala");
                namesList.add("Waheeda Rehman");
                namesList.add("Zeenat Aman");
                namesList.add("Zohra Sehgal");
                namesList.add("Rajender Kumar");
                namesList.add("Shami Kapoor");
                namesList.add("Sanjeev Kumar");
                namesList.add("Kamal Haasan");
                namesList.add("Ashok Kumar");
                namesList.add("Pankaj Kapur");
                namesList.add("Saurabh Shukla");
                namesList.add("Sanjay Mishra");
                namesList.add("Prithviraj Kapoor");
                namesList.add("Danny Denzongpa");
                namesList.add("Prem Chopra");
                namesList.add("Raj Babbar");
                namesList.add("Jimmy Shergill");
                namesList.add("Vinay Pathak");
                namesList.add("Mukesh Khanna");
                namesList.add("Johnny Walker");
                namesList.add("Jaaved Jaaferi");

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
            case "Bollywood Movies":
                namesList = new ArrayList<>();

                namesList.add("Dilwale Dulhania Le Jayenge");
                namesList.add("Pyaasa");
                namesList.add("Insaf Ka Tarazu");
                namesList.add("Love Aaj Kal");
                namesList.add("Veer-Zaara");
                namesList.add("Mrs. Serial Killer");
                namesList.add("Fanaa");
                namesList.add("Panga =Pang");
                namesList.add("Panga ");
                namesList.add("Dil Chahta Hai");
                namesList.add("The Lunchbox");
                namesList.add("Lagaan");
                namesList.add("Sholay");
                namesList.add("Jab We Met");
                namesList.add("Queen");
                namesList.add("Barfi");
                namesList.add("Zindagi Na Milegi Dobara");
                namesList.add("Jodhaa Akbar");
                namesList.add("Mary Kom");
                namesList.add("Haider");
                namesList.add("Kabhi Khushi Kabhie Gham");
                namesList.add("Khoobsurat");
                namesList.add("3 Idiots");
                namesList.add("Ek Tha Tiger");
                namesList.add("Devdas");
                namesList.add("Hichki");
                namesList.add("Main Prem Ki Diwani Hoon");
                namesList.add("Neerja");
                namesList.add("Bajirao Mastani");
                namesList.add("Dhoom 2");
                namesList.add("Ek Ladki Ko Dekha Toh Aisa Laga");
                namesList.add("Bodyguard");
                namesList.add("The White Tiger");
                namesList.add("Saina");
                namesList.add("Thapped");
                namesList.add("Bobby");
                namesList.add("Hum Aapke Hain Koun");
                namesList.add("Yeh Jawaani Hai Deewani");
                namesList.add("Umrao Jaan");
                namesList.add("Swades");
                namesList.add("Salaam Bombay");
                namesList.add("Gully Boy");
                namesList.add("Lage Raho Munna Bhai");
                namesList.add("Ardh Satya");
                namesList.add("Hera Pheri");
                namesList.add("Bhaag Milkha Bhaag");
                namesList.add("Dhobi Ghat");
                namesList.add("Kati Patang");
                namesList.add("Black Friday");
                namesList.add("Gangs of Wasseypur");
                namesList.add("Arth");
                namesList.add("Kahaani");
                namesList.add("Dabangg");
                namesList.add("Black");
                namesList.add("Bandit Queen");
                namesList.add("Kabhie Kabhie");
                namesList.add("Udaan");
                namesList.add("Zubeidaa");
                namesList.add("Teesri Kasam");
                namesList.add("Naseeb");
                namesList.add("Zanjeer");
                namesList.add("Omkara");
                namesList.add("Chhoti Si Baat");
                namesList.add("Jewel Thief");
                namesList.add("Madhumati");
                namesList.add("Chandni");
                namesList.add("Jagte Raho");
                namesList.add("Secret Superstar");
                namesList.add("Sharmeelee");
                namesList.add("Parineeta");
                namesList.add("Lootera");
                namesList.add("Hum Hain Rahi Pyar Ke");
                namesList.add("Garam Hawa");
                namesList.add("Mr & Mrs ’55");
                namesList.add("Aiyyaa");
                namesList.add("Satyam Shivam Sundaram");
                namesList.add("Baahubali");
                namesList.add("Sahib Bibi Aur Ghulam");
                namesList.add("Tezaab");
                namesList.add("Sangam");
                namesList.add("Rockstar");
                namesList.add("Main Hoon Na");
                namesList.add("Mera Naam Joker");
                namesList.add("Kuch Kuch Hota Hai");
                namesList.add("Velu Nayakan");
                namesList.add("Parvarish");
                namesList.add("Maine Pyar Kiya");
                namesList.add("Khakee");
                namesList.add("Dil Se");
                namesList.add("Ghajini");
                namesList.add("Kaala Patthar");
                namesList.add("Chak De! India");
                namesList.add("Ankur");
                namesList.add("Gol Maal");
                namesList.add("Prem Rog");
                namesList.add("Silsila");
                namesList.add("Anand");
                namesList.add("Shaan");
                namesList.add("Parinda");
                namesList.add("Shree 420");
                namesList.add("Om Shanti Om");
                namesList.add("Dil To Pagal Hai");
                namesList.add("Awaara");
                namesList.add("Andaz Apna Apna");
                namesList.add("Satya");
                namesList.add("Mr India");
                namesList.add("Bombay");
                namesList.add("Kaagaz Ke Phool");
                namesList.add("Deewaar");
                namesList.add("Mughal-e-Azam");
                namesList.add("Pink");
                namesList.add("Udta Punjab");
                namesList.add("Talvar");
                namesList.add("Runway 34");
                namesList.add("Gangubai Kathiawadi");
                namesList.add("83");
                namesList.add("Mughal-e-Azam");
                namesList.add("Shershaah");
                namesList.add("Dangal");
                namesList.add("Special 26");
                namesList.add("Sarfarosh");
                namesList.add("PK");
                namesList.add("Bajrangi Bhaijaan");
                namesList.add("Baby");
                namesList.add("Kal Ho Naa Ho");
                namesList.add("My Name Is Khan");
                namesList.add("Don");
                namesList.add("Badla");
                namesList.add("Raazi");
                namesList.add("Band Baaja Baaraat");
                namesList.add("Ishqiya");
                namesList.add("Vicky Donor");
                namesList.add("English Vinglish");
                namesList.add("Highway");
                namesList.add("Piku");
                namesList.add("Dum Laga Ke Haisha");
                namesList.add("Kapoor & Sons");
                namesList.add("Newton");
                namesList.add("Article 15");
                namesList.add("Badhaai Ho");
                namesList.add("Dil");
                namesList.add("Ghayal");
                namesList.add("Baazi");
                namesList.add("Dil Hai Ke Manta Nahin");
                namesList.add("Akele Hum Akele Tum");
                namesList.add("Hum Dil De Chuke Sanam");
                namesList.add("Agneepath");
                namesList.add("Saajan");
                namesList.add("Khiladi");
                namesList.add("Duplicate");
                namesList.add("Hum Saath-Saath Hain");
                namesList.add("Judwaa");
                namesList.add("Hum Hain Khalnayak");
                namesList.add("Kabhi Haan Kabhi Naa");
                namesList.add("Pyaar Kiya To Darna Kya");
                namesList.add("Raja Hindustani");
                namesList.add("Darr");
                namesList.add("Khuda Gawah");
                namesList.add("Rangeela");
                namesList.add("Judaai");
                namesList.add("Biwi No. 1");
                namesList.add("Jaanwar");
                namesList.add("Ishq");
                namesList.add("Karun Arjun");
                namesList.add("Jo jeeta eohi Sikandar");
                namesList.add("Pades");
                namesList.add("Hero No. 1");
                namesList.add("Ghulam");
                namesList.add("Khalnayak");
                namesList.add("Border");
                namesList.add("Jeet");
                namesList.add("Gumrah");
                namesList.add("Baadshah");
                namesList.add("Coolie No. 1");
                namesList.add("Koyla");
                namesList.add("Haseena Maan Jaayegi");
                namesList.add("Aashiqui");
                namesList.add("Kaun");
                namesList.add("Raja Babu");
                namesList.add("Yes Boss");
                namesList.add("Mujhse Dosti Karoge");
                namesList.add("Koi… Mil Gaya");
                namesList.add("Mohabbatein");
                namesList.add("Rang De Basanti");
                namesList.add("Munna Bhai M.B.B.S.");
                namesList.add("Hera Pheri");
                namesList.add("Baghban");
                namesList.add("Rajneeti");
                namesList.add("7 Khoon Maaf");
                namesList.add("Bhootnath");
                namesList.add("Chalte Chalte");
                namesList.add("Mujhse Shaadi Karogi");
                namesList.add("Namastey London");
                namesList.add("Fashion");
                namesList.add("Wanted");
                namesList.add("Race");
                namesList.add("No Entry");
                namesList.add("Raaz");
                namesList.add("Dhamaal");
                namesList.add("Dhol");
                namesList.add("Bhool Bhulaiyaa");
                namesList.add("Rab Ne Bana Di Jodi");
                namesList.add("Welcome");
                namesList.add("Delhi Belly");
                namesList.add("Padmaavat");
                namesList.add("Madras Cafe");
                namesList.add("Rockstar");
                namesList.add("Badlapur");
                namesList.add("Aankhon Dekhi");
                namesList.add("Titli");
                namesList.add("Ugly");
                namesList.add("Fugly");
                namesList.add("Fukrey");

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
            case "Indian Songs":
                namesList = new ArrayList<>();

                namesList.add("Pyar Kiya To Darna Kya");
                namesList.add("Honton Mein Aisi Baat Main");
                namesList.add("Piya Tu Ab To Aaja");
                namesList.add("Ke Pag Ghungaroo Baandh");
                namesList.add("I Am A Disco Dancer");
                namesList.add("Humko Aaj Kal Hai Intezaar");
                namesList.add("Ankhiyan Milaoon Kabhi Ankhiya");
                namesList.add("Yaara O Yaara Milna Hamara");
                namesList.add("Kisi Disco Mein Jaayen Kisi Hotel");
                namesList.add("Dola Re Dola");
                namesList.add("Khaike Paan Banaraswala");
                namesList.add("Aaja Nachle");
                namesList.add("Ghahra");
                namesList.add("Prem Ratan Dhan Payo");
                namesList.add("Pinga");
                namesList.add("Joote De Do Paise Le Lo");
                namesList.add("Chote Chote Bhaiyon Ke");
                namesList.add("Wah Wah Ramji");
                namesList.add("Sajan Tumse Pyar");
                namesList.add("Tere Dware Pe Aayi Baraat");
                namesList.add("Hamari Shaadi Mein");
                namesList.add("Tenu Leke");
                namesList.add("Genda Phool");
                namesList.add("Sadi Gali");
                namesList.add("London Thumakda");
                namesList.add("Dheere Dheere Se Meri Zindagi Mein Aana");
                namesList.add("Nazar Ke Samne Jigar Ke Paas");
                namesList.add("Dil Ka Aalam");
                namesList.add("Mujhe Neend Na Aaye");
                namesList.add("Tumhe Apna Banane Ki Kasam");
                namesList.add("Dil Hai Ke Manta Nahin");
                namesList.add("Adayein Bhi Hain");
                namesList.add("Dekha Teri Mast Nigahon Mein");
                namesList.add("O Lal Dupatte Wali");
                namesList.add("Ye Kaali Kaali Aankhen");
                namesList.add("Dil Mera Churaya Kyun");
                namesList.add("Ae Ajnabi");
                namesList.add("Pehli Pehli Baar Mohabbat Ki Hai");
                namesList.add("Mohabat Ki jhooti Kahani");
                namesList.add("Ajeeb Dastan Hai Yeh");
                namesList.add("O Mere Sanam");
                namesList.add("Gulabi Ankhen Jo Teri");
                namesList.add("Chura Liya Hai Tumne Jo Dil Ko");
                namesList.add("Neele Neele Ambar Par");
                namesList.add("Pehla Nasha");
                namesList.add("Mere Rang Mein Rangne Wali");
                namesList.add("Kabootar Ja Ja Ja");
                namesList.add("Dil Deewana");
                namesList.add("Tere Dard Se Dil");
                namesList.add("Tera Jaana");
                namesList.add("Dil Jab Se Toot Gaya");
                namesList.add("Maiyya Yashoda");
                namesList.add("Tum Dil Ki Dhadkan Mein");
                namesList.add("Hum To Dil Se Haare");
                namesList.add("Silsila Ye Chaahat Ka");
                namesList.add("Ankh Hai Bhari Bhari");
                namesList.add("Jaadu Hai Nasha Hai");
                namesList.add("Kasam Ki Kasam");
                namesList.add("Mujhe Haq Hai");
                namesList.add("Do Anjaane Ajnabi");
                namesList.add("Milan Abhi Aadha Adhura");
                namesList.add("Lahu Munh Lag Gaya");
                namesList.add("Laal Ishq");
                namesList.add("Galliyan");
                namesList.add("Jeeta Tha Jiske Liye");
                namesList.add("Jaadu Teri Nazar");
                namesList.add("Mera Dil Bhi Kitna Paagal Hai");
                namesList.add("Bahut Pyaar Karte Hai");
                namesList.add("Aitbaar Nahi Karna");
                namesList.add("Lag Ja Gale");
                namesList.add("Tum Hi Ho");
                namesList.add("Soch Na Sake");
                namesList.add("Sab Tera");
                namesList.add("Humsafar");
                namesList.add("Dilli Wali Girlfriend");
                namesList.add("Aaj Ki Party");
                namesList.add("Afgan Jalebi");
                namesList.add("Selfie Le Le Re");
                namesList.add("Nachan Farrate");
                namesList.add("Chaar Shanivaar");
                namesList.add("Dil Cheez Tujhe Dedi");
                namesList.add("Akkad Bakkad");
                namesList.add("Humne Pee Rakhi Hai");
                namesList.add("Ki Kariye Nachna Aaonda Nahin");
                namesList.add("High Heel Te Nachche");
                namesList.add("Cheez Badi");
                namesList.add("Lift Teri Bandh Hai");
                namesList.add("Main Tera Boyfriend");
                namesList.add("Badri Ki Dulhania");
                namesList.add("Suit Suit");
                namesList.add("Butterfly");
                namesList.add("Nachange Saari Raat");
                namesList.add("Tujhse Naraaz Nahi");
                namesList.add("Tere Bina Zindagi se Koi");
                namesList.add("Kun Faya Kun");
                namesList.add("Pal Pal Dil Ke Paas");
                namesList.add("Kisi ki Muskurahaton Pe Ho Nisar");
                namesList.add("Main Kabhi Batlata Nahi (Maa)");
                namesList.add("Taal Se Taal");
                namesList.add("Badan Pe Sitare");
                namesList.add("Hum Tum Ek Kamre Mein Band Ho");
                namesList.add("Dheere Dheere Se Meri Zindagi Mein Aana");
                namesList.add("O haseena Zulfo Waali");
                namesList.add("Iktara");
                namesList.add("Choli Ke Peeche");
                namesList.add("Chhaiya Chhaiya");
                namesList.add("Aaj Phir Jeene Ki Tamanna Hai");
                namesList.add("Hoshwalon Ko Khabar Kya");
                namesList.add("Tujhe Dekha Toh Ye Jaana Sanam");
                namesList.add("Baahon ke Darmiya");
                namesList.add("Pehli Nazar Mein");
                namesList.add("Tere Liye");
                namesList.add("Aankhon Mein Teri");
                namesList.add("Yeh Dosti Hum Nahi Todenge");
                namesList.add("Kajra Re");
                namesList.add("Tip Tip Barsa Pani");
                namesList.add("Sandese Aate Hai");
                namesList.add("Baharon Phool Barsao");
                namesList.add("Pyar Hua Iqrar Hua");
                namesList.add("Munni Badnaam");
                namesList.add("Bole Chudiyan");
                namesList.add("Dum Maro Dum");
                namesList.add("Didi Tera Devar Deewana");
                namesList.add("Roop Tera Mastana");
                namesList.add("Ude Jab Jab Zulfein Teri");
                namesList.add("Chahe Koi Mujhe Junglee Kahe");
                namesList.add("Dekha Hai Pehli Baar");
                namesList.add("Beedi");
                namesList.add("Babuji Dheere Chalna");
                namesList.add("Jumma Chumma De De");
                namesList.add("Ek Do Teen");
                namesList.add("Piya Tu Ab To Aaja");
                namesList.add("Raja Ki Aayegi Baraat");
                namesList.add("Ankhiyan Milake");
                namesList.add("Pe Loon");
                namesList.add("Khaabon Ke Parinday");
                namesList.add("Dl To Bachcha Hai Ji");
                namesList.add("Tere Mast Mast Do Nain");
                namesList.add("Chaar Kadam");
                namesList.add("Andha Ishq");
                namesList.add("Dil Meri Na Sune");
                namesList.add("Toota Jo Kabhi Tara");
                namesList.add("Mujhe Chaand Pe Le Chalo");
                namesList.add("Nazar Na Lag Jaaye");
                namesList.add("Cham Cham");
                namesList.add("Bol Do Na Zara");
                namesList.add("Hum Mar Jayenge");
                namesList.add("Sun Le Sada");
                namesList.add("Dhoonde Akhiyaan");
                namesList.add("Kala Chashma");
                namesList.add("Saanson Ko Saanson Mein");
                namesList.add("Aankh Marey");
                namesList.add("Swag Se Swagat");
                namesList.add("Tum Dil Ki Dhadkan Mein");
                namesList.add("Badtameez Dil");
                namesList.add("Kar Gayi Chull");
                namesList.add("Kamli");
                namesList.add("Ram Chahe Leela");
                namesList.add("Sheila Ki Jawaani");
                namesList.add("Chittiyan Kalaiyaan");
                namesList.add("Malang");
                namesList.add("Abhi Toh Party Shuru Hui Hai");
                namesList.add("Paani Wala Dance");
                namesList.add("Bang Bang");
                namesList.add("Char Baj Gaye Party Abhi Baki Hai");
                namesList.add("Chammak Challo");
                namesList.add("Chikni Chameli");
                namesList.add("Nashe Si Chadh Gayi");
                namesList.add("Lungi Dance");
                namesList.add("Bheegey Hont");
                namesList.add("Mashallah Mashallah");
                namesList.add("Desi Girl");
                namesList.add("Gandi Baat");
                namesList.add("Dhink Chika");
                namesList.add("Humko Humise Churalo");
                namesList.add("Fevicol Se");
                namesList.add("Tune Mari Entriyan");
                namesList.add("Jhalak Dikhlaja");
                namesList.add("Mauja hi Mauja");
                namesList.add("Tamanche Pe Disco");
                namesList.add("Dhoom Machale Dhoom");
                namesList.add("Mauja hi Mauja");
                namesList.add("Whistle Baja");
                namesList.add("Kheech Meri Photo");
                namesList.add("Do Peg Maar");
                namesList.add("Hookah Bar");
                namesList.add("Second Hand Jawaani");

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
            case "Famous People":
                namesList = new ArrayList<>();

                namesList.add("Jesus");
                namesList.add("Napoleon");
                namesList.add("Muhammad");
                namesList.add("William Shakespeare");
                namesList.add("Abraham Lincoln");
                namesList.add("George Washington");
                namesList.add("Adolf Hitler");
                namesList.add("Aristotle");
                namesList.add("Alexander the Great");
                namesList.add("Thomas Jefferson");
                namesList.add("Henry VIII");
                namesList.add("Charles Darwin");
                namesList.add("Elizabeth I");
                namesList.add("Karl Marx");
                namesList.add("Julius Caesar");
                namesList.add("Queen Victoria");
                namesList.add("Martin Luther");
                namesList.add("Joseph Stalin");
                namesList.add("Albert Einstein");
                namesList.add("Christopher Columbus");
                namesList.add("Isaac Newton");
                namesList.add("Charlemagne");
                namesList.add("Theodore Roosevelt");
                namesList.add("Wolfgang Amadeus Mozart");
                namesList.add("Plato");
                namesList.add("Louis XIV");
                namesList.add("Ludwig van Beethoven");
                namesList.add("Ulysses S Grant");
                namesList.add("Leonardo da Vinci");
                namesList.add("Augustus");
                namesList.add("Michelangelo");
                namesList.add("Raphael");
                namesList.add("Rembrandt");
                namesList.add("Titian");
                namesList.add("Francisco Goya");
                namesList.add("El Greco");
                namesList.add("Albrecht Dürer");
                namesList.add("Hans Holbein the Younger");
                namesList.add("Johannes Vermeer");
                namesList.add("Jacques-Louis David");
                namesList.add("Giotto");
                namesList.add("Diego Velázquez");
                namesList.add("Gustave Courbet");
                namesList.add("Hieronymus Bosch");
                namesList.add("Vincent van Gogh");
                namesList.add("Pablo Picasso");
                namesList.add("Claude Monet");
                namesList.add("Henri Matisse");
                namesList.add("Paul Cézanne");
                namesList.add("Edgar Degas");
                namesList.add("Andy Warhol");
                namesList.add("Paul Gauguin");
                namesList.add("Pierre-Auguste Renoir");
                namesList.add("Auguste Rodin");
                namesList.add("Wassily Kandinsky");
                namesList.add("Edouard Manet");
                namesList.add("Camille Pissarro");
                namesList.add("Diego Rivera");
                namesList.add("Edvard Munch");
                namesList.add("James McNeill Whistler");
                namesList.add("Jackson Pollock");
                namesList.add("Salvador Dalí");
                namesList.add("Piet Mondrian");
                namesList.add("Georgia O'Keeffe");
                namesList.add("Charles Dickens");
                namesList.add("Mark Twain");
                namesList.add("Edgar Allan Poe");
                namesList.add("Voltaire");
                namesList.add("Oscar Wilde");
                namesList.add("Johann Wolfgang von Goethe");
                namesList.add("Dante Alighieri");
                namesList.add("Lewis Carroll");
                namesList.add("Henry David Thoreau");
                namesList.add("Jane Austen");
                namesList.add("Samuel Johnson");
                namesList.add("Homer");
                namesList.add("Lord Byron");
                namesList.add("Walt Whitman");
                namesList.add("John Milton");
                namesList.add("Geoffrey Chaucer");
                namesList.add("Virgil");
                namesList.add("William Wordsworth");
                namesList.add("Stephen King");
                namesList.add("Emily Dickinson");
                namesList.add("Leo Tolstoy");
                namesList.add("Victor Hugo");
                namesList.add("George Bernard Shaw");
                namesList.add("Nathaniel Hawthorne");
                namesList.add("Fyodor Dostoyevsky");
                namesList.add("Miguel de Cervantes");
                namesList.add("Ernest Hemingway");
                namesList.add("HG Wells");
                namesList.add("Herman Melville");
                namesList.add("Rudyard Kipling");
                namesList.add("Sophocles");
                namesList.add("Samuel Taylor Coleridge");
                namesList.add("John Keats");
                namesList.add("Robert Burns");
                namesList.add("Petrarch");
                namesList.add("Percy Bysshe Shelley");
                namesList.add("George Orwell");
                namesList.add("Christopher Marlowe");
                namesList.add("Thomas Hardy");
                namesList.add("Aeschylus");
                namesList.add("Jonathan Swift");
                namesList.add("Rabindranath Tagore");
                namesList.add("Henrik Ibsen");
                namesList.add("James Joyce");
                namesList.add("Henry James");
                namesList.add("Aristophanes");
                namesList.add("Alexander Pushkin");
                namesList.add("Ben Jonson");
                namesList.add("TS Eliot");
                namesList.add("Carl Linnaeus");
                namesList.add("Ronald Reagan");
                namesList.add("Benjamin Franklin");
                namesList.add("George W. Bush");
                namesList.add("Winston Churchill");
                namesList.add("Genghis Khan");
                namesList.add("Charles I of England");
                namesList.add("Thomas Edison");
                namesList.add("Friedrich Nietzsche");
                namesList.add("Franklin D. Roosevelt");
                namesList.add("Sigmund Freud");
                namesList.add("Alexander Hamilton");
                namesList.add("Mohandas Karamchand Gandhi");
                namesList.add("Woodrow Wilson");
                namesList.add("Johann Sebastian Bach");
                namesList.add("Galileo Galilei");
                namesList.add("Oliver Cromwell");
                namesList.add("James Madison");
                namesList.add("Gautama Buddha");
                namesList.add("Edgar Allan Poe");
                namesList.add("Joseph Smith, Jr.");
                namesList.add("Adam Smith");
                namesList.add("Immanuel Kant");
                namesList.add("James Cook");
                namesList.add("John Adams");
                namesList.add("Richard Wagner");
                namesList.add("Pyotr Ilyich Tchaikovsky");
                namesList.add("Saint Peter");
                namesList.add("Andrew Jackson");
                namesList.add("Constantine the Great");
                namesList.add("Socrates");
                namesList.add("Elvis Presley");
                namesList.add("John F. Kennedy");
                namesList.add("Augustine of Hippo");
                namesList.add("Nicolaus Copernicus");
                namesList.add("Vladimir Lenin");
                namesList.add("Robert E. Lee");
                namesList.add("Cicero");
                namesList.add("Jean-Jacques Rousseau");
                namesList.add("Francis Bacon");
                namesList.add("Richard Nixon");
                namesList.add("King Arthur");
                namesList.add("Thomas Aquinas");
                namesList.add("René Descartes");
                namesList.add("Nikola Tesla");
                namesList.add("Harry S. Truman");
                namesList.add("Joan of Arc");
                namesList.add("Dante Alighieri");
                namesList.add("Otto von Bismarck");
                namesList.add("Grover Cleveland");
                namesList.add("John Calvin");
                namesList.add("John Locke");

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

            case "Pakistani Singers":
                namesList = new ArrayList<>();

                namesList.add("Nusrat Fateh Ali Khan");
                namesList.add("Atif Aslam");
                namesList.add("Adnan Sami");
                namesList.add("Adnan Sami");
                namesList.add("Nazia Hassan");
                namesList.add("Bohemia");
                namesList.add("Ali Zafar");
                namesList.add("Imran Abbas");
                namesList.add("Farhan Saeed");
                namesList.add("Imran Khan");
                namesList.add("Mehwish Hayat");
                namesList.add("K. L. Saigal");
                namesList.add("Attaullah Khan Esakhelvi");
                namesList.add("Mehdi Hassan");
                namesList.add("Abida Parveen");
                namesList.add("Abida Parveen");
                namesList.add("Nadia Ali");
                namesList.add("Ayesha Omer");
                namesList.add("Bushra Ansari");
                namesList.add("Mustafa Zahid");
                namesList.add("Shafqat Amanat Ali");
                namesList.add("Sajjad Ali");
                namesList.add("Ali Azmat");
                namesList.add("Annie Khalid");
                namesList.add("Arif Lohar");
                namesList.add("Ghazala Javed");
                namesList.add("Iqbal Bano");
                namesList.add("Tipu Sharif");
                namesList.add("Falak Shabir");
                namesList.add("Ahmed Ali Butt");
                namesList.add("Faraz haider");
                namesList.add("Alamgir");
                namesList.add("Abbas ali khan");
                namesList.add("Aaroh");
                namesList.add("Junoon");
                namesList.add("Mekaal Hasan Band");
                namesList.add("Noori");
                namesList.add("Talal Qureshi");
                namesList.add("Vital Signs");
                namesList.add("Zeb and Haniya");
                namesList.add("Aamir Zaki");
                namesList.add("Abrar-ul-Haq");
                namesList.add("Adil Omar");
                namesList.add("Ahmed Jahanzeb");
                namesList.add("Alam Lohar");
                namesList.add("Ali Haider");
                namesList.add("Shehzad Roy");
                namesList.add("Junaid Khan");
                namesList.add("Goher Mumtaz");
                namesList.add("Bilal Saeed");
                namesList.add("Bilal Khan");
                namesList.add("Fariha Pervez");
                namesList.add("Farrukh Fateh Ali Khan");
                namesList.add("Ghulam Ali");
                namesList.add("Gul Panra");
                namesList.add("Hadiqa Kiani");
                namesList.add("Haroon");
                namesList.add("Hasan Jahangir");
                namesList.add("Humera Arshad");
                namesList.add("Jawad Ahmad");
                namesList.add("Jawad Bashir");
                namesList.add("Jehangir Aziz Hayat");
                namesList.add("Komal Rizvi");
                namesList.add("Momina Mustehsan");
                namesList.add("Muhammad Asif Nakai");
                namesList.add("Najam Sheraz");
                namesList.add("Naseebo Lal");
                namesList.add("Naser Mestarihi");
                namesList.add("Nazia Iqbal");
                namesList.add("Zayn Malik");
                namesList.add("Zeek Afridi");
                namesList.add("Zohaib Hassan");
                namesList.add("Zeeshan Parwez (Sajid & Zeeshan)");
                namesList.add("Ali sethi");
                namesList.add("Ghulam Abbas");
                namesList.add("Yatagan (Fakhre Alam)");
                namesList.add("Waris Baig");
                namesList.add("Waqar Ali");
                namesList.add("Wajid Ali Nashad");
                namesList.add("Ustad Muhammad Juman");
                namesList.add("Taimur Rahman (Laal)");
                namesList.add("Shallum Asher Xavier (Fuzön)");
                namesList.add("Sain Zahoor");
                namesList.add("Shahram Azhar (Laal)");
                namesList.add("Ustad Amanat Ali Khan");
                namesList.add("Seher");
                namesList.add("Sarmad Sindhi");
                namesList.add("Sanam Marvi");
                namesList.add("Salman Ahmad");
                namesList.add("Salma Agha");
                namesList.add("Sajid Ghafoor (Sajid & Zeeshan)");
                namesList.add("Rajab Ali");
                namesList.add("Roxen");
                namesList.add("Reshma");
                namesList.add("Rahat Fateh Ali Khan");
                namesList.add("Rahim Shah");
                namesList.add("Rabi Pirzada");
                namesList.add("Rohail Hyatt");
                namesList.add("Pathanay Khan");
                namesList.add("Overload (Pakistani band)");
                namesList.add("Nayyara Noor");
                namesList.add("Nusrat Hussain");
                namesList.add("Nofel Izz");
                namesList.add("Nisar Bazmi");
                namesList.add("Niaz Ahmed");
                namesList.add("Naser Mestarihi");
                namesList.add("Naheed Akhtar");
                namesList.add("Mekaal Hasan");
                namesList.add("Meesha Shafi");
                namesList.add("Laal");
                namesList.add("Khawaja Khurshid Anwar");
                namesList.add("Karavan");
                namesList.add("JoSH");
                namesList.add("Jupiters");
                namesList.add("Junaid Khan");
                namesList.add("Jehangir Aziz Hayat");
                namesList.add("Jal");
                namesList.add("Jay Dittamo (Junoon)");
                namesList.add("Jawad Bashir (Dr. aur Billa)");
                namesList.add("Imran Momina (Fuzön)");
                namesList.add("Huma Khwaja");
                namesList.add("Hashim");
                namesList.add("Hasan Jahangir");
                namesList.add("Haider Rahman (Laal)");
                namesList.add("Ghulam Haider");
                namesList.add("Dhun");
                namesList.add("Faisal Kapadia (Strings)");
                namesList.add("Deeba Sahar");
                namesList.add("Danish Rahi");
                namesList.add("Billy-X");
                namesList.add("Brian O'Connell (Junoon)");
                namesList.add("Bilal Maqsood (Strings)");
                namesList.add("Benjamin Sisters");
                namesList.add("Awaz");
                namesList.add("Aziz Mian");
                namesList.add("Asif Sinan");
                namesList.add("Asad Amanat Ali Khan");
                namesList.add("Arshad Mehmood");
                namesList.add("Arieb Azhar");
                namesList.add("Ammar Hassan");
                namesList.add("Amjad Bobby");
                namesList.add("Amir Jamal");
                namesList.add("Amanat Ali");
                namesList.add("Allan Fakir");
                namesList.add("A Nayyar");
                namesList.add("Ali Gul Pir");
                namesList.add("Ali Alam");
                namesList.add("Ahmed Rushdi");
                namesList.add("Akash");
                namesList.add("Ahmed Ghulamali Chagla");
                namesList.add("Ahmed Mughal");
                namesList.add("Rafaqat Ali Khan");
                namesList.add("Sahir Ali Bagga");
                namesList.add("Abdullah Qureshi");
                namesList.add("Atish Raj");
                namesList.add("Ali Baba Khan");
                namesList.add("Aima Baig");
                namesList.add("Badnaam (band)");
                namesList.add("Bayaan");
                namesList.add("Esta Livio");
                namesList.add("Entity Paradigm");
                namesList.add("Farhad Humayun");
                namesList.add("Faakhir Mehmood");
                namesList.add("Farooq Haider");
                namesList.add("Ghulam Farid Sabri");
                namesList.add("Hamid Ali Khan");
                namesList.add("Irteassh");
                namesList.add("Kami Paul");
                namesList.add("Kashan Admani");
                namesList.add("Laila Khan");
                namesList.add("Leo Twins");
                namesList.add("Mala");
                namesList.add("Maqbool Ahmed Sabri");
                namesList.add("Masood Rana");
                namesList.add("Master Muhammad Ibrahim");
                namesList.add("Mohammad Aizaz Sohail");
                namesList.add("Mumtaz Ahmed");
                namesList.add("Mohammed Ali Shehki");
                namesList.add("Munni Begum");
                namesList.add("Nabeel Shaukat Ali");
                namesList.add("Naseer & Shahab");
                namesList.add("Naser Mestarihi");
                namesList.add("Natasha Khan");
                namesList.add("Nouman Javaid");
                namesList.add("Nusrat Hussain");
                namesList.add("Qurat-ul-Ain Balouch");
                namesList.add("Qayaas");
                namesList.add("Rangeela");
                namesList.add("Sabri Brothers");
                namesList.add("Syed Zaheer Rizvi");
                namesList.add("Sara Haider");
                namesList.add("Sara Raza Khan");
                namesList.add("Shahram Azhar ");
                namesList.add("Shiraz Uppal");
                namesList.add("Shani Arshad");
                namesList.add("Shuja Haider");
                namesList.add("Shamim Nazli");
                namesList.add("The Band Call");
                namesList.add("Ustad Muhammad Juman");
                namesList.add("Ustad Muhammad Yousuf");
                namesList.add("Umair Jaswal");
                namesList.add("Uzair Jaswal");
                namesList.add("Yasir Jaswal");
                namesList.add("Zoe Viccaji");
                namesList.add("Zulfiqar Jabbar Khan");
                namesList.add("Zayn Javadd Malik");
                namesList.add("Zubaida Khanum");

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

            case "Bollywood Singers":
                namesList = new ArrayList<>();

                namesList.add("Lata Mangeshkar");
                namesList.add("S. P. Balasubrahmanyam");
                namesList.add("Kishore Kumar");
                namesList.add("Shreya Ghoshal");
                namesList.add("Arijit Singh");
                namesList.add("Sonu Nigam");
                namesList.add("Neha Kakkar");
                namesList.add("Armaan Malik");
                namesList.add("Armaan Malik");
                namesList.add("Mohammed Rafi");
                namesList.add("Sunidhi Chauhan");
                namesList.add("Alka Yagnik");
                namesList.add("Kumar Sanu");
                namesList.add("Diljit Dosanjh");
                namesList.add("K. S. Chithra");
                namesList.add("Udit Narayan");
                namesList.add("Yo Yo Honey Singh");
                namesList.add("K. J. Yesudas");
                namesList.add("Sivakarthikeyan");
                namesList.add("Sid Sriram");
                namesList.add("Monali Thakur");
                namesList.add("Yuvan Shankar Raja");
                namesList.add("Shirley Setia");
                namesList.add("Shankar Mahadevan");
                namesList.add("Neeti Mohan");
                namesList.add("Vijay Antony");
                namesList.add("Kavya Madhavan");
                namesList.add("Adnan Sami");
                namesList.add("Jagjit Singh");
                namesList.add("M. S. Subbulakshmi");
                namesList.add("Palak Muchhal");
                namesList.add("Shaan");
                namesList.add("Krishnakumar Kunnath");
                namesList.add("Tulsi Kumar");
                namesList.add("Lucky Ali");
                namesList.add("Mukesh");
                namesList.add("Divine");
                namesList.add("Himesh Reshammiya");
                namesList.add("Anu Malik");
                namesList.add("S. Janaki");
                namesList.add("Anuradha Paudwal");
                namesList.add("Pritam Chakraborty");
                namesList.add("Usha Uthup");
                namesList.add("Badshah");
                namesList.add("Hariharan");
                namesList.add("Kavita Krishnamurthy");
                namesList.add("Daler Mehndi");
                namesList.add("Raftaar");
                namesList.add("Javed Ali");
                namesList.add("Falguni Pathak");
                namesList.add("Benny");
                namesList.add("Dinesh Lal Yadav");
                namesList.add("Kailash Kher");
                namesList.add("Sadhana Sargam");
                namesList.add("K. L. Saigal");
                namesList.add("Ankit Tiwari");
                namesList.add("Anusha Dandekar");
                namesList.add("Usha Mangeshkar");
                namesList.add("Manorama");
                namesList.add("Amit Kumar");
                namesList.add("Sukhwinder Singh");
                namesList.add("Abhijeet Bhattacharya");
                namesList.add("Vijay Prakash");
                namesList.add("Mika Singh");
                namesList.add("Suraiya");
                namesList.add("Vyjayanthimala");
                namesList.add("Zubeen Garg");
                namesList.add("Mithoon");
                namesList.add("Amrinder Gill");
                namesList.add("Kalabhavan Mani");
                namesList.add("Alisha Chinai");
                namesList.add("Anuradha Sriram");
                namesList.add("D. Imman");
                namesList.add("Gippy Grewal");
                namesList.add("Manoj Tiwari");
                namesList.add("Sunitha Upadrashta");
                namesList.add("Manna Dey");
                namesList.add("Neha Bhasin");
                namesList.add("Vijay Yesudas");
                namesList.add("Piyush Mishra");
                namesList.add("Mohammed Aziz");
                namesList.add("Mohit Chauhan");
                namesList.add("Ammy Virk");
                namesList.add("Nitin Mukesh");
                namesList.add("Harshdeep Kaur");
                namesList.add("Peter Sarstedt");
                namesList.add("Pankaj Udhas");
                namesList.add("Shweta Mohan");
                namesList.add("P. Susheela");
                namesList.add("Sona Mohapatra");
                namesList.add("Shalmali Kholgade");
                namesList.add("Miss Pooja");
                namesList.add("Rekha Bhardwaj");
                namesList.add("Jazzy B");
                namesList.add("Suresh Wadkar");
                namesList.add("Sandeep Acharya");
                namesList.add("Krish");
                namesList.add("Baba Sehgal");
                namesList.add("Geeta Dutt");
                namesList.add("Shweta Pandit");
                namesList.add("Mahendra Kapoor");
                namesList.add("Anushka Manchanda");
                namesList.add("Kunal Ganjawala");
                namesList.add("Shakthisree Gopalan");
                namesList.add("Begum Akhtar");
                namesList.add("M. Balamuralikrishna");
                namesList.add("Altaf Raja");
                namesList.add("Mamta Mohandas");
                namesList.add("M. G. Sreekumar");
                namesList.add("Bombay Jayashri");
                namesList.add("Bade Ghulam Ali Khan");
                namesList.add("Ila Arun");
                namesList.add("Antara Mitra");
                namesList.add("Satinder Sartaaj");
                namesList.add("Ganesh Hegde");
                namesList.add("Vinod Rathod");
                namesList.add("Gauhar Jaan");
                namesList.add("T. M. Soundararajan");
                namesList.add("Master Saleem");
                namesList.add("Malaysia Vasudevan");
                namesList.add("Shabbir Kumar");
                namesList.add("Suman Kalyanpur");
                namesList.add("Shamshad Begum");
                namesList.add("Shaan Rahman");
                namesList.add("Talat Mahmood");
                namesList.add("Kumar Gandharva");
                namesList.add("Hemlata");
                namesList.add("Hemant Kumar");
                namesList.add("Kuldeep Manak");
                namesList.add("Abhay Jodhpurkar");
                namesList.add("Suresh Peters");
                namesList.add("J. P. Chandrababu");
                namesList.add("Kavi Pradeep");
                namesList.add("Unni Menon");
                namesList.add("Siddharth Mahadevan");
                namesList.add("N. C. Karunya");
                namesList.add("Sharon Prabhakar");
                namesList.add("Manjari");
                namesList.add("Yugendran");
                namesList.add("Jasbir Jassi");
                namesList.add("Minmini");
                namesList.add("Raveendran");
                namesList.add("Sahana Bajpaie");
                namesList.add("Parthiv Gohil");
                namesList.add("Ananda Shankar");
                namesList.add("K. B. Sundarambal");
                namesList.add("Shubha Mudgal");
                namesList.add("Gangubai Hangal");
                namesList.add("C. Ramachandra");
                namesList.add("Prashant Tamang");
                namesList.add("Ishmeet Singh");
                namesList.add("Bhupinder Singh");
                namesList.add("Anil Biswas");
                namesList.add("Prashanthini");
                namesList.add("Akshaya Mohanty");
                namesList.add("Abdul Rashid Khan");
                namesList.add("Shobha Gurtu");
                namesList.add("M. Srisha");
                namesList.add("Aminuddin Dagar");
                namesList.add("Vinit Singh");
                namesList.add("Anne Hills");
                namesList.add("Esther Eden");
                namesList.add("A. R. Rahman");
                namesList.add("Jubin Nautiyal");
                namesList.add("Ayushmann Khurrana");
                namesList.add("Vinod Rathod");
                namesList.add("Darshan Raval");
                namesList.add("Vishal Dadlani");
                namesList.add("Papon");
                namesList.add("Mohammed Irfan Ali");
                namesList.add("Baabul Supriyo");
                namesList.add("B Praak");
                namesList.add("Benny Dayal");
                namesList.add("Alla Rakha");
                namesList.add("Nakash Aziz");
                namesList.add("Amit Trivedi");
                namesList.add("Bhimsen Joshi");
                namesList.add("Ali Akbar Khan");
                namesList.add("Sudesh Bhonsle");
                namesList.add("Rashid Khan");
                namesList.add("Roopkumar Rathod");
                namesList.add("Mahesh Kale");
                namesList.add("Omkarnath Thakur");
                namesList.add("Babbu Maan");
                namesList.add("Rahul Deshpande");
                namesList.add("Ravi Shankar");
                namesList.add("Pandit Jasraj");
                namesList.add("Ustad Abdul Karim Khan");
                namesList.add("Ustad Faiyaz Khan");
                namesList.add("Jayateerth Mevundi");
                namesList.add("Sanjeev Abhyankar");
                namesList.add("Aditya Narayan");
                namesList.add("Arko Pravo Mukherjee");
                namesList.add("Rabbi Shergil");
                namesList.add("D. V. Paluskar");
                namesList.add("Ajoy Chakrabarty");
                namesList.add("Amaal Mallik");
                namesList.add("Ulhas Kashalkar");
                namesList.add("Brodha V");
                namesList.add("Siddharth Mahadevan");
                namesList.add("Piyush Mishra");
                namesList.add("Rahul Vaidya");
                namesList.add("Rajesh Krishnan");
                namesList.add("Puttur Narasimha Nayak");

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

            case "Hollywood Singers":
                namesList = new ArrayList<>();

                namesList.add("Taylor Swift");
                namesList.add("Ariana Grande");
                namesList.add("Shawn Mendes");
                namesList.add("Selena Gomez");
                namesList.add("Ed Sheeran");
                namesList.add("Dua Lipa");
                namesList.add("Lady Gaga");
                namesList.add("Camila Cabello");
                namesList.add("The Weeknd");
                namesList.add("Beyonce");
                namesList.add("Bruno Mars");
                namesList.add("Halsey");
                namesList.add("Katy Perry");
                namesList.add("Justin Beiber");
                namesList.add("Post Malone");
                namesList.add("Khalid");
                namesList.add("Demi Lovato");
                namesList.add("Sia");
                namesList.add("Charlie Puth");
                namesList.add("Nick Jonas");
                namesList.add("Zayn Malik");
                namesList.add("John Legend");
                namesList.add("Sam Smith");
                namesList.add("Anne-Marie");
                namesList.add("Lizzo");
                namesList.add("Ava Max");
                namesList.add("Pink");
                namesList.add("Jenifer Lopez");
                namesList.add("Miley Cyrus");
                namesList.add("Sabrina Carpenter");
                namesList.add("Ellie Goulding");
                namesList.add("Nial Horan");
                namesList.add("Bebe Rexha");
                namesList.add("Christina Aguilera");
                namesList.add("Alicia Keys");
                namesList.add("Lana Del Rey");
                namesList.add("Jason Derulo");
                namesList.add("Alec Benjamin");
                namesList.add("Avril Lavigne");
                namesList.add("Normani");
                namesList.add("Brendon Urie");
                namesList.add("Charli XCX");
                namesList.add("Christina Perri");
                namesList.add("Chris Brown");
                namesList.add("Lauv");
                namesList.add("Carly Rae Jepsen");
                namesList.add("Swae Lee");
                namesList.add("Enrique Iglesias");
                namesList.add("Kylie Minogue");
                namesList.add("Luke Bryan");
                namesList.add("Miranda Lambert");
                namesList.add("Ty Dolla $ign");
                namesList.add("Lauren Jauregui");
                namesList.add("Tove Lo");
                namesList.add("Ella Mai");
                namesList.add("Kacey Musgraves");
                namesList.add("SZA");
                namesList.add("Tori Kelly");
                namesList.add("Bazzi");
                namesList.add("Mary J. Blige");
                namesList.add("Chris Stapleton");
                namesList.add("Maggie Rogers");
                namesList.add("Chester Bennington");
                namesList.add("6LACK");
                namesList.add("Jorja Smith");
                namesList.add("Daniel Caesar");
                namesList.add("Justin Moore");
                namesList.add("Summer Walker");
                namesList.add("Dierks Bentley");
                namesList.add("Kelly Rowland");
                namesList.add("Jared Leto");
                namesList.add("David Gilmour");
                namesList.add("Roger Waters");
                namesList.add("Axl Rose");
                namesList.add("Freddie Mercury");
                namesList.add("Daya");
                namesList.add("Sigrid");
                namesList.add("Kane Brown");
                namesList.add("Marren Morris");
                namesList.add("Luke Combs");
                namesList.add("Blake Shelton");
                namesList.add("Troye Sivan");
                namesList.add("Blackbear");
                namesList.add("Kelly Clarkson");
                namesList.add("Elvis Presley");
                namesList.add("Tyler Joseph");
                namesList.add("Shakira");
                namesList.add("J Balvin");
                namesList.add("Mabel");
                namesList.add("Chris Lane");
                namesList.add("Cheryl");
                namesList.add("Ciara");
                namesList.add("Ruel");
                namesList.add("Mike Shinoda");
                namesList.add("Harry Styles");
                namesList.add("Britney Spears");
                namesList.add("Adam Lambert");
                namesList.add("Luis Fonsi");
                namesList.add("Eminem");
                namesList.add("Billie Eilish");
                namesList.add("Rihanna");
                namesList.add("Jon Bon Jovi");
                namesList.add("Madonna");
                namesList.add("Jennifer Lopez");
                namesList.add("Nicki Minaj");
                namesList.add("Christina Perri");
                namesList.add("Justin Timberlake");
                namesList.add("Adele");
                namesList.add("Pitbull");
                namesList.add("Usher");
                namesList.add("Christina Grimmie");
                namesList.add("Steven Tyler");
                namesList.add("Michael Jackson");
                namesList.add("Akon");
                namesList.add("Ashley Tisdale");
                namesList.add("Vanessa Hudgens");
                namesList.add("Willow Smith");
                namesList.add("Jaden Smith");
                namesList.add("Snoop Dogg");
                namesList.add("Stevie Nicks");
                namesList.add("Joe Cocker");
                namesList.add("B.B. King");
                namesList.add("Patti LaBelle");
                namesList.add("Annie Lennox");
                namesList.add("Morrissey");
                namesList.add("Levon Helm");
                namesList.add("The Everly Brothers");
                namesList.add("Solomon Burke");
                namesList.add("Willie Nelson");
                namesList.add("Don Henley");
                namesList.add("Art Garfunkel");
                namesList.add("Sam Moore");
                namesList.add("Darlene Love");
                namesList.add("Patti Smith");
                namesList.add("Tom Waits");
                namesList.add("John Lee Hooker");
                namesList.add("Frankie Valli");
                namesList.add("Mariah Carey");
                namesList.add("Sly Stone");
                namesList.add("Merle Haggard");
                namesList.add("Steve Perry");
                namesList.add("Iggy Pop");
                namesList.add("James Taylor");
                namesList.add("Dolly Parton");
                namesList.add("John Fogerty");
                namesList.add("Toots Hibbert");
                namesList.add("Gregg Allman");
                namesList.add("Ronnie Spector");
                namesList.add("Wilson Pickett");
                namesList.add("Jerry Lee Lewis");
                namesList.add("Thom Yorke");
                namesList.add("David Ruffin");
                namesList.add("Dion");
                namesList.add("Lou Reed");
                namesList.add("Roger Daltrey");
                namesList.add("Björk");
                namesList.add("Rod Stewart");
                namesList.add("Eric Burdon");
                namesList.add("Mavis Staples");
                namesList.add("Paul Rodgers");
                namesList.add("Luther Vandross");
                namesList.add("Muddy Waters");
                namesList.add("Brian Wilson");
                namesList.add("Gladys Knight");
                namesList.add("Maren Morris");

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

