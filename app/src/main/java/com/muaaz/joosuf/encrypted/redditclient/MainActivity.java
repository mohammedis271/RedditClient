package com.muaaz.joosuf.encrypted.redditclient;
/**
 * Current Viewing Activity
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers.RSSToUserPageParser;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Post;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String BASE_URL = "https://www.reddit.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        RSSToSubRedditPageParser rssToPostParser = new RSSToSubRedditPageParser(MainActivity.this);
//        rssToPostParser.run("pics");
//
//        ArrayList<Post> posts = rssToPostParser.getPosts();
//
//        RSSToFrontPageParser rssToFrontPageParser = new RSSToFrontPageParser(MainActivity.this);
//        rssToFrontPageParser.run("top");
//
        RSSToUserPageParser rssToUserPageParser =
                new RSSToUserPageParser(MainActivity.this);

        BlockingQueue<ArrayList<Post>> blockingQueue = rssToUserPageParser.run("5gears0chill");

        ArrayList<Post> userPosts = null;
        try {
            userPosts = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG,Integer.toString(userPosts.size()));


        for (int j = 0; j<userPosts.size();j++){
                    Log.d(TAG, "onResponse: \n " +
                            "PostURL: " + userPosts.get(j).getPostURL() + "\n " +
                            "ThumbnailURL: " + userPosts.get(j).getThumbnailURL() + "\n " +
                            "Title: " + userPosts.get(j).getTitle() + "\n " +
                            "Author: " + userPosts.get(j).getAuthor() + "\n " +
                            "updated: " + userPosts.get(j).getDateUpdated() + "\n ");
                }



//        String[] url = userPosts.get(0).getPostURL().split(BASE_URL);
//        RSSToCommentsParser rssToCommentsParser = new RSSToCommentsParser(MainActivity.this);
//        rssToCommentsParser.run(url[1]);



    }
}
