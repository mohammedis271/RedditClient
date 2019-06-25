package com.muaaz.joosuf.encrypted.redditclient.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.muaaz.joosuf.encrypted.redditclient.R;
import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JComments.CommentsDataHolder;
import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.JPosts.PostsData;
import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.RedditClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Comments extends AppCompatActivity {

    private final String BASE_URL = "https://www.reddit.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comments);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        RedditClient client = retrofit.create(RedditClient.class);
        Call<CommentsDataHolder> call = client.getPostComments();

        call.enqueue(new Callback<CommentsDataHolder>() {
            @Override
            public void onResponse(Call<CommentsDataHolder> call, Response<CommentsDataHolder> response) {
                Log.d("TAG","YAYY");
            }

            @Override
            public void onFailure(Call<CommentsDataHolder> call, Throwable t) {
                Log.d("TAG","NOOOO");
            }
        });
    }
}
