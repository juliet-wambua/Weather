package io.github.vinge1718.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;


import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = WeatherActivity.class.getSimpleName();
    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    private String[] towns = new String[] {"Nairobi", "Thika", "Kisumu", "Mombasa", "Eldoret", "Nanyuki", "Lamu", "Kiambu", "Nakuru", "Malindi"};
    private String[] weatherConditions = new String[] {"windy", "Storm", "Cloudy", "Rain", "Tornado Watch", "Hurricane", "Humid", "Cold", "Hot", "Snowy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Go Back to check the results for other towns");

        MyWeatherArrayAdapter adapter = new MyWeatherArrayAdapter(this, android.R.layout.simple_list_item_1, towns, weatherConditions);
        mListView.setAdapter(adapter);
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
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
