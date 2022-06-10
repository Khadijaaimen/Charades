package com.example.charades.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.charades.R;
import com.example.charades.adapter.CategoryAdapter;
import com.example.charades.helper.DatabaseHelper;
import com.example.charades.javaClass.AdPreferences;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final float END_SCALE = 0.7F;
    ArrayList<String> categoryNames = new ArrayList<>();
    ArrayList<Integer> categoryIcons = new ArrayList<>();
    CategoryAdapter adapter;
    ImageView imageView, navigationBar;
    TextView textView, won, lost, played, draw;
    Button ok;
    Animation topAnim, bottomAnim;
    DrawerLayout drawerLayout;
    LinearLayout contentView;
    NavigationView navigationView;
    Integer clickCount, wonCount, playedCount, lostCount, drawCount;
    Dialog dialog;
    DatabaseHelper databaseHelper;
    Cursor gamesLost, gamesWon, gamesPlayed, gamesDrawn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        navigationBar = findViewById(R.id.navBar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navView);
        contentView = findViewById(R.id.content);

        navigationDrawer();

        clickCount = AdPreferences.isButtonCLicked(MainActivity.this);
        if(clickCount == 2){
            AdPreferences.setButtonCLicked(MainActivity.this, 0);
        }

        categoryNames.add("Custom Category");
        categoryNames.add("Celebrities");
        categoryNames.add("Songs");
        categoryNames.add("Movies");
        categoryNames.add("TV Shows");
        categoryNames.add("Miscellaneous Items");
        categoryNames.add("Animals");
        categoryNames.add("Books");
        categoryNames.add("Science");
        categoryNames.add("Gadgets");
        categoryNames.add("Singers");
        categoryNames.add("Activities");
        categoryNames.add("Sports/Leisure Activities");
        categoryNames.add("Jobs/Personalities");
        categoryNames.add("Musical Instruments");
        categoryNames.add("Emotions");
        categoryNames.add("Famous People");
        categoryNames.add("Famous Places");
        categoryNames.add("Cars");
        categoryNames.add("Youtube Gamers");
        categoryNames.add("Makeup Items");
        categoryNames.add("Fruits");
        categoryNames.add("Body Parts");
        categoryNames.add("Tools");
        categoryNames.add("Disney Characters");
        categoryNames.add("Brands");
        categoryNames.add("Cricket Players");
        categoryNames.add("Football Players");

        categoryIcons.add(R.drawable.custom);
        categoryIcons.add(R.drawable.celebs);
        categoryIcons.add(R.drawable.music);
        categoryIcons.add(R.drawable.movies);
        categoryIcons.add(R.drawable.tv_shows);
        categoryIcons.add(R.drawable.miscellanous);
        categoryIcons.add(R.drawable.animals);
        categoryIcons.add(R.drawable.books);
        categoryIcons.add(R.drawable.science);
        categoryIcons.add(R.drawable.gadgets);
        categoryIcons.add(R.drawable.singers);
        categoryIcons.add(R.drawable.activities);
        categoryIcons.add(R.drawable.sports);
        categoryIcons.add(R.drawable.jobs);
        categoryIcons.add(R.drawable.instruments);
        categoryIcons.add(R.drawable.emotions);
        categoryIcons.add(R.drawable.famous_people);
        categoryIcons.add(R.drawable.famous_places);
        categoryIcons.add(R.drawable.cars);
        categoryIcons.add(R.drawable.youtube_gamers);
        categoryIcons.add(R.drawable.makeup);
        categoryIcons.add(R.drawable.fruits);
        categoryIcons.add(R.drawable.body_parts);
        categoryIcons.add(R.drawable.tools);
        categoryIcons.add(R.drawable.disney);
        categoryIcons.add(R.drawable.brands);
        categoryIcons.add(R.drawable.cricket);
        categoryIcons.add(R.drawable.football);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.categoryRv);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        adapter = new CategoryAdapter(categoryNames, categoryIcons, this);
        recyclerView.setAdapter(adapter);

        imageView = findViewById(R.id.logo);
        textView = findViewById(R.id.guess_word);

        textView.setAnimation(topAnim);
        imageView.setAnimation(topAnim);
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home);

        navigationBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.teal_200));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                final float diffScaleOffSet = slideOffset * (1 - END_SCALE);
                final float offSetScale = 1 - diffScaleOffSet;

                contentView.setScaleX(offSetScale);
                contentView.setScaleY(offSetScale);

                final float xOffset = drawerLayout.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaleOffSet / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);


            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Exit App")
                    .setCancelable(true)
                    .setMessage("Are you sure you want to exit?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AdPreferences.setButtonCLicked(getApplication(), 0);
                            AdPreferences.setAdOpened(getApplication(), false);
                            MainActivity.this.finish();
                            finishAffinity();
                        }

                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.settings:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.history:
                dialog = new Dialog(MainActivity.this, R.style.DialogStyle);
                dialog.setContentView(R.layout.history_popup_layout);

                dialog.getWindow().setBackgroundDrawableResource(R.drawable.white_bg);

                ok = dialog.findViewById(R.id.okButton);
                won = dialog.findViewById(R.id.games_won);
                lost = dialog.findViewById(R.id.games_lost);
                played = dialog.findViewById(R.id.games_played);
                draw = dialog.findViewById(R.id.games_draw);

                databaseHelper = new DatabaseHelper(this);

                gamesLost = databaseHelper.getLost();
                gamesPlayed = databaseHelper.getPlayed();
                gamesWon = databaseHelper.getWon();
                gamesDrawn = databaseHelper.getDraw();

                if(gamesWon. moveToNext()){
                    wonCount = gamesWon.getInt(0);
                }

                if(gamesPlayed.moveToNext()){
                    playedCount = gamesPlayed.getInt(0);
                }

                if(gamesLost.moveToNext()){
                    lostCount = gamesLost.getInt(0);
                }

                if(gamesDrawn.moveToFirst()){
                    drawCount = gamesDrawn.getInt(0);
                }

                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });

                String s1 = String.valueOf(wonCount);
                String s2 = String.valueOf(lostCount);
                String s3 = String.valueOf(playedCount);
                String s4 = String.valueOf(drawCount);

                if (!s1.equals("null"))
                    won.setText(s1);
                else
                    won.setText("0");

                if (!s2.equals("null"))
                    lost.setText(s2);
                else
                    lost.setText("0");

                if (!s3.equals("null"))
                    played.setText(s3);
                else
                    played.setText("0");

                if (!s4.equals("null"))
                    draw.setText(s4);
                else
                    draw.setText("0");

                dialog.setCancelable(true);
                dialog.show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.instructions:
                startActivity(new Intent(MainActivity.this, InstructionsActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.rating:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.share:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        int isButtonClicked;
        isButtonClicked = AdPreferences.isButtonCLicked(this);
        if (isButtonClicked == 1)
            AdPreferences.setButtonCLicked(getApplication(), 0);
        else
            AdPreferences.setButtonCLicked(getApplication(), 1);
        AdPreferences.setAdOpened(getApplication(), false);
    }
}