package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JComments;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Children {
    @SerializedName("kind")
    private String kind;
    @SerializedName("data")
    private List<ChildrenData> data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<ChildrenData> getData() {
        return data;
    }

    public void setData(List<ChildrenData> data) {
        this.data = data;
    }
}
