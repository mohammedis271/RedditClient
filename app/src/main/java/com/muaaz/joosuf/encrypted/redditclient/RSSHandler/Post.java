package com.muaaz.joosuf.encrypted.redditclient.RSSHandler;
/**
 * Class created to hold scraped RSS data for users who are not logged in.
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */
public class Post {
    private static final String TAG = "Post";

    private String title;
    private String author;
    private String dateUpdated;
    private String postURL; //to be used later for linking
    private String thumbnailURL;

    public Post(String title, String author, String dateUpdated, String postURL, String thumbnailURL) {
        this.title = title;
        this.author = author;
        this.dateUpdated = dateUpdated;
        this.postURL = postURL;
        this.thumbnailURL = thumbnailURL;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getPostURL() {
        return postURL;
    }

    public void setPostURL(String postURL) {
        this.postURL = postURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }
}
