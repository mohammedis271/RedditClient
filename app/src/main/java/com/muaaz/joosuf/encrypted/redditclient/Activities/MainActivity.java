package com.muaaz.joosuf.encrypted.redditclient.Activities;
/**
 * Current Viewing Activity
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.muaaz.joosuf.encrypted.redditclient.R;

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
        Intent intent = new Intent(getApplicationContext(),User.class);
        startActivity(intent);
    }

    public void commentIntent(View view){
//        Intent intent = new Intent(getApplicationContext(),Comments.class);
//        startActivity(intent);
    }
}
