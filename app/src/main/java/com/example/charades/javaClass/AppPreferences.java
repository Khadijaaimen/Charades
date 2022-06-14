package com.example.charades.javaClass;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppPreferences {

    private static SharedPreferences mPrefs;
    private static SharedPreferences.Editor mPrefsEditor;

    public static String isButtonCLicked(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("timeSelected", "60");
    }

    public static void setButtonCLicked(Context ctx, String time) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("timeSelected", time);
        mPrefsEditor.commit();
    }

    public static Boolean isSoundButtonCLicked(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getBoolean("sound_clicked", true);
    }

    public static void setSoundButtonCLicked(Context ctx, Boolean value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putBoolean("sound_clicked", value);
        mPrefsEditor.commit();
    }

    public static Boolean isBonusButtonCLicked(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getBoolean("bonus_clicked", false);
    }

    public static void setBonusButtonCLicked(Context ctx, Boolean value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putBoolean("bonus_clicked", value);
        mPrefsEditor.commit();
    }

    public static String isPlayButtonCLicked(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("play_clicked", "0");
    }

    public static void setPlayButtonCLicked(Context ctx, String value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("play_clicked", value);
        mPrefsEditor.commit();
    }

    public static String isWonButtonCLicked(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("won_clicked", "0");
    }

    public static void setWonButtonCLicked(Context ctx, String value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("won_clicked", value);
        mPrefsEditor.commit();
    }

    public static String islostButtonCLicked(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("lost_clicked", "0");
    }

    public static void setLostButtonCLicked(Context ctx, String value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("lost_clicked", value);
        mPrefsEditor.commit();
    }

    public static String isDrawButtonCLicked(Context ctx) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return mPrefs.getString("draw_clicked", "0");
    }

    public static void seDrawButtonCLicked(Context ctx, String value) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        mPrefsEditor = mPrefs.edit();
        mPrefsEditor.putString("draw_clicked", value);
        mPrefsEditor.commit();
    }
}
