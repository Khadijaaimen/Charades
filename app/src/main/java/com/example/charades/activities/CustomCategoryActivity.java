package com.example.charades.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.charades.R;
import com.example.charades.helper.DatabaseHelper;

import java.util.ArrayList;

public class CustomCategoryActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText customListText;
    Button playBtn, backBtn;
    ImageView deleteBtn;
    String name;
    ListView listView;
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

        ArrayList<String> customList = new ArrayList<>();

        while (data.moveToNext()) {
            customList.add(data.getString(1));
            arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                    android.R.layout.simple_list_item_1, customList);
            listView.setAdapter(arrayAdapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                name = a.getItemAtPosition(position).toString();
                AlertDialog.Builder adb = new AlertDialog.Builder(CustomCategoryActivity.this);
                adb.setTitle("Delete Item");
                adb.setMessage("Are you sure you want to delete?");
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Cursor data = databaseHelper.getListContents();
                        int itemID = -1;
                        while (data.moveToNext()) {
                            itemID = data.getInt(0);
                            databaseHelper.deleteName(itemID, name);
                            arrayAdapter.remove(String.valueOf(positionToRemove));
                            customList.remove(positionToRemove);
                            arrayAdapter.notifyDataSetChanged();
                        }
                    }
                });
                adb.show();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteAll();
                customList.clear();
                arrayAdapter.notifyDataSetChanged();
                listView.setAdapter(arrayAdapter);
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomCategoryActivity.this, GameActivity.class);
                intent.putExtra("category", "Custom");
                Bundle bundle = new Bundle();
                bundle.putSerializable("test", customList);
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
                        customList.add(0, text);
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
        finish();
    }
}