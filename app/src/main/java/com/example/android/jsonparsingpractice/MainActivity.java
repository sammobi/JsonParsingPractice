package com.example.android.jsonparsingpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView mDateTimeTv, mWeatherTypeTv, mMinTempTv, mMaxTempTv, mDescriptionTv;
    private RecyclerView mRecyclerView;

    ArrayList<Main> mMainWeatherItem;

    private RecyclerAdapter mRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDateTimeTv = (TextView) findViewById(R.id.tvDateTime);
        mWeatherTypeTv = (TextView) findViewById(R.id.tvWeatherType);
        mMinTempTv = (TextView) findViewById(R.id.minTempTv);
        mMaxTempTv = (TextView) findViewById(R.id.maxTempTv);
        mDescriptionTv = (TextView) findViewById(R.id.descTv);
        downloadUrl();

    }

    public void downloadUrl() {

        String url = "http://api.openweathermap.org/data/2.5/forecast?lat=35&lon=139&appid=a06d2ec418305475594ae499091fb840";
        OkHttpHandler handler = new OkHttpHandler();
        String result = null;
        try {
            result = handler.execute(url).get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Log.d("Result", result);
        parseWeatherData(result);
    }

    public void parseWeatherData(String result) {
        try {
            ArrayList<WeatherItem> weatherItems = new ArrayList<>();

            JSONObject jsonObject = new JSONObject(result);
            JSONObject CityJsonObject = jsonObject.getJSONObject("city");
            int id = CityJsonObject.getInt("id");
            String name = CityJsonObject.getString("name");
            JSONObject CordJsonObject = CityJsonObject.getJSONObject("coord");
            String cod = jsonObject.getString("cod");
            double message = jsonObject.getDouble("message");
            int cnt = jsonObject.getInt("cnt");
            JSONArray ListJsonArray = jsonObject.getJSONArray("list");

            for (int i = 0; i < ListJsonArray.length(); i++) {
                JSONObject json_data = ListJsonArray.getJSONObject(i);
                int dt = json_data.getInt("dt");
                JSONObject MainJsonObject = json_data.getJSONObject("main");
                double temp = MainJsonObject.getDouble("temp");
                double temp_min = MainJsonObject.getDouble("temp_min");
                double temp_max = MainJsonObject.getDouble("temp_max");
                double pressure = MainJsonObject.getDouble("pressure");
                double sea_level = MainJsonObject.getDouble("sea_level");
                double grnd_level = MainJsonObject.getDouble("grnd_level");
                int humidity = MainJsonObject.getInt("humidity");
                int temp_kf = MainJsonObject.getInt("temp_kf");
                Main main = new Main(temp, temp_min, temp_max, pressure, sea_level, grnd_level, humidity, temp_kf);

                JSONArray WeatherJsonArray = json_data.getJSONArray("weather");
                String Date = json_data.getString("dt_txt");

                for (int j = 0; j < WeatherJsonArray.length(); j++) {
                    JSONObject json_weather_data = WeatherJsonArray.getJSONObject(j);
                    int weather_id = json_weather_data.getInt("id");
                    String main_weather = json_weather_data.getString("main");
                    String description = json_weather_data.getString("description");
                    String icon = json_weather_data.getString("icon");
                    Weather weather = new Weather(weather_id, main_weather, description, icon);
                    WeatherItem weatherItem = new WeatherItem(main, weather, Date);
                    weatherItems.add(weatherItem);

                    mMainWeatherItem.add(weatherItems);

                    mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

                    mRecyclerAdapter = new RecyclerAdapter(this, mMainWeatherItem);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

                    mRecyclerView.setLayoutManager(layoutManager);

                    mRecyclerView.setAdapter(mRecyclerAdapter);
                }
            }
            Log.d("DATA", weatherItems.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
