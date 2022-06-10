package com.example.charades.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Category.db";
    public static final String TABLE_NAME = "custom_category";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "CATEGORY_LIST";
    public static final String COL_3 = "GAMES_WON";
    public static final String COL_4 = "GAMES_LOST";
    public static final String COL_5 = "GAMES_PLAYED";
    public static final String COL_6 = "GAMES_DRAWN";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,CATEGORY_LIST TEXT, " +
                "GAMES_WON INTEGER, GAMES_LOST INTEGER, GAMES_PLAYED INTEGER, GAMES_DRAWN INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean addData(String list) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, list);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }

    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT " + COL_2 + " FROM " + TABLE_NAME, null);
    }

    public void saveGamesPlayed(Integer played) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_5, played);
        db.update(TABLE_NAME, contentValues, COL_1 + " = '" + 0 + "'", null);

//        long result = db.insert(TABLE_NAME, null, contentValues);
//        return result != -1;
    }

    public void saveGamesWon(Integer won) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_3, won);
        db.update(TABLE_NAME, contentValues, COL_1 + " = '" + 0 + "'", null);

//        long result = db.insert(TABLE_NAME, null, contentValues);
//        return result != -1;
    }

    public void saveGamesLost(Integer lost) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_4, lost);
        db.update(TABLE_NAME, contentValues, COL_1 + " = '" + 0 + "'", null);

//        long result = db.insert(TABLE_NAME, null, contentValues);
//        return result != -1;
    }

    public void saveGamesDrawn(Integer draw) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_6, draw);
        db.update(TABLE_NAME, contentValues, COL_1 + " = '" + 0 + "'", null);

        //        long result = db.insert(TABLE_NAME, null, contentValues);
//        return result != -1;
    }

    public Cursor getDraw() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor query = db.rawQuery("SELECT " + COL_6 + " FROM " + TABLE_NAME + " WHERE " + COL_1 + " = '" + 0 + "'", null);
        return query;
    }

    public Cursor getPlayed() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor query = db.rawQuery("SELECT " + COL_5 + " FROM " + TABLE_NAME + " WHERE " + COL_1 + " = '" + 0 + "'", null);
        return query;
    }

    public Cursor getWon() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor query = db.rawQuery("SELECT " + COL_3 + " FROM " + TABLE_NAME + " WHERE " + COL_1 + " = '" + 0 + "'", null);
        return query;
    }

    public Cursor getLost() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor query = db.rawQuery("SELECT " + COL_4 + " FROM " + TABLE_NAME + " WHERE " + COL_1 + " = '" + 0 + "'", null);
        return query;
    }

    public void deleteName(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String string = String.valueOf(id);
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + COL_1 + " = '" + string + "'";
        db.execSQL(query);
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + TABLE_NAME + "'");
        String query = "DELETE FROM " + TABLE_NAME;
        db.execSQL(query);
    }


}
