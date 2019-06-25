package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JComments;

import com.google.gson.annotations.SerializedName;

public class CommentsData {
    private String kind;

    private Data data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
