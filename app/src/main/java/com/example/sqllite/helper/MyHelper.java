package com.example.sqllite.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.sqllite.model.Word;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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


        String query = "CREATE TABLE " + tbl_word +
                "("
                + wordId + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                word + " TEXT,"
                + meaning + " TEXT " +
                ")";

        db.execSQL(query);

    }

    public boolean InsertData(String word, String meaning, SQLiteDatabase db){

        try {
            String query2 = "insert into tblWord(word,meaning) values('" + word + "','" + meaning +"')";
            db.execSQL(query2);
            return true;
        }catch (Exception e){
            Log.d("Error: ",e.toString());
            return false;
        }

    };

    public List<Word> GetAllWords(SQLiteDatabase db){
        List<Word> dictionaryList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from tblWord",null);
        if (cursor.getCount() > 0){
            while (cursor.moveToNext()){
                dictionaryList.add(new Word(cursor.getInt(0),cursor.getString(1), cursor.getString(2)));
            }
        }
        return dictionaryList;
    };


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
