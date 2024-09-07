package com.refactor.lastfm.popular_artists.view;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.refactor.lastfm.R;
import com.refactor.lastfm.popular_artists.model.data_model.Artist;
import com.refactor.lastfm.popular_artists.mvp_model.PopularArtistsMvp;
import com.refactor.lastfm.popular_artists.presenter.PopularArtistsPresenter;
import com.refactor.lastfm.popular_songs.view.PopularSongsActivity;
import com.refactor.lastfm.utils.UIUtils;

import java.util.List;

public class PopularArtistsActivity extends AppCompatActivity implements PopularArtistsMvp.View {

    private PopularArtistsMvp.Presenter presenter;
    private ProgressBar progressBar;
    private RecyclerView rvPopArts;
    private PopularArtistsAdapter popArtsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_artists);
        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.layout_title_popular_artists);
        presenter = new PopularArtistsPresenter(this, this);
        progressBar = findViewById(R.id.pb_load_data);
        rvPopArts = findViewById(R.id.rv_popular_artists);
        popArtsAdapter = new PopularArtistsAdapter(artist -> {
            startActivity(new Intent(this, PopularSongsActivity.class));
        });
        rvPopArts.setAdapter(popArtsAdapter);
        rvPopArts.setLayoutManager(new GridLayoutManager(this, 2));
        presenter.loadPopArtists();
    }

    @Override
    public void onLoadPopArtists() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPopArtistsResult(List<Artist> artists) {
        progressBar.setVisibility(View.GONE);
        rvPopArts.setVisibility(View.VISIBLE);
        popArtsAdapter.setArtists(artists);
    }

    @Override
    public void onPopArtistsError(String title, String msg) {
        progressBar.setVisibility(View.GONE);
        AlertDialog aDialog = UIUtils.buildAlertDialog(this, title, msg, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            presenter.loadPopArtists();
        });
        aDialog.show();
    }

    @Override
    public void onPopArtistsFatal(String title, String msg) {
        progressBar.setVisibility(View.GONE);
        AlertDialog aDialog = UIUtils.buildAlertDialog(this, title, msg, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            finish();
        });
        aDialog.show();
    }
}