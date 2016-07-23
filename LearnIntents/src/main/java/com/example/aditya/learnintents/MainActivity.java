package com.example.aditya.learnintents;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void pressMe(View v){
        Uri uri = Uri.parse("http://www.sciencepmp.com/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    protected void myPersonalAct(View v){
        Intent intent = new Intent("aditya.example.com.PERSONAL_ACTION");

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }
}
