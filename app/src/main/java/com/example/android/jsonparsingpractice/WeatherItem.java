package com.example.android.jsonparsingpractice;

/**
 * Created by sandeep on 1/16/2017.
 */

public class WeatherItem {
    public Main main;
    public Weather weather;
    public String Date_Time;

    public WeatherItem(Main main, Weather weather, String date_Time) {
        this.main = main;
        this.weather = weather;
        Date_Time = date_Time;
    }
}
