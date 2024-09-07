package com.refactor.lastfm.popular_artists.presenter;

import android.content.Context;

import com.refactor.lastfm.popular_artists.model.PopularArtistsInteractor;
import com.refactor.lastfm.popular_artists.model.data_model.Artist;
import com.refactor.lastfm.popular_artists.model.data_model.PopArtistsResponse;
import com.refactor.lastfm.popular_artists.mvp_model.PopularArtistsMvp;
import com.refactor.lastfm.utils.NetUtil;
import com.refactor.lastfm.utils.ToolBox;

import java.util.List;

import retrofit2.Response;

public class PopularArtistsPresenter implements PopularArtistsMvp.Presenter {

    private final PopularArtistsMvp.View view;
    private final PopularArtistsMvp.Model model;
    private final Context context;

    public PopularArtistsPresenter(PopularArtistsMvp.View view, Context context) {
        this.view = view;
        this.context = context;
        model = new PopularArtistsInteractor(this);
    }

    @Override
    public void loadPopArtists() {
        if (!NetUtil.isNetWorkConnected(context)) {
            view.onPopArtistsError("Sin conexión a internet",
                    "Conectese a internet y vuelva a intentar.");
            return;
        }
        view.onLoadPopArtists();
        model.enqueuePopArtists();
    }

    @Override
    public void onPopArtistsResult(Response<PopArtistsResponse> response) {
        if (!response.isSuccessful()) {
            if (NetUtil.isNetWorkConnected(context))
                view.onPopArtistsFatal("Fallo técnico",
                        "La obtención de los artistas populares falló: " + response.code());
            else
                view.onPopArtistsError("Perdida de conexión a internet",
                        "Recupere su conexión a internet y vuelva a intentar.");
            return;
        }
        List<Artist> artists = response.body().getPopArtists().getArtists();
        artists.sort((artist1, artist2) -> {
            return ToolBox.compareLongStr(artist2.getListeners(), artist1.getListeners());
        });
        view.onPopArtistsResult(artists);
    }

    @Override
    public void onPopArtistsFailure(Throwable t) {
        t.printStackTrace();
        view.onPopArtistsFatal("Fallo técnico", "Por favor contacte a soporte técnico.");
    }

    @Override
    public void onArtistClick(Artist artist) {
        view.onArtistClick(artist);
    }
}
