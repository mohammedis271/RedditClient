package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Images {
    @SerializedName("source")
    private Source source;
    @SerializedName("resolutions")
    private List<Resolutions> resolutions;
    @SerializedName("id")
    private String id;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public List<Resolutions> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<Resolutions> resolutions) {
        this.resolutions = resolutions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
