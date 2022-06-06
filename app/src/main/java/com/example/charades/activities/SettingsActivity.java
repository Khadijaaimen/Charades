package com.example.charades.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.charades.R;
import com.example.charades.javaClass.AppPreferences;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class SettingsActivity extends AppCompatActivity {

    MaterialButtonToggleGroup toggleGroup;
    String timeSelected;
    ToggleButton bonusButton, soundButton;
    Button backbtn;
    Boolean isSoundSelected, isBonusSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toggleGroup = findViewById(R.id.toggleButtonGroup);
        bonusButton = findViewById(R.id.bonusButton);
        soundButton = findViewById(R.id.soundButton);
        backbtn = findViewById(R.id.back);

        timeSelected = AppPreferences.isButtonCLicked(getApplicationContext());
        isBonusSelected = AppPreferences.isBonusButtonCLicked(getApplicationContext());
        isSoundSelected = AppPreferences.isSoundButtonCLicked(getApplicationContext());

        switch (timeSelected) {
            case "60":
                toggleGroup.check(R.id.btnSixty);
                break;
            case "80":
                toggleGroup.check(R.id.btnEighty);
                break;
            case "120":
                toggleGroup.check(R.id.btnTwenty);
                break;
        }

        bonusButton.setChecked(isBonusSelected);

        soundButton.setChecked(isSoundSelected);

        toggleGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked) {
                    switch (checkedId) {
                        case R.id.btnSixty:
                            AppPreferences.setButtonCLicked(getApplicationContext(), "60");
                            toggleGroup.check(R.id.btnSixty);
                            break;
                        case R.id.btnEighty:
                            AppPreferences.setButtonCLicked(getApplicationContext(), "80");
                            toggleGroup.check(R.id.btnEighty);
                            break;
                        case R.id.btnTwenty:
                            AppPreferences.setButtonCLicked(getApplicationContext(), "120");
                            toggleGroup.check(R.id.btnTwenty);
                            break;

                    }
                }
            }
        });

        bonusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppPreferences.setBonusButtonCLicked(getApplicationContext(), !isBonusSelected);
            }
        });

        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppPreferences.setSoundButtonCLicked(getApplicationContext(), !isSoundSelected);
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
