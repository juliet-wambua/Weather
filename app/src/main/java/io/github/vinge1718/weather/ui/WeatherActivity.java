package io.github.vinge1718.weather.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import io.github.vinge1718.weather.models.Weather;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.weather.adapters.MyWeatherArrayAdapter;
import io.github.vinge1718.weather.R;
import io.github.vinge1718.weather.models.Forecast;
import io.github.vinge1718.weather.services.WeatherService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public List<Forecast> mWeatherForecasts = new ArrayList<>();
    public static final String TAG = WeatherActivity.class.getSimpleName();
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    private String[] towns = new String[] {"Nairobi", "Thika", "Kisumu", "Mombasa", "Eldoret", "Nanyuki", "Lamu", "Kiambu", "Nakuru", "Malindi"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Go Back to check the results for other towns");


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
                    mWeatherForecasts = weatherService.processResults(response);
                    WeatherActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String[] weatherConditions = new String[mWeatherForecasts.size()];
                            for(int i = 0; i < weatherConditions.length;i++){
                                weatherConditions[i] = mWeatherForecasts.get(i).getWeather().get(0).getMain();

                                ArrayAdapter adapter = new ArrayAdapter(WeatherActivity.this, android.R.layout.simple_list_item_1, weatherConditions);
                                mListView.setAdapter(adapter);

                                for(Forecast weatherCondition : mWeatherForecasts){
                                    Log.d(TAG, "Description: " + weatherCondition.getWeather().get(0).getDescription());
                                    Log.d(TAG, "Temperatures: " + weatherCondition.getMain().getTemp());
                                    Log.d(TAG, "Maximum Temparatures: " + weatherCondition.getMain().getTempMax());
                                    Log.d(TAG, "Minimum Temparatures: " + weatherCondition.getMain().getTempMin());
                                    Log.d(TAG, "Wind Speeds: " +weatherCondition.getWind());
                                    Log.d(TAG, "Humidity Level: " + weatherCondition.getMain().getHumidity());
                                    Log.d(TAG, "Atmospherric Pressure: " + weatherCondition.getMain().getPressure());
//                                    Log.d(TAG, "Area Population: " + weatherCondition.getPopulation());
                                    Log.d(TAG, "Time the weather will be in effect: " + weatherCondition.getDtTxt());
//                                    Log.d(TAG, "Latitudinal coordinates: " + weatherCondition.getLatitude());
//                                    Log.d(TAG, "Longitudinal coordinates: " + weatherCondition.getLongitude());
                                }
                            }
                        }
                    });
            }
        });
    }
}
