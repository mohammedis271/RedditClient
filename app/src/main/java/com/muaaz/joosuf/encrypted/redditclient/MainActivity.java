package com.muaaz.joosuf.encrypted.redditclient;
/**
 * Current Viewing Activity
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers.RSSToFrontPageParser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RSSToSubRedditPostParser rssToPostParser = new RSSToSubRedditPostParser(MainActivity.this);
//        rssToPostParser.run("pics");
//
//        ArrayList<Post> posts = rssToPostParser.getPosts();

        RSSToFrontPageParser rssToFrontPageParser = new RSSToFrontPageParser(MainActivity.this);
        rssToFrontPageParser.run("top");

    }
}
