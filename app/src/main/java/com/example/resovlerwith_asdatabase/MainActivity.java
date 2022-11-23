package com.example.resovlerwith_asdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String d="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.resovler);
        TextView textView=findViewById(R.id.resovler);

        ContentResolver resolver = getContentResolver();
        ContentValues values= new ContentValues();
        values.put("name","sb");
        values.put("age","20");

        Uri uri = Uri.parse("content://com.example.asdatabase.MyContentProvider/student");


        button.setOnClickListener(v -> {
                    Cursor cursor = resolver.query(uri, null, null, null, null);
                    while (cursor.moveToNext()) {
                        @SuppressLint("Range") String name = cursor.getString(cursor.
                                getColumnIndex("name"));
                        @SuppressLint("Range") int age = cursor.getInt(cursor.
                                getColumnIndex("age"));
                        @SuppressLint("Range") int id = cursor.getInt(cursor.
                                getColumnIndex("id"));
                        Log.d("db", "id=" + id + "|name=" + name + "|age=" + age);
                        d += ("id=" + id + "|name=" + name + "|age=" + age);
                    }
                    textView.setText(d);
                }
        );
    }
}