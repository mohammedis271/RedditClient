package com.muaaz.joosuf.encrypted.redditclient.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.muaaz.joosuf.encrypted.redditclient.Adapters.CustomArrayAdapter;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Comment;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers.ExtractXML;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Parsers.XMLHandler;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Post;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.XMLTags.Entry;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.XMLTags.Feed;
import com.muaaz.joosuf.encrypted.redditclient.Utils.Async.ImageDownloadTask;
import com.muaaz.joosuf.encrypted.redditclient.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class Comments extends AppCompatActivity {
    TextView title, author;
    ImageView thumbnail;
    ListView commentsList;
    private String commentURL;
    private final String BASE_URL = "https://www.reddit.com/r/";
    private final String TAG = "Comments";
    private ArrayList<Comment> comments = new ArrayList<>();
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comments);

        title = findViewById(R.id.title_post);
        author = findViewById(R.id.description_post);
        thumbnail = findViewById(R.id.image_post);
        commentsList = findViewById(R.id.comments_listView);

        Intent intent = getIntent();

        title.setText(intent.getStringExtra("title"));
        author.setText(intent.getStringExtra("author"));
        ImageDownloadTask imageDownloadTask = new ImageDownloadTask();
        try {
            Bitmap bitmap = imageDownloadTask.execute(intent.getStringExtra("thumbnailURL")).get();
            if (bitmap != null) {
                thumbnail.setImageBitmap(bitmap);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, intent.getStringExtra("postURL"), Toast.LENGTH_SHORT).show();
        String postURL = intent.getStringExtra("postURL");
        String[] url = postURL.split(BASE_URL);

        commentURL = url[1];
        Log.d(TAG, "Server Message :" + commentURL);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        XMLHandler xmlHandler = retrofit.create(XMLHandler.class);
        Call<Feed> call = xmlHandler.getCommentsPageFeed(commentURL);

        call.enqueue(new Callback<Feed>() {
            @Override
            public void onResponse(Call<Feed> call, Response<Feed> response) {
                Log.d(TAG, "Server Message :" + response.toString());

                assert response.body() != null;
                List<Entry> entries = response.body().getEntries();
                if (entries != null) {
                    for (int j = 0; j < entries.size(); j++) {
                        ExtractXML extractXML = new ExtractXML(entries.get(j).getContent(), "<div class=\"md\"><p>", "</p>");
                        List<String> commentFeed = extractXML.start();

                        try{
                            comments.add(new Comment(
                                    entries.get(j).getAuthor().getUri(),
                                    entries.get(j).getAuthor().getName(),
                                    commentFeed.get(0),
                                    entries.get(j).getId()
                            ));
                        }catch (Exception e){
                            e.getMessage();
                            e.printStackTrace();
                            Log.d(TAG,"Comment thread broke at " + j );
                            comments.add(new Comment(
                                    "ERROR"
                                    ,"ERROR"
                                    ,"ERROR"
                                    ,"ERROR"
                            ));
                        }
                    }

                    CustomArrayAdapter adapter = new CustomArrayAdapter(Comments.this,R.layout.comments_layout,comments);
                    commentsList.setAdapter(adapter);

                } else {
                    Toast.makeText(Comments.this, "NO COMMENTS TO SHOW", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Feed> call, Throwable t) {
                Log.e(TAG, "OnFailure: Unable to retrieve data" + t.getMessage());
                Toast.makeText(context.getApplicationContext(), "An Error Occurred", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
