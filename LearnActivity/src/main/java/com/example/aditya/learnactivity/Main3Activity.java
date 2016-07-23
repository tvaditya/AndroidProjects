package com.example.aditya.learnactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

// Passing parameters through activities
public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView txtName =  (TextView) findViewById(R.id.txtName);
        TextView txtYear =  (TextView) findViewById(R.id.txtYear);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int year = intent.getIntExtra("year", 0);

        txtName.setText(name);
        txtYear.setText(Integer.toString(year));
    }
}
