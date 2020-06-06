package dev.ariyanas.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import dev.ariyanas.popularmovies.models.Movie;
import dev.ariyanas.popularmovies.utils.ImageUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {
    Context ctx;
    Movie movie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        this.ctx = this;

        Intent intent = getIntent();

        String movieId = intent.getStringExtra("MOVIE_ID");

        setTitle("Movie Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getMovieDetails(movieId);
    }

    private void getMovieDetails(String movieId) {
        Call<Movie> movieRequest = MainActivity.movieService.getMovieDetails(movieId);

        movieRequest.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                movie = response.body();

                populateUI();
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(ctx, "Failed to get movie details", Toast.LENGTH_SHORT).show();
                call.cancel();
            }
        });
    }

    private void populateUI() {
        if (movie != null) {
            TextView tvTitle = (TextView) findViewById(R.id.tv_md_title);
            TextView tvOverview = (TextView) findViewById(R.id.tv_md_overview);
            TextView tvReleaseDate = (TextView) findViewById(R.id.tv_md_release_date);
            TextView tvRating = (TextView) findViewById(R.id.tv_md_rating);
            TextView tvVoteCount = (TextView) findViewById(R.id.tv_md_votes);

            ImageView imgMoviePoster = (ImageView) findViewById(R.id.img_md_poster);

            tvTitle.setText(movie.title);
            tvReleaseDate.setText(movie.releaseDate);
            tvRating.setText("" + movie.voteAverage);
            tvVoteCount.setText(movie.voteCount + " Votes");
            tvOverview.setText(movie.overview);

            ImageUtil.loadImage(imgMoviePoster, movie.posterPath);
        }
    }
}
