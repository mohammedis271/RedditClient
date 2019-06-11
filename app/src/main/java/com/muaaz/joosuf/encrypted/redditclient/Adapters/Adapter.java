package com.muaaz.joosuf.encrypted.redditclient.Adapters;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muaaz.joosuf.encrypted.redditclient.Utils.Async.ImageDownloadTask;
import com.muaaz.joosuf.encrypted.redditclient.R;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Post;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {
    private static final String TAG = "Adapter";


    private List<Post> posts;

    public Adapter(List<Post>posts){
        this.posts = posts;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_layout,viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.title.setText(posts.get(i).getAuthor());
        customViewHolder.description.setText(posts.get(i).getTitle());
        ImageDownloadTask imageDownloadTask = new ImageDownloadTask();
        try {
            Bitmap bitmap = imageDownloadTask.execute(posts.get(i).getThumbnailURL()).get();
            if(bitmap!=null){
                customViewHolder.image.setImageBitmap(bitmap);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, description;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_post);
            description = itemView.findViewById(R.id.description_post);
            image = itemView.findViewById(R.id.image_post);
        }
    }



}

