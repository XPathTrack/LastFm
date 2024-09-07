package com.refactor.lastfm.api_central;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LastFmApi {
    public static final String URL_BASE = "https://ws.audioscrobbler.com/2.0/";
    public static final String URL_POP_ARTISTS = "?method=chart.gettopartists&api_key=cf2894b9c73a323e24f5c6a9aab1eb85&limit=10&format=json";
    public static final String URL_POP_SONGS = "?method=artist.gettoptracks&artist={artists_name}&api_key=cf2894b9c73a323e24f5c6a9aab1eb85&limit=10&format=json";
    public static final String API_KEY = "cf2894b9c73a323e24f5c6a9aab1eb85";

    private static class LazyApi {
        private static final ApiService API_SERVICE = new Retrofit.Builder()
                .baseUrl(LastFmApi.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }

    public static ApiService getApiService() {
        return LazyApi.API_SERVICE;
    }
}
