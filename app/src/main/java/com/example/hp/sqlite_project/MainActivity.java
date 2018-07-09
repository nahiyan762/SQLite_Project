package com.example.hp.sqlite_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);

        sqLiteDatabase = openOrCreateDatabase("regdb", Context.MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("create table if not exists register(name varchar(20),pass varchar(20),email varchar(20),phone varchar(20))");

    }

    public void insert(View view)
    {
        ContentValues values = new ContentValues();
        values.put("name",et1.getText().toString());
        values.put("pass",et2.getText().toString());
        values.put("email",et3.getText().toString());
        values.put("phone",et4.getText().toString());

        long count = sqLiteDatabase.insert("register",null,values);
        if(count>0)
        {
            Toast.makeText(this,"Insert Successfully",Toast.LENGTH_LONG).show();
            et1.setText("");
            et2.setText("");
            et3.setText("");
            et4.setText("");
        }
        else
        {
            Toast.makeText(this,"Insert Failed",Toast.LENGTH_LONG).show();
        }
    }

    public void read(View view)
    {}

    public void update(View view)
    {}

    public void delete(View view)
    {}
}
