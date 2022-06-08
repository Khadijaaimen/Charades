package com.example.charades.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.charades.R;
import com.example.charades.adapter.CategoryAdapter;
import com.example.charades.javaClass.AdPreferences;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final float END_SCALE = 0.7F;
    ArrayList<String> categoryNames = new ArrayList<>();
    ArrayList<Integer> categoryIcons = new ArrayList<>();
    CategoryAdapter adapter;
    ImageView imageView, navigationBar;
    TextView textView;
    Animation topAnim, bottomAnim;
    DrawerLayout drawerLayout;
    LinearLayout contentView;
    NavigationView navigationView;

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
        recyclerView.setHasFixedSize(true);
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
            super.onBackPressed();
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
            case R.id.instructions:
                startActivity(new Intent(MainActivity.this, InstructionsActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.rating:
                break;
            case R.id.share:
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