package com.refactor.lastfm.top_songs.presenter;

import android.content.Context;

import com.refactor.lastfm.top_songs.model.TopSongsInteractor;
import com.refactor.lastfm.top_songs.model.data_model.Song;
import com.refactor.lastfm.top_songs.model.data_model.TopSongsResponse;
import com.refactor.lastfm.top_songs.mvp_model.TopSongsMvp;
import com.refactor.lastfm.utils.NetUtil;
import com.refactor.lastfm.utils.ToolBox;

import java.util.List;

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
        if (!NetUtil.isNetWorkConnected(context)) {
            view.onTopTracksError("Sin conexión a internet",
                    "Conectese a internet y vuelva a intentar.");
            return;
        }
        view.onLoadTopTracks();
        model.enqueueTopTracks(artistName);
    }

    @Override
    public void onTopTracksResult(Response<TopSongsResponse> response) {
        if (!response.isSuccessful()) {
            if (NetUtil.isNetWorkConnected(context))
                view.onTopTracksFatal("Fallo técnico",
                        "La obtención de los artistas populares falló: " + response.code());
            else
                view.onTopTracksError("Perdida de conexión a internet",
                        "Recupere su conexión a internet y vuelva a intentar.");
            return;
        }
        List<Song> songs = response.body().getTopTracks().getTracks();
        songs.sort((song1, song2) -> {
            return ToolBox.compareLongStr(song2.getAttr().getRank(), song1.getAttr().getRank());
        });
        view.onTopTracksResult(songs);
    }

    @Override
    public void onTopTracksFailure(Throwable t) {
        t.printStackTrace();
        view.onTopTracksFatal("Fallo técnico", "Por favor contacte a soporte técnico.");
    }
}
