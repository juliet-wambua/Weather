package io.github.vinge1718.weather.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyWeatherArrayAdapter extends ArrayAdapter {
    private String[] mPlaces;
    private String[] mWeatherConditions;

    public MyWeatherArrayAdapter(Context mContext, int resource , String[] places, String[] weatherConditions){
        super(mContext, resource);
        this.mPlaces = places;
        this.mWeatherConditions = weatherConditions;
    }

    @Override
    public Object getItem(int position){
        String place = mPlaces[position];
        String weatherCondition = mWeatherConditions[position];
        return String.format("%s will experience %s Weather", place, weatherCondition);
    }

    @Override
    public int getCount(){
        return mPlaces.length;
    }
}
