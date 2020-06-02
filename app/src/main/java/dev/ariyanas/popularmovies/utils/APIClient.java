package dev.ariyanas.popularmovies.utils;

import retrofit2.Retrofit;

public class APIClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie";

    private static Retrofit retrofitClient = null;

    static Retrofit getClient() {
        retrofitClient = new Retrofit.Builder().baseUrl(BASE_URL).build();

        return retrofitClient;
    }
}
