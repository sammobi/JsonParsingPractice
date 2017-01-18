package com.example.android.jsonparsingpractice;

/**
 * Created by sandeep on 1/16/2017.
 */

public class Main {
    public double temp, temp_min, temp_max, pressure, sea_level, grnd_level, temp_kf;
    public int humidity;

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public Main(double temp, double temp_min, double temp_max, double pressure, double sea_level, double grnd_level, double temp_kf, int humidity) {
        this.temp = temp;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
        this.temp_kf = temp_kf;
        this.humidity = humidity;
    }
}
