package com.example.aditya.clientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aditya.clientapp.dao.DaoClients;
import com.example.aditya.clientapp.models.Clients;

public class CustomerForm extends AppCompatActivity {
    private EditText name, email, site, phone, address;
    private Clients client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_form);

        name = (EditText) findViewById(R.id.txtName);
        email = (EditText) findViewById(R.id.txtEmail);
        site = (EditText) findViewById(R.id.txtSite);
        phone = (EditText) findViewById(R.id.txtPhone);
        address = (EditText) findViewById(R.id.txtAddress);

        Intent intent = this.getIntent();
        this.client = (Clients) intent.getSerializableExtra("selectedClient");

        if(this.client != null){
            Toast.makeText(CustomerForm.this, "Selected client",Toast.LENGTH_SHORT).show();
        }

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Clients client = new Clients();
                client.setName(name.getText().toString());
                client.setEmail(email.getText().toString());
                client.setPhone(phone.getText().toString());
                client.setSite(site.getText().toString());
                client.setAddress(address.getText().toString());

                DaoClients dao = new DaoClients(CustomerForm.this);
                dao.insertClient(client);

                //Check whether client is regeitered, before creating a listing method
                Toast.makeText(CustomerForm.this,"Ok! Client is registered",Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }


}
