package com.example.aditya.learnactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity event", "onCreate method ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity event", "onStart method ");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity event", "onResume method ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity event", "onPause method ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity event", "onStop method ");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Activity event", "onRestart method ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity event", "onDestroy method ");
    }

    public void callAct2(View v){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void callAct3(View v){
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra("name","Aditya");
        intent.putExtra("year", 2016);
        startActivity(intent);
    }

    public void callMore(View V){
        Intent intent = new Intent(this, Main4Activity.class);
        intent.putExtra("person", new Person("Aditya Venkata", 2016));
        startActivity(intent);
    }
}
