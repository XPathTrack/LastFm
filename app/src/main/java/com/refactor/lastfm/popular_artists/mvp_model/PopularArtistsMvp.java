package com.refactor.lastfm.popular_artists.mvp_model;

public interface PopularArtistsMvp {

    interface View {

    }

    interface Presenter {
        void loadPopArtists();
    }

    interface Model {
        void loadPopArtists();
    }
}
