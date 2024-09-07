package com.refactor.lastfm.top_songs.model.data_model;

import com.google.gson.annotations.SerializedName;

public class Song {

    private String name;
    private String playcount;
    private String listeners;
    private String url;
    private SongImage[] image;

    @SerializedName("@attr")
    private SongAttr attr;

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

    public SongImage[] getImage() {
        return image;
    }

    public void setImage(SongImage[] image) {
        this.image = image;
    }

    public SongAttr getAttr() {
        return attr;
    }

    public void setAttr(SongAttr attr) {
        this.attr = attr;
    }
}
