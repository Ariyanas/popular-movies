package dev.ariyanas.popularmovies.models;

import com.google.gson.annotations.SerializedName;

public class ProductionCompany {
    @SerializedName("id")
    private int id;

    private String name;

    @SerializedName("origin_country")
    private String originCountry;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }
}
