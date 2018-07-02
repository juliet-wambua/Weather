
package io.github.vinge1718.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.text.SimpleDateFormat;
import java.util.Date;

@Parcel
public class ForecastList {

    @SerializedName("dt")
    @Expose
    Long dt;
    @SerializedName("main")
    @Expose
    Main main;
    @SerializedName("weather")
    @Expose
    java.util.List<Weather> weather = null;
    @SerializedName("clouds")
    @Expose
    Clouds clouds;
    @SerializedName("wind")
    @Expose
    Wind wind;
    @SerializedName("rain")
    @Expose
    Rain rain;
    @SerializedName("sys")
    @Expose
    Sys sys;
    @SerializedName("dt_txt")
    @Expose
    String dtTxt;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ForecastList() {
    }

    /**
     * 
     * @param clouds
     * @param dt
     * @param wind
     * @param sys
     * @param dtTxt
     * @param weather
     * @param rain
     * @param main
     */
    public ForecastList(Long dt, Main main, java.util.List<Weather> weather, Clouds clouds, Wind wind, Rain rain, Sys sys, String dtTxt) {
        super();
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.rain = rain;
        this.sys = sys;
        this.dtTxt = dtTxt;
    }

    public String getReadableDate() {
        Long timestamp = dt*1000;
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy 'at' h:mm a");
        String date = sdf.format(timestamp);
        return date;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

}
