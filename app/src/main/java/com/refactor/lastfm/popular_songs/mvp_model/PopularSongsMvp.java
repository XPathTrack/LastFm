package com.refactor.lastfm.popular_songs.mvp_model;

public interface PopularSongsMvp {

    interface View {
    }

    interface Presenter {
        void loadPopArtists();
    }

    interface Model {
        void enqueuePopArtists();
    }
}
