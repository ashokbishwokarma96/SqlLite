package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqllite.helper.MyHelper;

public class MainActivity extends AppCompatActivity {

    private EditText editTextWord,editTextMeaning;
    private Button buttonAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWord = findViewById(R.id.editTextWord);
        editTextMeaning = findViewById(R.id.editTextMeaning);
        buttonAddWord = findViewById(R.id.buttonAddWord);





        buttonAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyHelper myHelper =new MyHelper(MainActivity.this);
                final SQLiteDatabase sqLiteDatabase =myHelper.getWritableDatabase();

                boolean id = myHelper.InsertData(editTextWord.getText().toString(), editTextMeaning.getText().toString(),sqLiteDatabase);
                if (id = true){
                    Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
