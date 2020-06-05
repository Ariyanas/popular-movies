package dev.ariyanas.popularmovies.lists;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import dev.ariyanas.popularmovies.models.Movie;

public class MovieList {
    private int page;

    @SerializedName("total_pages")
    private  int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("results")
    private List<Movie> movies;

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
