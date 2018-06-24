
package io.github.vinge1718.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Forecast {

    @SerializedName("cod")
    @Expose
    String cod;
    @SerializedName("message")
    @Expose
    Double message;
    @SerializedName("cnt")
    @Expose
    Long cnt;
    @SerializedName("list")
    @Expose
    java.util.List<ForecastList> forecastList = null;
    @SerializedName("city")
    @Expose
    City city;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Forecast() {
    }

    /**
     * 
     * @param message
     * @param cnt
     * @param cod
     * @param forecastList
     * @param city
     */
    public Forecast(String cod, Double message, Long cnt, java.util.List<ForecastList> forecastList, City city) {
        super();
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.forecastList = forecastList;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public java.util.List<ForecastList> getForecastList() {
        return forecastList;
    }

    public void setForecastList(java.util.List<ForecastList> forecastList) {
        this.forecastList = forecastList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
