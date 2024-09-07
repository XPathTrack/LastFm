package com.refactor.lastfm.api_central;

import com.refactor.lastfm.popular_artists.model.data_model.PopArtistsResponse;
import com.refactor.lastfm.top_songs.model.data_model.TopSongsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET(LastFmApi.URL_POP_ARTISTS)
    Call<PopArtistsResponse> getPopArtists();

    @GET(LastFmApi.URL_TOP_SONGS)
    Call<TopSongsResponse> getTopSongs(@Query("artist") String artistName);
}
