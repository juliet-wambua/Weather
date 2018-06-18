package io.github.vinge1718.weather;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class WeatherService {
    //public static final String TAG = WeatherService.class.getSimpleName();

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
}
