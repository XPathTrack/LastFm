package com.refactor.lastfm.top_songs.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.refactor.lastfm.R;
import com.refactor.lastfm.top_songs.model.data_model.Song;
import com.refactor.lastfm.top_songs.mvp_model.TopSongsMvp;
import com.refactor.lastfm.top_songs.presenter.TopSongsPresenter;
import com.refactor.lastfm.utils.UIUtils;

import java.util.List;

public class TopSongsActivity extends AppCompatActivity implements TopSongsMvp.View {

    public static final String ARTIST_KEY = "artist_name";
    private String artistName;
    private TopSongsMvp.Presenter presenter;
    private ProgressBar progressBar;
    private RecyclerView rvTopSongs;
    private TopSongsAdapter topSongsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_songs);
        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.layout_title_top_songs);
        presenter = new TopSongsPresenter(this, this);
        progressBar = findViewById(R.id.pb_load_data);
        rvTopSongs = findViewById(R.id.rv_top_songs);
        topSongsAdapter = new TopSongsAdapter();
        rvTopSongs.setAdapter(topSongsAdapter);
        rvTopSongs.setLayoutManager(new GridLayoutManager(this, 2));
        artistName = getIntent().getStringExtra(ARTIST_KEY);
        presenter.loadTopTracks(artistName);
    }

    @Override
    public void onLoadTopTracks() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onTopTracksResult(List<Song> songs) {
        progressBar.setVisibility(View.GONE);
        rvTopSongs.setVisibility(View.VISIBLE);
        topSongsAdapter.setSongs(songs);
    }

    @Override
    public void onTopTracksError(String title, String msg) {
        progressBar.setVisibility(View.GONE);
        AlertDialog aDialog = UIUtils.buildAlertDialog(this, title, msg, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            presenter.loadTopTracks(artistName);
        });
        aDialog.show();
    }

    @Override
    public void onTopTracksFatal(String title, String msg) {
        progressBar.setVisibility(View.GONE);
        AlertDialog aDialog = UIUtils.buildAlertDialog(this, title, msg, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            finish();
        });
        aDialog.show();
    }
}