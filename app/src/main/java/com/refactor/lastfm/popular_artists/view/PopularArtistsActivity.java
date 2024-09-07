package com.refactor.lastfm.popular_artists.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.refactor.lastfm.R;
import com.refactor.lastfm.popular_artists.model.data_model.PopArtistsResponse;
import com.refactor.lastfm.popular_artists.mvp_model.PopularArtistsMvp;
import com.refactor.lastfm.popular_artists.presenter.PopularArtistsPresenter;

public class PopularArtistsActivity extends AppCompatActivity implements PopularArtistsMvp.View {

    private PopularArtistsMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.layout_title_popular_artists);
        presenter = new PopularArtistsPresenter(this, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.loadPopArtists();
    }

    @Override
    public void onLoadPopArtists() {

    }

    @Override
    public void onPopArtistsResult(PopArtistsResponse popArtists) {

    }

    @Override
    public void onPopArtistsError(String title, String msg) {

    }

    @Override
    public void onPopArtistsFatal(String title, String msg) {

    }
}