
package io.github.vinge1718.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Main {

    @SerializedName("temp")
    @Expose
    Double temp;
    @SerializedName("temp_min")
    @Expose
    Double tempMin;
    @SerializedName("temp_max")
    @Expose
    Double tempMax;
    @SerializedName("pressure")
    @Expose
    Double pressure;
    @SerializedName("sea_level")
    @Expose
    Double seaLevel;
    @SerializedName("grnd_level")
    @Expose
    Double grndLevel;
    @SerializedName("humidity")
    @Expose
    Long humidity;
    @SerializedName("temp_kf")
    @Expose
    transient Long tempKf;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Main() {
    }

    /**
     * 
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param grndLevel
     * @param tempMax
     * @param temp
     * @param tempKf
     * @param tempMin
     */
    public Main(Double temp, Double tempMin, Double tempMax, Double pressure, Double seaLevel, Double grndLevel, Long humidity, Long tempKf) {
        super();
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
        this.humidity = humidity;
        this.tempKf = tempKf;
    }

    public String getTemp() {
        String tempDouble = temp.toString();
        String tempString = tempDouble + " °C";
        return tempString;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getTempKf() {
        return tempKf;
    }

    public void setTempKf(Long tempKf) {
        this.tempKf = tempKf;
    }

}
