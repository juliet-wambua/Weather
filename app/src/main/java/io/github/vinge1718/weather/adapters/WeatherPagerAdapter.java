package io.github.vinge1718.weather.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import io.github.vinge1718.weather.models.City;
import io.github.vinge1718.weather.models.ForecastList;
import io.github.vinge1718.weather.ui.WeatherDetailFragment;

public class WeatherPagerAdapter extends FragmentPagerAdapter{
    private List<ForecastList> mWeatherForecasts;
    private City mCity;

    public WeatherPagerAdapter(FragmentManager fm, List<ForecastList> weatherForecast, City city){
        super(fm);
        mWeatherForecasts = weatherForecast;
        mCity = city;
    }

    @Override
    public Fragment getItem(int position){
        return WeatherDetailFragment.newInstance(mWeatherForecasts.get(position), mCity);
    }

    @Override
    public int getCount(){
        return mWeatherForecasts.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mWeatherForecasts.get(position).getReadableDate();
    }
}
