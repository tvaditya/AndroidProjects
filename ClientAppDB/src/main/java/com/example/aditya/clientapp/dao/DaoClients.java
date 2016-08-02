package com.example.aditya.clientapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aditya.clientapp.models.Clients;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aditya on 02/08/2016.
 */
public class DaoClients extends SQLiteOpenHelper {

    private static final int VERSION =1;
    private static final String DATABANK = "dao_clients";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String SITE = "site";
    private static final String ADDRESS = "address";
    private static final String PHONE= "pone";
    private static final String TABLE = "clients";

    public DaoClients(Context context){
        super(context, DATABANK, null,VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE
                         + " (" + ID +" INTEGER PRIMARY KEY, "
                         + NAME + " TEXT NOT NULL, "
                         + EMAIL + " TEXT NOT NULL, "
                         + PHONE + " TEXT NOT NULL, "
                         + ADDRESS + " TEXT NOT NULL, "
                         + SITE + " TEXT NOT NULL); ";
        sqLiteDatabase.execSQL(query);
    }

    public List<Clients> listAll(){
        List<Clients> clients = new ArrayList<Clients>();
       Cursor cursor = getWritableDatabase().rawQuery("SELECT * FROM " + TABLE+ ";", null);

        while((cursor.moveToNext())){
            Clients client = new Clients();
            client.setId(cursor.getInt(cursor.getColumnIndex(ID)));
            client.setName(cursor.getString(cursor.getColumnIndex(NAME)));
            client.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
            client.setPhone(cursor.getString(cursor.getColumnIndex(PHONE)));
            client.setAddress(cursor.getString(cursor.getColumnIndex(ADDRESS)));
            client.setSite(cursor.getString(cursor.getColumnIndex(SITE)));

            clients.add(client);

        }
        cursor.close();
        return clients;
    }

    public void insertClient(Clients client){
        ContentValues values = new ContentValues();
        values.put(NAME,client.getName());
        values.put(EMAIL,client.getEmail());
        values.put(PHONE, client.getPhone());
        values.put(ADDRESS, client.getAddress());
        values.put(SITE, client.getSite());

        getWritableDatabase().insert(TABLE, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
