
package io.github.vinge1718.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import io.github.vinge1718.weather.Constants;
@Parcel
public class Weather {

    @SerializedName("id")
    @Expose
    Long id;
    @SerializedName("main")
    @Expose
    String main;
    @SerializedName("description")
    @Expose
    String description;
    @SerializedName("icon")
    @Expose
    String icon;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Weather() {
    }

    /**
     * 
     * @param id
     * @param icon
     * @param description
     * @param main
     */
    public Weather(Long id, String main, String description, String icon) {
        super();
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        String iconId = icon;
        String iconUrl = Constants.WEATHER_ICON_BASEURL + iconId + Constants.ICON_EXTENSION;
        return iconUrl;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
