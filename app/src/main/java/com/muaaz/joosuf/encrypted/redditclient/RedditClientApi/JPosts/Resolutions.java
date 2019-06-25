package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts;

import com.google.gson.annotations.SerializedName;

public class Resolutions {
    @SerializedName("url")
    private String url;
    @SerializedName("width")
    private String width;
    @SerializedName("height")
    private String height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
