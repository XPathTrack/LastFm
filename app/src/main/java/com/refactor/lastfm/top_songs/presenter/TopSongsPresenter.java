package com.refactor.lastfm.top_songs.presenter;

import android.content.Context;

import com.refactor.lastfm.top_songs.model.TopSongsInteractor;
import com.refactor.lastfm.top_songs.model.data_model.TopSongsResponse;
import com.refactor.lastfm.top_songs.mvp_model.TopSongsMvp;

import retrofit2.Response;

public class TopSongsPresenter implements TopSongsMvp.Presenter {

    private final TopSongsMvp.View view;
    private final TopSongsMvp.Model model;
    private final Context context;

    public TopSongsPresenter(TopSongsMvp.View view, Context context) {
        this.view = view;
        this.context = context;
        model = new TopSongsInteractor(this);
    }

    @Override
    public void loadTopTracks(String artistName) {
        model.enqueueTopTracks(artistName);
    }

    @Override
    public void onTopTracksResult(Response<TopSongsResponse> response) {

    }

    @Override
    public void onTopTracksFailure(Throwable t) {

    }
}
