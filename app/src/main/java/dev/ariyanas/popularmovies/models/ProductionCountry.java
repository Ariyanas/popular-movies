package dev.ariyanas.popularmovies.models;

import com.google.gson.annotations.SerializedName;

public class ProductionCountry {
    @SerializedName("iso_3166_1")
    private String iso;

    private String name;

    public String getIso() {
        return iso;
    }

    public String getName() {
        return name;
    }
}
