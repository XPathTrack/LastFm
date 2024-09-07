package com.refactor.lastfm.popular_songs.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.refactor.lastfm.R;
import com.refactor.lastfm.popular_artists.mvp_model.PopularArtistsMvp;
import com.refactor.lastfm.popular_songs.mvp_model.PopularSongsMvp;
import com.refactor.lastfm.popular_songs.presenter.PopularSongsPresenter;

public class PopularSongsActivity extends AppCompatActivity implements PopularSongsMvp.View {

    private PopularSongsMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_songs);
        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.layout_title_popular_songs);
        presenter = new PopularSongsPresenter(this, this);
        presenter.loadPopArtists();
    }
}