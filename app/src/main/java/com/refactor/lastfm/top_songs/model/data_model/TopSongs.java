package com.refactor.lastfm.top_songs.model.data_model;

import java.util.List;

public class TopSongs {

    private List<TopSong> track;

    public List<TopSong> getTracks() {
        return track;
    }

    public void setTracks(List<TopSong> tracks) {
        this.track = tracks;
    }
}
