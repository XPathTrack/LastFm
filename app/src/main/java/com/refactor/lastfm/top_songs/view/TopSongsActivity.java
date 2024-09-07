package com.refactor.lastfm.top_songs.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.refactor.lastfm.R;
import com.refactor.lastfm.top_songs.model.data_model.Song;
import com.refactor.lastfm.top_songs.mvp_model.TopSongsMvp;
import com.refactor.lastfm.top_songs.presenter.TopSongsPresenter;

import java.util.List;

public class TopSongsActivity extends AppCompatActivity implements TopSongsMvp.View {

    public static final String ARTIST_KEY = "artist_name";
    private TopSongsMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_songs);
        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.layout_title_top_songs);
        presenter = new TopSongsPresenter(this, this);
        presenter.loadTopTracks(getIntent().getStringExtra(ARTIST_KEY));
    }

    @Override
    public void onLoadTopTracks() {

    }

    @Override
    public void onTopTracksResult(List<Song> artists) {

    }

    @Override
    public void onTopTracksError(String title, String msg) {

    }

    @Override
    public void onTopTracksFatal(String title, String msg) {

    }
}