package com.refactor.lastfm.top_songs.model.data_model;

import com.google.gson.annotations.SerializedName;

public class SongImage {

    @SerializedName("#text")
    private String url;
    private String size;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
