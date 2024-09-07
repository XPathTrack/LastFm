package com.refactor.lastfm.top_songs.mvp_model;

import com.refactor.lastfm.top_songs.model.data_model.Song;
import com.refactor.lastfm.top_songs.model.data_model.TopSongsResponse;

import java.util.List;

import retrofit2.Response;

public interface TopSongsMvp {

    interface View {
        void onLoadTopTracks();

        void onTopTracksResult(List<Song> songs);

        void onTopTracksError(String title, String msg);

        void onTopTracksFatal(String title, String msg);
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
