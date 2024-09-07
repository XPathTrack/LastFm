package com.refactor.lastfm.popular_artists.model.data_model;

public class Artist {

    private String name;
    private String playcount;
    private String listeners;
    private String url;
    private ArtistImage[] image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArtistImage[] getImage() {
        return image;
    }

    public void setImage(ArtistImage[] image) {
        this.image = image;
    }
}
