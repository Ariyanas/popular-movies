package dev.ariyanas.popularmovies.services;

import dev.ariyanas.popularmovies.lists.MovieList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {
    @GET("popular")
    Call<MovieList> getPopularMovies();

    @GET("top_rated")
    Call<MovieList> getTopRatedMovies();
}
