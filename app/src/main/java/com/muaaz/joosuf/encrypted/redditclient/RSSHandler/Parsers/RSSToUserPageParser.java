package com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Post;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.XMLTags.Entry;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.XMLTags.Feed;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class RSSToUserPageParser {
    private static final String TAG = "RSSToUserPage";
    private static final String BASE_URL = "https://www.reddit.com/user/";
    ArrayList<Post> posts;
    private Context context;


    public void run(String user_handle) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();


        XMLHandler xmlHandlerSubReddit = retrofit.create(XMLHandler.class);
        Call<Feed> call = xmlHandlerSubReddit.getUserPageFeed(user_handle);

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
//                Log.d(TAG,"onResponse: feed " +response.body().getEntries());

                List<Entry> entries = response.body().getEntries();
//                Log.d(TAG, "onResponse: Server Response" + entries.get(0).getTitle());
                for (int i = 0; i < entries.size(); i++) {
                    ExtractXML extractXML1 = new ExtractXML(entries.get(i).getContent(), "<a href=");
                    List<String> postContent = extractXML1.start();

                    ExtractXML extractXML2 = new ExtractXML(entries.get(i).getContent(), "<img src=");
                    try {
                        postContent.add(extractXML2.start().get(0));
                    } catch (NullPointerException e) {
                        postContent.add(null);
//                        Log.e(TAG, "onResponse: NullPointerException: " + e.getMessage());
                    } catch (IndexOutOfBoundsException e) {
                        postContent.add(null);
//                       Log.e(TAG, "onResponse: IndexOutOfBoundsException: " + e.getMessage());
                    }
//                    posts.add(new Post(
//                            entries.get(i).getTitle(),
//                            entries.get(i).getAuthor().getName(),
//                            entries.get(i).getUpdated(),
//                            postContent.get(0),
//                            postContent.get(postContent.size() - 1)
//                    ));

                    Log.d(TAG,"TITLE " + entries.get(i).getTitle());
                    Log.d(TAG,"AUTHORS " + entries.get(i).getAuthor());
                    Log.d(TAG,"GET UPDATED  " + entries.get(i).getUpdated());
                    Log.d(TAG,"POST CONTENT " + postContent.get(0));
                    Log.d(TAG,"THUMBNAIL URL " + postContent.get(postContent.size() - 1));
                    Post post = new Post();

                    post.setAuthor(entries.get(i).getAuthor().getName());
                    post.setTitle(entries.get(i).getTitle());
                    post.setDateUpdated(entries.get(i).getUpdated());
                    post.setPostURL(postContent.get(0));
                    post.setThumbnailURL(postContent.get(postContent.size() - 1));

                    posts = new ArrayList<>();
                    posts.add(post);

                }
//                for (int j = 0; j < posts.size(); j++) {
//                    Log.d(TAG, "onResponse: \n " +
//                            "PostURL: " + posts.get(j).getPostURL() + "\n " +
//                            "ThumbnailURL: " + posts.get(j).getThumbnailURL() + "\n " +
//                            "Title: " + posts.get(j).getTitle() + "\n " +
//                            "Author: " + posts.get(j).getAuthor() + "\n " +
//                            "updated: " + posts.get(j).getDateUpdated() + "\n ");
//                }

            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "OnFailure: Unable to retrieve data" + t.getMessage());
                Toast.makeText(context.getApplicationContext(), "An Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }
}







