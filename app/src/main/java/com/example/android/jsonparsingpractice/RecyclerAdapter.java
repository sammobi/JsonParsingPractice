package com.example.android.jsonparsingpractice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Simpalm on 1/17/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MainItemHolder> {

    Context mContext;

    private ArrayList<WeatherItem> mWeatherItems;

    public RecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setmWeatherItems(ArrayList<WeatherItem> mWeatherItems) {
        this.mWeatherItems = mWeatherItems;
        notifyDataSetChanged();
    }

    @Override
    public MainItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);

        return new MainItemHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MainItemHolder holder, int position) {
        KelvinToFahrenheitUtil kelvinToFahrenheitUtil = new KelvinToFahrenheitUtil();
        final WeatherItem weatherItem = mWeatherItems.get(position);
        Main main = weatherItem.main;
        holder.mHighTempTv.setText("Max Temp: " + String
                .valueOf(kelvinToFahrenheitUtil.convertFahrenheitToCelsius(main.getTemp_max())));
        holder.mLowTempTv.setText("Min Temp: " + String
                .valueOf(kelvinToFahrenheitUtil.convertFahrenheitToCelsius(main.getTemp_min())));
        holder.mDayTv.setText(weatherItem.Date_Time);
        holder.mTempTv.setText("Current Temp: " + String
                .valueOf(kelvinToFahrenheitUtil.convertFahrenheitToCelsius(main.getTemp())));
    }

    @Override
    public int getItemCount() {
        if (mWeatherItems == null)
            return 0;
        return mWeatherItems.size();

    }

    public class MainItemHolder extends RecyclerView.ViewHolder {

        private TextView mDayTv, mHighTempTv, mLowTempTv, mTempTv;


        public MainItemHolder(View itemView) {

            super(itemView);

            mDayTv = (TextView) itemView.findViewById(R.id.dayTv);
            mHighTempTv = (TextView) itemView.findViewById(R.id.dayTempHigh);
            mLowTempTv = (TextView) itemView.findViewById(R.id.dayTempLow);
            mTempTv = (TextView) itemView.findViewById(R.id.tempTv);


        }

    }

}
