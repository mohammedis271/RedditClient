package com.muaaz.joosuf.encrypted.redditclient.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muaaz.joosuf.encrypted.redditclient.R;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {
    private static final String TAG = "Adapter";




    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_layout,viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 1;
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

