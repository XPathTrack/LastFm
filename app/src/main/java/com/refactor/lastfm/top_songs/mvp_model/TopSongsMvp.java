package com.refactor.lastfm.top_songs.mvp_model;

import com.refactor.lastfm.top_songs.model.data_model.TopSongsResponse;

import retrofit2.Response;

public interface TopSongsMvp {

    interface View {
    }

    interface Presenter {
        void loadTopTracks(String artistName);

        void onTopTracksResult(Response<TopSongsResponse> response);

        void onTopTracksFailure(Throwable t);
    }

    interface Model {
        void enqueueTopTracks(String artistName);
    }
}
