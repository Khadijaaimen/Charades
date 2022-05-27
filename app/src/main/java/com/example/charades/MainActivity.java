package com.example.charades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> categoryNames = new ArrayList<>();
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryNames.add("Custom Category");
        categoryNames.add("Hollywood Celebrities");
        categoryNames.add("Hollywood Singers");
        categoryNames.add("Hollywood Movies");
        categoryNames.add("Miscellaneous Items");
        categoryNames.add("Animals");
        categoryNames.add("Books");
        categoryNames.add("Bollywood Celebrities");
        categoryNames.add("Bollywood Singers");
        categoryNames.add("Bollywood Movies");
        categoryNames.add("Science");
        categoryNames.add("Gadgets");
        categoryNames.add("Activities");
        categoryNames.add("Sports/Leisure Activities");
        categoryNames.add("Pakistani Celebrities");
        categoryNames.add("Pakistani Dramas");
        categoryNames.add("Pakistani Singers");
        categoryNames.add("Jobs/Personalities");
        categoryNames.add("Musical Instruments");
        categoryNames.add("Emotions");
        categoryNames.add("TV Shows");
        categoryNames.add("English Songs");
        categoryNames.add("Indian Songs");
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

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.categoryRv);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new CategoryAdapter(categoryNames, this);
        recyclerView.setAdapter(adapter);
    }
}