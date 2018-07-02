package io.github.vinge1718.weather.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.vinge1718.weather.R;
import io.github.vinge1718.weather.models.Forecast;
import io.github.vinge1718.weather.models.ForecastList;
import io.github.vinge1718.weather.services.WeatherService;
import io.github.vinge1718.weather.ui.WeatherDetailActivity;


public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.WeatherViewHolder>{

    private List<ForecastList> mWeatherForecasts = new ArrayList<>();
    private Forecast mForecast;

    private Context mContext;

    public WeatherListAdapter(Context context, List<ForecastList> weatherForecasts, Forecast forecast){
        mContext = context;
        mWeatherForecasts = weatherForecasts;
        mForecast = forecast;
    }

    @Override
    public WeatherListAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WeatherListAdapter.WeatherViewHolder holder, int position){
        holder.bindWeatherForecast(mWeatherForecasts.get(position));
    }

    @Override
    public int getItemCount(){
        return mWeatherForecasts.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.weatherImageView) ImageView mWeatherImageView;
        @BindView(R.id.mainWeatherTextView) TextView mMainWeatherTextView;
        @BindView(R.id.temperatureTextView) TextView mMaintemparatureTextView;
        @BindView(R.id.timeTextView) TextView mTimeTextView;

        private Context mContext;

        public WeatherViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindWeatherForecast(ForecastList forecastList){
            Picasso.with(mContext).load(forecastList.getWeather().get(0).getIcon()).into(mWeatherImageView);
            mMainWeatherTextView.setText(forecastList.getWeather().get(0).getMain());
            mMaintemparatureTextView.setText("Average Temperatures of: "+forecastList.getMain().getTemp());
            mTimeTextView.setText(forecastList.getReadableDate());
        }

        @Override
        public void onClick(View v){
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, WeatherDetailActivity.class);
            intent.putExtra("forecast", Parcels.wrap(mForecast));
            intent.putExtra("position", itemPosition);
            intent.putExtra("forecastLists", Parcels.wrap(mWeatherForecasts));
            intent.putExtra("city", Parcels.wrap(mForecast.getCity()));
            mContext.startActivity(intent);
        }
    }
}
