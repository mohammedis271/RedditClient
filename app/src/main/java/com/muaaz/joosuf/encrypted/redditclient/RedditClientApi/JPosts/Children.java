package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts;

import com.google.gson.annotations.SerializedName;

public class Children {
    @SerializedName("kind")
    private String kind;
    @SerializedName("data")
    private ChildrenData data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ChildrenData getData() {
        return data;
    }

    public void setData(ChildrenData data) {
        this.data = data;
    }
}
