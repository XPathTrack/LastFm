package com.refactor.lastfm.popular_artists.model;

import com.refactor.lastfm.popular_artists.mvp_model.PopularArtistsMvp;

public class PopularArtistsInteractor implements PopularArtistsMvp.Model {

    private PopularArtistsMvp.Presenter presenter;

    public PopularArtistsInteractor(PopularArtistsMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadPopArtists() {

    }
}
