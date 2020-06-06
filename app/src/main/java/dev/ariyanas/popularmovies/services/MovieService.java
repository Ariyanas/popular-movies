package dev.ariyanas.popularmovies.services;

import dev.ariyanas.popularmovies.lists.MovieList;
import dev.ariyanas.popularmovies.models.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {
    @GET("popular")
    Call<MovieList> getPopularMovies();

    @GET("top_rated")
    Call<MovieList> getTopRatedMovies();

    @GET("{id}")
    Call<Movie> getMovieDetails(@Path("id") String movieId);
}
