package com.muaaz.joosuf.encrypted.redditclient.Activities;
/**
 * Current Viewing Activity
 * Created by: Muaaz Joosuf
 * Date: 09/06/2019
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.muaaz.joosuf.encrypted.redditclient.R;
import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.RedditClient;
import com.muaaz.joosuf.encrypted.redditclient.RedditClientApi.oauth2.AccessToken;

import java.util.Base64;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private String clientID = "KrgtE63m3uj52w";
    private String redirectURI = "redditclient://callback";
    private final String BASE_URL = "https://www.reddit.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onResume() {
        super.onResume();
        Uri uri = getIntent().getData();

        if(uri!=null && uri.toString().startsWith(redirectURI)){
//            Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show();
            Log.d("TAG",uri.toString());
            String code = uri.getQueryParameter("code");
            Log.d("TAG",code);

            HashMap<String,String> headers = new HashMap<>();

            headers.put("Authorization", "Basic " + Base64.getEncoder().encodeToString((clientID + ":").getBytes()));

            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.build();

            RedditClient client = retrofit.create(RedditClient.class);
            Call<AccessToken> call = client.getAccessToken(
                    headers,
                    "authorization_code",
                    code,
                    redirectURI
            );
            call.enqueue(new Callback<AccessToken>() {
                @Override
                public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                    Log.d("TAG","YAY!");
                    if(!response.isSuccessful()) {
                        return;
                    }else{
                        Log.d("TAG", response.body().getAccess_token());
                    }

                }

                @Override
                public void onFailure(Call<AccessToken> call, Throwable t) {
                    Log.d("TAG","YAY!");
                }
            });
        }
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
        Intent intent = new Intent(getApplicationContext(),Comments.class);
        startActivity(intent);
    }

    public void loginIntent(View view){
//        Intent intent = new Intent(getApplicationContext(),Login.class);
//        startActivity(intent);


        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                "https://www.reddit.com/api/v1/authorize.compact?"
                        + "client_id=" + clientID + "&response_type=code" + "&state=qwerty"
                        + "&redirect_uri="+redirectURI + "&duration=permanent" + "&scope=identity, edit, flair, history, modconfig, modflair, modlog, modposts, modwiki, mysubreddits, privatemessages, read, report, save, submit, subscribe, vote, wikiedit, wikiread"
        ));
        startActivity(intent);

    }
}
