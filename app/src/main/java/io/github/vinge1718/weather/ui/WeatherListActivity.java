package io.github.vinge1718.weather.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.weather.R;
import io.github.vinge1718.weather.adapters.WeatherListAdapter;
import io.github.vinge1718.weather.models.Forecast;
import io.github.vinge1718.weather.models.ForecastList;
import io.github.vinge1718.weather.services.WeatherService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherListActivity extends AppCompatActivity {
    public List<ForecastList> mWeatherForecasts = new ArrayList<>();
    public static final String TAG = WeatherListActivity.class.getSimpleName();
    @BindView(R.id.recyclerView) RecyclerView mRecycleView;
    private WeatherListAdapter mAdapter;

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
                    WeatherListActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter = new WeatherListAdapter(getApplicationContext(), mWeatherForecasts, forecast);
                            mRecycleView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(WeatherListActivity.this);
                            mRecycleView.setLayoutManager(layoutManager);
                            mRecycleView.setHasFixedSize(true);
                        }
                    });
            }
        });
    }
}
