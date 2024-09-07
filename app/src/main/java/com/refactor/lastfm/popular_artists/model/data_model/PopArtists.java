package com.refactor.lastfm.popular_artists.model.data_model;

import java.util.List;

public class PopArtists {
    private List<Artist> artist;

    public List<Artist> getArtists() {
        return artist;
    }

    public void setArtists(List<Artist> artists) {
        this.artist = artists;
    }
}