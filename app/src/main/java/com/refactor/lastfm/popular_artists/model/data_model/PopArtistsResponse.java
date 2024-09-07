package com.refactor.lastfm.popular_artists.model.data_model;

public class PopArtistsResponse {

    private PopArtists topartists;

    public PopArtists getPopArtists() {
        return topartists;
    }

    public void setPopArtists(PopArtists artists) {
        this.topartists = artists;
    }
}
