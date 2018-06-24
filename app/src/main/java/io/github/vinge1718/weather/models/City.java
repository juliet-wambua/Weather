
package io.github.vinge1718.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class City {

    @SerializedName("id")
    @Expose
    Long id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("coord")
    @Expose
    Coord coord;
    @SerializedName("country")
    @Expose
    String country;
    @SerializedName("population")
    @Expose
    Long population;

    /**
     * No args constructor for use in serialization
     * 
     */
    public City() {
    }

    /**
     * 
     * @param coord
     * @param id
     * @param name
     * @param population
     * @param country
     */
    public City(Long id, String name, Coord coord, String country, Long population) {
        super();
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        String people ="An estimated " +population.toString() + " people live in this area.";

        return people;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }


}
