package io.github.vinge1718.weather.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.weather.Constants;
import io.github.vinge1718.weather.R;
import io.github.vinge1718.weather.models.Forecast;
import io.github.vinge1718.weather.models.ForecastList;
import io.github.vinge1718.weather.services.WeatherService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public List<ForecastList> mWeatherForecasts = new ArrayList<>();
    public static final String TAG = WeatherActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");



        getWeather(location);
    }

    private void getWeather(String location){
        final WeatherService weatherService = new WeatherService();
        weatherService.findForecast(location, new Callback(){
            @Override
            public void onFailure(Call call, IOException e){
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    final Forecast forecast = weatherService.processResults(response);
                    mWeatherForecasts = forecast.getForecastList();
                    WeatherActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String[] weatherConditions = new String[mWeatherForecasts.size()];
                            for(int i = 0; i < weatherConditions.length;i++){
                                weatherConditions[i] = mWeatherForecasts.get(i).getWeather().get(0).getMain();


                                for(ForecastList weatherCondition : mWeatherForecasts){
                                    Log.d(TAG, "The weather Icon key is: " + Constants.WEATHER_ICON_BASEURL + weatherCondition.getWeather().get(0).getIcon() +Constants.ICON_EXTENSION);
                                    Log.d(TAG, "Description: " + weatherCondition.getWeather().get(0).getDescription());
                                    Log.d(TAG, "Temperatures: " + weatherCondition.getMain().getTemp());
                                    Log.d(TAG, "Maximum Temparatures: " + weatherCondition.getMain().getTempMax());
                                    Log.d(TAG, "Minimum Temparatures: " + weatherCondition.getMain().getTempMin());
                                    Log.d(TAG, "Wind Speeds: " +weatherCondition.getWind().getSpeed());
                                    Log.d(TAG, "Humidity Level: " + weatherCondition.getMain().getHumidity());
                                    Log.d(TAG, "Atmospherric Pressure: " + weatherCondition.getMain().getPressure());
                                    Log.d(TAG, "Area Population: " + forecast.getCity().getPopulation());
                                    //Log.d(TAG, "Time the weather will be in effect: " + weatherCondition.getDtTxt());
                                    Log.d(TAG, "Latitudinal coordinates: " + forecast.getCity().getCoord().getLat());
                                    Log.d(TAG, "Longitudinal coordinates: " + forecast.getCity().getCoord().getLon());
                                    Log.d(TAG, "Formated forecasted time: " + weatherCondition.getDt());
                                }
                            }
                        }
                    });
            }
        });
    }
}
