package com.example.android.jsonparsingpractice;

/**
 * Created by sandeep on 1/16/2017.
 */

public class Weather {
    public int id;
    public String main, description, icon;

    public Weather(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
}
