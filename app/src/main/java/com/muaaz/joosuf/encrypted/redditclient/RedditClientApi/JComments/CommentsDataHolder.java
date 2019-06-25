package com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JComments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts.PostsData;

import java.util.List;

public class CommentsDataHolder {
    @SerializedName("data")
    private List<PostsData> post;

    @SerializedName("data") //this is the problem
    private List<CommentsData>comments;

    public List<PostsData> getPost() {
        return post;
    }

    public void setPost(List<PostsData> post) {
        this.post = post;
    }

    public List<CommentsData> getComments() {
        return comments;
    }

    public void setComments(List<CommentsData> comments) {
        this.comments = comments;
    }
}
