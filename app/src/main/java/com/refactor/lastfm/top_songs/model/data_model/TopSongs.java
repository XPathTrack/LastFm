package com.refactor.lastfm.top_songs.model.data_model;

import java.util.List;

public class TopSongs {

    private List<Song> track;

    public List<Song> getTracks() {
        return track;
    }

    public void setTracks(List<Song> tracks) {
        this.track = tracks;
    }
}
