package io.github.vinge1718.weather.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.weather.Constants;
import io.github.vinge1718.weather.R;
import io.github.vinge1718.weather.models.City;
import io.github.vinge1718.weather.models.Forecast;
import io.github.vinge1718.weather.models.ForecastList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherDetailFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.fragmentTemperatureTextView) TextView mFragmentTemparatureTextView;
    @BindView(R.id.iconImageView) ImageView mIconView;
    @BindView(R.id.descriptionTextView) TextView mDescriptionTextView;
    @BindView(R.id.cityNameTextView) TextView mCityNameTextView;
    @BindView(R.id.populationTextView) TextView mPopulationTextView;
    @BindView(R.id.minimumTemparatureTextView) TextView mMinimumTemperature;
    @BindView(R.id.maximumTemparatureTextView) TextView mMaximumTemperatureTextView;
    @BindView(R.id.windSpeedTextView) TextView mWindSpeedTextView;
    @BindView(R.id.coordinatesTextView) TextView mLocationCoordinates;
    @BindView(R.id.button) Button mSaveButton;

    private Forecast forecast;
    private ForecastList weatherForecast;
    private City city;


    public static WeatherDetailFragment newInstance(ForecastList mForecastList, City mCity, Forecast mForecast){
        WeatherDetailFragment weatherDetailFragment = new WeatherDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("forecast", Parcels.wrap(mForecast));
        args.putParcelable("forecastList", Parcels.wrap(mForecastList));
        args.putParcelable("city", Parcels.wrap(mCity));
        weatherDetailFragment.setArguments(args);
        return weatherDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        weatherForecast = Parcels.unwrap(getArguments().getParcelable("forecastList"));
        city = Parcels.unwrap(getArguments().getParcelable("city"));
        forecast= Parcels.unwrap(getArguments().getParcelable("forecast"));
    }


    public WeatherDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_detail, container, false);
        ButterKnife.bind(this, view);


            Picasso.with(view.getContext()).load(weatherForecast.getWeather().get(0).getIcon()).into(mIconView);
            mLocationCoordinates.setText(city.getCoord().getCoordinates());
            mFragmentTemparatureTextView.setText(weatherForecast.getMain().getTemp());
            mDescriptionTextView.setText(weatherForecast.getWeather().get(0).getDescription());
            mCityNameTextView.setText(city.getName());
            mPopulationTextView.setText(city.getPopulation());
            mMinimumTemperature.setText(Double.toString(weatherForecast.getMain().getTempMin()));
            mMaximumTemperatureTextView.setText(Double.toString(weatherForecast.getMain().getTempMax()));
            mWindSpeedTextView.setText(Double.toString(weatherForecast.getWind().getSpeed()));
            mLocationCoordinates.setOnClickListener(this);
            mSaveButton.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {

            case R.id.coordinatesTextView :
                Intent webMapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + city.getCoord().getLat() + "," + city.getCoord().getLon() + "?q=(" + city.getName() + ")"));
                startActivity(webMapIntent);
                break;

            case R.id.button:
                DatabaseReference weatherForecastFbase = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_FORECAST);
                weatherForecastFbase.push().setValue(forecast);
                Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
