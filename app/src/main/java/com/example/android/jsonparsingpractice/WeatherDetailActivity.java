package com.example.android.jsonparsingpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WeatherDetailActivity extends AppCompatActivity {

    TextView mTempDetailTv, mDescDetailTv, mTempMinDetailTv, mTempMaxDetailTv, mPressureDetailTv, mSeaLevelDetailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        mTempDetailTv = (TextView) findViewById(R.id.tempDetailTv);
        mDescDetailTv = (TextView) findViewById(R.id.descDetailTv);
        mTempMinDetailTv = (TextView) findViewById(R.id.tempMinDetailTv);
        mTempMaxDetailTv = (TextView) findViewById(R.id.tempMaxDetailTv);
        mPressureDetailTv = (TextView) findViewById(R.id.pressureDetailTv);
        mSeaLevelDetailTv = (TextView) findViewById(R.id.seaDetailTv);

    }
}
