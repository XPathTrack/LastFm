package com.refactor.lastfm.top_songs.model;

import androidx.annotation.NonNull;

import com.refactor.lastfm.api_central.ApiService;
import com.refactor.lastfm.api_central.LastFmApi;
import com.refactor.lastfm.top_songs.model.data_model.TopSongsResponse;
import com.refactor.lastfm.top_songs.mvp_model.TopSongsMvp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopSongsInteractor implements TopSongsMvp.Model {

    private final TopSongsMvp.Presenter presenter;

    public TopSongsInteractor(TopSongsMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void enqueueTopTracks(String artistName) {
        ApiService service = LastFmApi.getApiService();
        Call<TopSongsResponse> popArtCall = service.getTopSongs(artistName);
        popArtCall.enqueue(new Callback<TopSongsResponse>() {
            @Override
            public void onResponse(@NonNull Call<TopSongsResponse> call, @NonNull Response<TopSongsResponse> response) {
                presenter.onTopTracksResult(response);
            }

            @Override
            public void onFailure(@NonNull Call<TopSongsResponse> call, @NonNull Throwable t) {
                presenter.onTopTracksFailure(t);
            }
        });
    }
}
