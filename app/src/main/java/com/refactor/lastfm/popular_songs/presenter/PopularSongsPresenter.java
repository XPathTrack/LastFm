package com.refactor.lastfm.popular_songs.presenter;

import android.content.Context;

import com.refactor.lastfm.popular_songs.model.PopularSongsInteractor;
import com.refactor.lastfm.popular_songs.mvp_model.PopularSongsMvp;

public class PopularSongsPresenter implements PopularSongsMvp.Presenter {

    private final PopularSongsMvp.View view;
    private final PopularSongsMvp.Model model;
    private final Context context;

    public PopularSongsPresenter(PopularSongsMvp.View view, Context context) {
        this.view = view;
        this.context = context;
        model = new PopularSongsInteractor(this);
    }

    @Override
    public void loadPopArtists() {
        model.enqueuePopArtists();
    }
}
