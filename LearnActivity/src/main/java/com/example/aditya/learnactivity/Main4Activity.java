package com.example.aditya.learnactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        TextView txtData = (TextView) findViewById(R.id.txtData);
        Intent intent = getIntent();
        Person person = (Person) intent.getSerializableExtra("person");

        txtData.setText("Made by: " + person.getName() + " in " + person.getYear());


    }
}
