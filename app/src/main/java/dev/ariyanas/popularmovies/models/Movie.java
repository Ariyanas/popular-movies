package dev.ariyanas.popularmovies.models;

import com.google.gson.annotations.SerializedName;

public class Movie {
    public String id;

    @SerializedName("poster_path")
    public String posterPath = null;

    public boolean adult;
    public String overview;

    @SerializedName("release_date")
    public String releaseDate;

    public String title;

    @SerializedName("original_title")
    public String originalTitle;

    @SerializedName("original_language")
    public String originalLanguage;

    public double popularity;

    @SerializedName("vote_count")
    public int voteCount;

    @SerializedName("vote_average")
    public double voteAverage;

    public boolean video = false;
    public int budget;
    public int revenue;
    public String status = null;

    @SerializedName("tagline")
    public String tagLine = null;

}
