package com.example.charades.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charades.R;
import com.example.charades.adapter.CategoryAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> categoryNames = new ArrayList<>();
    ArrayList<Integer> categoryIcons = new ArrayList<>();
    CategoryAdapter adapter;
    ImageView imageView;
    TextView textView;
    Animation topAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        categoryNames.add("Custom Category");
        categoryNames.add("Hollywood Celebrities");
//        categoryNames.add("Hollywood Singers");
        categoryNames.add("Hollywood Movies");
//        categoryNames.add("Miscellaneous Items");
//        categoryNames.add("Animals");
//        categoryNames.add("Books");
//        categoryNames.add("Bollywood Celebrities");
//        categoryNames.add("Bollywood Singers");
//        categoryNames.add("Bollywood Movies");
//        categoryNames.add("Science");
//        categoryNames.add("Gadgets");
//        categoryNames.add("Activities");
//        categoryNames.add("Sports/Leisure Activities");
//        categoryNames.add("Pakistani Celebrities");
//        categoryNames.add("Pakistani Dramas");
//        categoryNames.add("Pakistani Singers");
//        categoryNames.add("Jobs/Personalities");
//        categoryNames.add("Musical Instruments");
//        categoryNames.add("Emotions");
//        categoryNames.add("TV Shows");
        categoryNames.add("English Songs");
//        categoryNames.add("Indian Songs");
//        categoryNames.add("Famous People");
//        categoryNames.add("Famous Places");
//        categoryNames.add("Cars");
//        categoryNames.add("Youtube Gamers");
//        categoryNames.add("Makeup Items");
//        categoryNames.add("Fruits");
//        categoryNames.add("Body Parts");
//        categoryNames.add("Tools");
//        categoryNames.add("Disney Characters");
//        categoryNames.add("Brands");
//        categoryNames.add("Cricket Players");
//        categoryNames.add("Football Players");

        categoryIcons.add(R.drawable.custom);
        categoryIcons.add(R.drawable.celebs);
        categoryIcons.add(R.drawable.movies);
        categoryIcons.add(R.drawable.music);

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.categoryRv);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new CategoryAdapter(categoryNames, categoryIcons, this);
        recyclerView.setAdapter(adapter);

        imageView = findViewById(R.id.logo);
        textView = findViewById(R.id.guess_word);

        textView.setAnimation(topAnim);
        imageView.setAnimation(topAnim);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setCancelable(true)
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                        finishAffinity();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}