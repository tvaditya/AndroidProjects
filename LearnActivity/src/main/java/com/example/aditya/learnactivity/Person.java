package com.example.aditya.learnactivity;

import java.io.Serializable;

/**
 * Created by Aditya on 21/07/2016.
 */
public class Person implements Serializable {
    private String name;
    private int year;

    public Person( String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
