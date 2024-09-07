package com.refactor.lastfm.popular_songs.model;

import com.refactor.lastfm.popular_songs.mvp_model.PopularSongsMvp;

public class PopularSongsInteractor implements PopularSongsMvp.Model {

    private final PopularSongsMvp.Presenter presenter;

    public PopularSongsInteractor(PopularSongsMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void enqueuePopArtists() {

    }
}
