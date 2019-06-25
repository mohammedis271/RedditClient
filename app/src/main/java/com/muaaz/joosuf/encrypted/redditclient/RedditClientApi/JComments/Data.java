package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JComments;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("modhash")
    private String modhash;
    @SerializedName("dist")
    private String dist;
    @SerializedName("children")
    private List<Children> children;
    @SerializedName("after")
    private String after;
    @SerializedName("before")
    private String before;

    public String getModhash() {
        return modhash;
    }

    public String getDist() {
        return dist;
    }

    public List<Children> getChildren() {
        return children;
    }

    public String getAfter() {
        return after;
    }

    public String getBefore() {
        return before;
    }
}
