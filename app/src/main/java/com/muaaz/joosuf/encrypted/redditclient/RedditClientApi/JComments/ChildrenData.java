package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JComments;

import com.google.gson.annotations.SerializedName;

public class ChildrenData {

    @SerializedName("ups")
    private String ups;

    public String getUps() {
        return ups;
    }

    public void setUps(String ups) {
        this.ups = ups;
    }
}
