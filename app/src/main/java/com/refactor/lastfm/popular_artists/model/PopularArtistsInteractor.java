package com.refactor.lastfm.popular_artists.model;

import androidx.annotation.NonNull;

import com.refactor.lastfm.api_central.ApiService;
import com.refactor.lastfm.api_central.LastFmApi;
import com.refactor.lastfm.popular_artists.model.data_model.PopArtistsResponse;
import com.refactor.lastfm.popular_artists.mvp_model.PopularArtistsMvp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularArtistsInteractor implements PopularArtistsMvp.Model {

    private final PopularArtistsMvp.Presenter presenter;

    public PopularArtistsInteractor(PopularArtistsMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void enqueuePopArtists() {
        ApiService service = LastFmApi.getApiService();
        Call<PopArtistsResponse> popArtCall = service.getPopArtists();
        popArtCall.enqueue(new Callback<PopArtistsResponse>() {
            @Override
            public void onResponse(@NonNull Call<PopArtistsResponse> call, @NonNull Response<PopArtistsResponse> response) {
                presenter.onPopArtistsResult(response);
            }

            @Override
            public void onFailure(@NonNull Call<PopArtistsResponse> call, @NonNull Throwable t) {
                presenter.onPopArtistsFailure(t);
            }
        });
    }
}
