package io.github.vinge1718.weather.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import io.github.vinge1718.weather.models.City;
import io.github.vinge1718.weather.models.Forecast;
import io.github.vinge1718.weather.models.ForecastList;
import io.github.vinge1718.weather.ui.WeatherDetailFragment;

public class WeatherPagerAdapter extends FragmentPagerAdapter{
    private List<ForecastList> mWeatherForecasts;
    private City mCity;
    private Forecast mForecast;

    public WeatherPagerAdapter(FragmentManager fm, List<ForecastList> weatherForecast, City city, Forecast forecast){
        super(fm);
        mWeatherForecasts = weatherForecast;
        mCity = city;
        mForecast = forecast;
    }

    @Override
    public Fragment getItem(int position){
        return WeatherDetailFragment.newInstance(mWeatherForecasts.get(position), mCity, mForecast);
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
