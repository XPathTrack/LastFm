package com.refactor.lastfm.api_central;

import com.refactor.lastfm.popular_artists.model.data_model.PopArtistsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET(LastFmApi.URL_POP_ARTISTS)
    Call<PopArtistsResponse> getPopArtists();
}
