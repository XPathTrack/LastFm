package com.refactor.lastfm.popular_artists.mvp_model;

import com.refactor.lastfm.popular_artists.model.data_model.Artist;
import com.refactor.lastfm.popular_artists.model.data_model.PopArtistsResponse;

import java.util.List;

import retrofit2.Response;

public interface PopularArtistsMvp {

    interface View {
        void onLoadPopArtists();

        void onPopArtistsResult(List<Artist> artists);

        void onPopArtistsError(String title, String msg);

        void onPopArtistsFatal(String title, String msg);
    }

    interface Presenter {
        void loadPopArtists();

        void onPopArtistsResult(Response<PopArtistsResponse> response);

        void onPopArtistsFailure(Throwable t);
    }

    interface Model {
        void enqueuePopArtists();
    }
}
