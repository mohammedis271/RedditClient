package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Preview {
    @SerializedName("images")
    private List<Images> images;
    @SerializedName("enabled")
    private String enabled;

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}
