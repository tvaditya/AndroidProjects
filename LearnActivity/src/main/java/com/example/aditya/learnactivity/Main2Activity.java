package com.example.aditya.learnactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void callAct1(View v){
        finish();

    }

    public void callAct3(View v){
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("name","Aditya 2");
        intent.putExtra("year", 2016);
        startActivity(intent);
    }
}
