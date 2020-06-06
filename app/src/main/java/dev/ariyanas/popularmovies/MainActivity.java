package dev.ariyanas.popularmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.ariyanas.popularmovies.adapters.MovieListAdapter;
import dev.ariyanas.popularmovies.lists.MovieList;
import dev.ariyanas.popularmovies.models.Movie;
import dev.ariyanas.popularmovies.services.MovieService;
import dev.ariyanas.popularmovies.utils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MovieListAdapter.OnMovieItemListener {
    public static MovieService movieService;
    private Context ctx;

    private static List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx = getApplicationContext();

        movieService = RetrofitClient.getClient().create(MovieService.class);

        getMovieList();
    }
    
    private void getMovieList() {
        Call<MovieList> movieRequest = movieService.getPopularMovies();
        
        movieRequest.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                MovieList movieListResponse = response.body();

                movies = movieListResponse.getMovies();

                populateUI();

                Log.d("MVIE", movieListResponse.getMovies().toString());
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                Toast.makeText(ctx, "Failed to Fetch movies", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }

    private void populateUI() {
        Log.d("MVL", movies.toString());

        RecyclerView rvMovieList = (RecyclerView) findViewById(R.id.rv_movie_list);
        MovieListAdapter movieListAdapter = new MovieListAdapter(this, movies, this);

        rvMovieList.setLayoutManager(new GridLayoutManager(this, 2));
        rvMovieList.setAdapter(movieListAdapter);
    }

    @Override
    public void onMovieItemClick(int position) {
        Movie movie = movies.get(position);

        Intent intent = new Intent(this, MovieDetailsActivity.class);

        intent.putExtra("MOVIE_ID", movie.id);

        startActivity(intent);
    }
}
