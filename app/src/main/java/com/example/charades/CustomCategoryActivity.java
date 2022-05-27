package com.example.charades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomCategoryActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText customListText;
    Button playBtn, backBtn;
    ImageView deleteBtn;
    ListView listView;
    ArrayList<String> customList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_category);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        customListText = findViewById(R.id.list);
        playBtn = findViewById(R.id.playButton);
        backBtn = findViewById(R.id.backButton);
        listView = findViewById(R.id.listview);
        deleteBtn = findViewById(R.id.deleteButton);

        databaseHelper = new DatabaseHelper(this);
        Cursor data = databaseHelper.getListContents();

        int count = data.getCount();
        if (count != 0) {
            while (data.moveToNext()){
                customList.add(data.getString(1));
                arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_list_item_1, customList);
                listView.setAdapter(arrayAdapter);
            }
        }


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customList.clear();
                customListText.setText("");
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomCategoryActivity.this, GameActivity.class);
                intent.putExtra("category", "Custom");
                Bundle bundle=new Bundle();
                bundle.putSerializable("test",customList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, customList);

        customListText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String text = String.valueOf(customListText.getText());
                    if (!text.equals("")) {
                        customList.add(text);
                        customListText.setText("");
                        addData(text);
                        listView.setAdapter(arrayAdapter);
                        arrayAdapter.notifyDataSetChanged();
                        handled = true;
                    } else {
                        Toast.makeText(getApplicationContext(), "Please Enter Data", Toast.LENGTH_SHORT).show();
                    }
                }
                return handled;
            }
        });
    }

    private void addData(String text) {
        databaseHelper.addData(text);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        startActivity(new Intent(CustomCategoryActivity.this, MainActivity.class));
    }
}