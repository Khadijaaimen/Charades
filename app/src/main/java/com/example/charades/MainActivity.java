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

        categoryNames.add("Celebrities");
//        categoryNames.add("Songs");
//        categoryNames.add("Impressions");
//        categoryNames.add("Movies");
//        categoryNames.add("Science");
//        categoryNames.add("Activities");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.categoryRv);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new CategoryAdapter(categoryNames, this);
        recyclerView.setAdapter(adapter);
    }
}