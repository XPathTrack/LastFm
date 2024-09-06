package com.refactor.lastfm.popular_artists.presenter;

import com.refactor.lastfm.popular_artists.mvp_model.PopularArtistsMvp;

public class PopularArtistsPresenter implements PopularArtistsMvp.Presenter {

    private PopularArtistsMvp.View view;
    private PopularArtistsMvp.Model model;

    public PopularArtistsPresenter(PopularArtistsMvp.View view) {
        this.view = view;
    }

    @Override
    public void loadPopArtists() {
        model.loadPopArtists();
    }
}
