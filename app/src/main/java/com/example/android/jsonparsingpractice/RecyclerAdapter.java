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

    private ArrayList<Main> mMainWeatherItem;

    public RecyclerAdapter(Context mContext, ArrayList<Main> mMainWeatherItem) {
        this.mContext = mContext;
        this.mMainWeatherItem = mMainWeatherItem;
    }

    @Override
    public MainItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new MainItemHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MainItemHolder holder, int position) {
        final Main mainWeatherItem = mMainWeatherItem.get(position);
        holder.mHighTempTv.setText((int) mainWeatherItem.getTemp_max());
        holder.mLowTempTv.setText((int) mainWeatherItem.getTemp_min());


    }

    @Override
    public int getItemCount() {
        if (mMainWeatherItem == null)
            return 0;
        return mMainWeatherItem.size();

    }

    public class MainItemHolder extends RecyclerView.ViewHolder {

        private TextView mDayTv, mHighTempTv, mLowTempTv;


        public MainItemHolder(View itemView) {

            super(itemView);

            mDayTv = (TextView) itemView.findViewById(R.id.dayTv);
            mHighTempTv = (TextView) itemView.findViewById(R.id.maxTempTv);
            mLowTempTv = (TextView) itemView.findViewById(R.id.minTempTv);


        }

    }

}
