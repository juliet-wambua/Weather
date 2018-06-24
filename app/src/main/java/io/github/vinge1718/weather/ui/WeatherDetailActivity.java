package io.github.vinge1718.weather.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.weather.R;
import io.github.vinge1718.weather.adapters.WeatherPagerAdapter;
import io.github.vinge1718.weather.models.City;
import io.github.vinge1718.weather.models.Forecast;
import io.github.vinge1718.weather.models.ForecastList;

public class WeatherDetailActivity extends AppCompatActivity {

    @BindView(R.id.viewPager) ViewPager mViewpager;
    private WeatherPagerAdapter adapterViewpager;
    City mCity;
    List<ForecastList> mWeatherForecasts =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        ButterKnife.bind(this);

        mCity = Parcels.unwrap(getIntent().getParcelableExtra("city"));
        mWeatherForecasts = Parcels.unwrap(getIntent().getParcelableExtra("forecastLists"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewpager = new WeatherPagerAdapter(getSupportFragmentManager(), mWeatherForecasts, mCity);
        mViewpager.setAdapter(adapterViewpager);
        mViewpager.setCurrentItem(startingPosition);
    }

}
