package com.example.charades.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
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
import com.example.charades.javaClass.AdPreferences;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;

public class CustomCategoryActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    EditText customListText;
    Button playBtn, backBtn;
    ImageView deleteBtn;
    String name;
    ListView listView;
    Integer isButtonClicked;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> customList;
    InterstitialAd mInterstitialAd;

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

        customList = new ArrayList<>();

        while (data.moveToNext()) {
            customList.add(data.getString(0));
        }

        isButtonClicked = AdPreferences.isButtonCLicked(CustomCategoryActivity.this);

        MobileAds.initialize(CustomCategoryActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        setAds();

        arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, customList);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder adb = new AlertDialog.Builder(CustomCategoryActivity.this);
                adb.setTitle("Delete List");
                adb.setMessage("Are you sure you want to delete all items?");
                adb.setIcon(android.R.drawable.ic_menu_delete);
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        databaseHelper.deleteAll();
                        customList.clear();
                        arrayAdapter.notifyDataSetChanged();
                        listView.setAdapter(arrayAdapter);
                    }
                });
                adb.show();
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isButtonClicked == 0) {
                    if (mInterstitialAd != null) {
                        isButtonClicked++;
                        mInterstitialAd.show((Activity) CustomCategoryActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                AdPreferences.setButtonCLicked(CustomCategoryActivity.this, isButtonClicked);
                                afterAdAction();
                            }

                            @Override
                            public void onAdClicked() {
                                super.onAdClicked();
                                AdPreferences.setAdOpened(CustomCategoryActivity.this, true);
                                afterAdAction();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                AdPreferences.setButtonCLicked(CustomCategoryActivity.this, isButtonClicked);
                                afterAdAction();
                            }
                        });
                    } else {
                        AdPreferences.setButtonCLicked(CustomCategoryActivity.this, isButtonClicked);
                        afterAdAction();
                    }
                } else if (isButtonClicked == 1) {
                    isButtonClicked--;
                    AdPreferences.setButtonCLicked(CustomCategoryActivity.this, isButtonClicked);
                    afterAdAction();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        customListText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String text = String.valueOf(customListText.getText()).trim();
                    if (!text.equals("")) {
                        customList.add(0, text);
                        customListText.setText("");
                        addData(customList.size() + ". " + text);
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

    public void afterAdAction() {
        ArrayList<String> list = new ArrayList<>();
        if (customList.size() > 30) {
            Intent intent = new Intent(CustomCategoryActivity.this, GameActivity.class);
            intent.putExtra("category", "Custom");
            Bundle bundle = new Bundle();
            for (String s: customList) {
                String[] removed = s.split("\\.");
                list.add(removed[1]);
            }
            bundle.putSerializable("test", list);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "PLease add up to 30 words to play.", Toast.LENGTH_SHORT).show();
        }
    }

    public void setAds() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(CustomCategoryActivity.this, getString(R.string.adUnitID), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
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