package io.github.vinge1718.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Weather extends AppCompatActivity {
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
    }
}
