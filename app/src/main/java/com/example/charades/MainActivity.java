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
        categoryNames.add("Science");
        categoryNames.add("Activities");
        categoryNames.add("Animals");
        categoryNames.add("Sports");
        categoryNames.add("Jobs/Personalities");
        categoryNames.add("Musical Instruments");
        categoryNames.add("Emotions");
        categoryNames.add("TV Shows");
        categoryNames.add("Books");
        categoryNames.add("Miscellaneous Items");
        categoryNames.add("Gadgets");
        categoryNames.add("Pakistani Celebrities");
        categoryNames.add("Pakistani Dramas");
        categoryNames.add("Hollywood Celebrities");
        categoryNames.add("English Songs");
        categoryNames.add("Hollywood Movies");
        categoryNames.add("Bollywood Celebrities");
        categoryNames.add("Bollywood Movies");
        categoryNames.add("Indian Songs");
        categoryNames.add("Famous Places");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.categoryRv);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new CategoryAdapter(categoryNames, this);
        recyclerView.setAdapter(adapter);
    }
}