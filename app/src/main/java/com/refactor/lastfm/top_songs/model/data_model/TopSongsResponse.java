package com.refactor.lastfm.top_songs.model.data_model;

public class TopSongsResponse {

    private TopSongs toptracks;

    public TopSongs getTopTracks() {
        return toptracks;
    }

    public void setTopTracks(TopSongs toptracks) {
        this.toptracks = toptracks;
    }
}
