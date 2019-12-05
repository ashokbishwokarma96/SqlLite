package com.example.sqllite.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    private static final String db_name = "Dictionary";
    private static final int db_version = 1;

    private static final String tbl_word = "tblWord";
    private static final String wordId = "wordId";
    private static final String word = "word";
    private static final String meaning = "meaning";

    public MyHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db = getWritableDatabase();

        String query = "CREATE TABLE " + tbl_word +
                "("
                + wordId + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                word + " TEXT,"
                + meaning + " TEXT " +
                ")";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
