package com.example.aditya.personalizedintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtIntent =  (TextView) findViewById(R.id.txtIntent);
        Intent intent = getIntent();

        if(intent.getAction().equals("aditya.example.com.PERSONAL_ACTION")){
            txtIntent.setText("This was my PERSONAL_ACTION");
        } else if(intent.getAction().equals(Intent.ACTION_VIEW)){
            Uri uri = intent.getData();
            txtIntent.setText("Fooled you! " + uri + " can't be acessed through this, it ain't a browser!");
        }
    }

    protected void goBack(View v) {
        Intent intent = new Intent("aditya.example.com.ADITYA_ACTION");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}