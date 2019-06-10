package com.muaaz.joosuf.encrypted.redditclient.RSSHandler;

public class Comment {
    private static final String TAG = "Comment";
    private String user_URL;
    private String author;
    private String content;
    private String id;

    public Comment(String user_URL, String author, String content, String id) {
        this.user_URL = user_URL;
        this.author = author;
        this.content = content;
        this.id = id;
    }

    public static String getTAG() {
        return TAG;
    }

    public String getUser_URL() {
        return user_URL;
    }

    public void setUser_URL(String user_URL) {
        this.user_URL = user_URL;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
