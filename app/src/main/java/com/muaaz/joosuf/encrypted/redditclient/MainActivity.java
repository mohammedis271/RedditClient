package com.muaaz.joosuf.encrypted.redditclient;
/**
 * Current Viewing Activity
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers.RSSToUserPageParser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void subredditIntent(View view){
        Intent intent = new Intent(getApplicationContext(),SubReddit.class);
        startActivity(intent);

    }

    public void frontPageIntent(View viw){
        Intent intent = new Intent(getApplicationContext(),FrontPage.class);
        startActivity(intent);
    }

    public void userIntent(View view){
//        RSSToUserPageParser rss = new RSSToUserPageParser();
//        rss.run("5gears0chill");
        Intent intent = new Intent(getApplicationContext(),User.class);
        startActivity(intent);
    }
}
