package com.muaaz.joosuf.encrypted.redditclient;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers.ExtractXML;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers.XMLHandler;
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

public class FrontPage extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;


    private static final String TAG = "RSSToFrontPage";
    private static final String BASE_URL = "https://www.reddit.com/";
    private final ArrayList<Post> posts = new ArrayList<>();
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        String type = "hot";

        XMLHandler xmlHandler = retrofit.create(XMLHandler.class);
        Call<Feed> call = xmlHandler.getFrontPageFeed(type);

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                List<Entry> entries = response.body().getEntries();
                Log.d(TAG, "onResponse: Server Response" + entries.get(1).getContent());
                for (int i = 0 ; i<entries.size();i++){
                    ExtractXML extractXML1 = new ExtractXML(entries.get(i).getContent(),"<a href=");
                    List<String> postContent = extractXML1.start();

                    ExtractXML extractXML2 = new ExtractXML(entries.get(i).getContent(),"<img src=");
                    try{
                        postContent.add(extractXML2.start().get(0));
                    }catch (NullPointerException e){
                        postContent.add(null);
//                        Log.e(TAG, "onResponse: NullPointerException: " + e.getMessage());
                    }catch (IndexOutOfBoundsException e){
                        postContent.add(null);
//                        Log.e(TAG, "onResponse: IndexOutOfBoundsException: " + e.getMessage());
                    }
                    //saving posts
                    posts.add(new Post(
                            entries.get(i).getTitle(),
                            entries.get(i).getAuthor().getName(),
                            entries.get(i).getUpdated(),
                            postContent.get(0),
                            postContent.get(postContent.size()-1)
                    ));
                }
                generateDataList(posts);
            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG,"OnFailure: Unable to retrieve data" + t.getMessage());
                Toast.makeText(context.getApplicationContext(), "An Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void generateDataList(List<Post> posts) {
        recyclerView = findViewById(R.id.front_page_recycler_view);
        adapter = new Adapter(posts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FrontPage.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
