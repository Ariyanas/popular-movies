package dev.ariyanas.popularmovies.utils;

import java.io.IOException;

import dev.ariyanas.popularmovies.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";

    private static String MOVIEDB_API_KEY = BuildConfig.MOVIEDB_API_KEY;

    private static Retrofit retrofitClient = null;

    public static Retrofit getClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();

                        HttpUrl reqUrl = request.url();

                        HttpUrl newUrl = reqUrl.newBuilder()
                            .addQueryParameter("api_key", MOVIEDB_API_KEY)
                            .addQueryParameter("language", "en-US")
                            .build();

                        return chain.proceed(request.newBuilder().url(newUrl).build());
                    }
                })
                .build();

        retrofitClient = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        return retrofitClient;
    }
}
