package com.refactor.lastfm.popular_artists.mvp_model;

import com.refactor.lastfm.popular_artists.model.data_model.PopArtistsResponse;

import retrofit2.Response;

public interface PopularArtistsMvp {

    interface View {
        void onLoadPopArtists();
        void onPopArtistsResult(PopArtistsResponse popArtists);
        void onPopArtistsError(String title, String msg);
    }

    interface Presenter {
        void onPopArtistsResult(Response<PopArtistsResponse> response);
        void onPopArtistsFailure(Throwable t);
        void loadPopArtists();
    }

    interface Model {
        void enqueuePopArtists();
    }
}
