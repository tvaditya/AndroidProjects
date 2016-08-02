package com.example.aditya.clientapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.aditya.clientapp.adapter.ClientsAdapter;
import com.example.aditya.clientapp.dao.DaoClients;
import com.example.aditya.clientapp.models.Clients;
import com.example.aditya.clientapp.models.ClientsData;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView clientslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomerForm.class);
                startActivity(intent);
            }
        });

        clientslist = (ListView) findViewById(R.id.lstClients);
        clientslist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Clients client = new Clients();
                client = (Clients) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(MainActivity.this, CustomerForm.class);
                intent.putExtra("selectedClient", client);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        DaoClients dao = new DaoClients(this);
        List<Clients> clients = dao.listAll();
        dao.close();


        ClientsAdapter adapter = new ClientsAdapter(this, clients);
        clientslist.setAdapter(adapter);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
