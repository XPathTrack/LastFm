package com.refactor.lastfm.popular_artists.presenter;

import com.refactor.lastfm.popular_artists.model.PopularArtistsInteractor;
import com.refactor.lastfm.popular_artists.model.data_model.PopArtistsResponse;
import com.refactor.lastfm.popular_artists.mvp_model.PopularArtistsMvp;

import retrofit2.Response;

public class PopularArtistsPresenter implements PopularArtistsMvp.Presenter {

    private final PopularArtistsMvp.View view;
    private final PopularArtistsMvp.Model model;

    public PopularArtistsPresenter(PopularArtistsMvp.View view) {
        this.view = view;
        model = new PopularArtistsInteractor(this);
    }

    @Override
    public void onPopArtistsResult(Response<PopArtistsResponse> response) {

    }

    @Override
    public void onPopArtistsFailure(Throwable t) {

    }

    @Override
    public void loadPopArtists() {
        model.enqueuePopArtists();
    }
}
