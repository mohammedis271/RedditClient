package com.muaaz.joosuf.encrypted.redditclient;
/**
 * Current Viewing Activity
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Async.RSSToPostParser;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.SubReddit.Post;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String BASE_URL = "https://www.reddit.com/r/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RSSToPostParser rssToPostParser = new RSSToPostParser(MainActivity.this);
        rssToPostParser.run();

        ArrayList<Post> posts = rssToPostParser.getPosts();
    }

}
