package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts;

import com.google.gson.annotations.SerializedName;

public class Reddit_Video {
    @SerializedName("fallback_url")
    private String fallback_url;
    @SerializedName("height")
    private String height;
    @SerializedName("width")
    private String width;
    @SerializedName("scrubber_media_url")
    private String scrubber_media_url;
    @SerializedName("dash_url")
    private String dash_url;
    @SerializedName("duration")
    private String duration;
    @SerializedName("hls_url")
    private String hls_url;
    @SerializedName("is_gif")
    private String is_gif;
    @SerializedName("transcoding_status")
    private String transcoding_status;

    public String getFallback_url() {
        return fallback_url;
    }

    public void setFallback_url(String fallback_url) {
        this.fallback_url = fallback_url;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getScrubber_media_url() {
        return scrubber_media_url;
    }

    public void setScrubber_media_url(String scrubber_media_url) {
        this.scrubber_media_url = scrubber_media_url;
    }

    public String getDash_url() {
        return dash_url;
    }

    public void setDash_url(String dash_url) {
        this.dash_url = dash_url;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getHls_url() {
        return hls_url;
    }

    public void setHls_url(String hls_url) {
        this.hls_url = hls_url;
    }

    public String getIs_gif() {
        return is_gif;
    }

    public void setIs_gif(String is_gif) {
        this.is_gif = is_gif;
    }

    public String getTranscoding_status() {
        return transcoding_status;
    }

    public void setTranscoding_status(String transcoding_status) {
        this.transcoding_status = transcoding_status;
    }
}
