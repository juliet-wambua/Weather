package io.github.vinge1718.weather.services;

import android.content.ContentValues;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import io.github.vinge1718.weather.Constants;
import io.github.vinge1718.weather.models.Forecast;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherService {


    public static OkHttpClient client = new OkHttpClient();

    public static void findForecast(String location, Callback callback){

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder
                .addPathSegment("forecast")
                .addQueryParameter(Constants.LOCATION_QUERY_PARAMETER, location)
                .addQueryParameter(Constants.API_KEY_PARAM, Constants.API_KEY);

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }


    public Forecast processResults(Response response){
        Forecast weatherForecasts = null;
        try{
            String jsonData = response.body().string();
            if (response.isSuccessful()){

                JSONObject fullForecastJSON = new JSONObject(jsonData);
                Gson gson = new GsonBuilder().create();
                weatherForecasts = gson.fromJson(fullForecastJSON.toString(), Forecast.class);
                }
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }

        return weatherForecasts;
    }


}
