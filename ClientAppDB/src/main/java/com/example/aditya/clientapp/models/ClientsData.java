package com.example.aditya.clientapp.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aditya on 01/08/2016.
 */
public class ClientsData {
    public static List<Clients> CLIENTSDATA = new ArrayList<Clients>();

    static {
        CLIENTSDATA.add(new Clients("Tantravahi Aditya","987651234"));
        CLIENTSDATA.add(new Clients("Bruce Wayne","987654321"));
        CLIENTSDATA.add(new Clients("Diana Prince","912345678"));
        CLIENTSDATA.add(new Clients("Barry Allen","989991234"));
    }
}
