package dev.ariyanas.popularmovies.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.ariyanas.popularmovies.R;
import dev.ariyanas.popularmovies.models.Movie;
import dev.ariyanas.popularmovies.utils.ImageUtil;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder
        > {

    private Context mContext;
    private List<Movie> movies;

    private OnMovieItemListener movieItemListener;

    public MovieListAdapter(Context mctx, List<Movie> movieData, OnMovieItemListener listener) {
        this.mContext = mctx;
        this.movies = movieData;
        this.movieItemListener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        LayoutInflater mInflater = LayoutInflater.from(this.mContext);

        view = mInflater.inflate(R.layout.item_movie_list, parent, false);

        return new MovieViewHolder(view, this.movieItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        String imgPath = this.movies.get(position).posterPath;

        ImageUtil.loadImage(holder.imgMoviePoster, imgPath);

        holder.tvMovieTitle.setText(this.movies.get(position).title);
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView tvMovieTitle;
        ImageView imgMoviePoster;

        OnMovieItemListener movieItemListener;

        public MovieViewHolder(@NonNull View itemView, OnMovieItemListener listener) {
            super(itemView);

            tvMovieTitle = (TextView) itemView.findViewById(R.id.tv_movie_title);
            imgMoviePoster = (ImageView) itemView.findViewById(R.id.img_movie_poster);

            movieItemListener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            movieItemListener.onMovieItemClick(getAdapterPosition());
        }
    }

    public interface OnMovieItemListener {
        void onMovieItemClick(int position);
    }
}
