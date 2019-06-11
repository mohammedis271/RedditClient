package com.muaaz.joosuf.encrypted.redditclient.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.muaaz.joosuf.encrypted.redditclient.R;
import com.muaaz.joosuf.encrypted.redditclient.RSSHandler.Comment;

import java.util.List;
import java.util.Objects;

public class CustomArrayAdapter extends ArrayAdapter<Comment> {
    private int resource;
    private int lastPosition = -1;
    private Context context;

    public CustomArrayAdapter(@NonNull Context context, int resource,@NonNull List<Comment> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.author = convertView.findViewById(R.id.comment_author);
        viewHolder.comment = convertView.findViewById(R.id.comment_description);
        viewHolder.id = convertView.findViewById(R.id.comment_id);


        Animation animation = AnimationUtils.loadAnimation(context,
                (position > lastPosition) ? R.anim.load_down_animation : R.anim.load_up_animation);
        convertView.startAnimation(animation);
        lastPosition = position;

        viewHolder.author.setText(Objects.requireNonNull(getItem(position)).getAuthor());
        viewHolder.comment.setText(Objects.requireNonNull(getItem(position)).getContent());
        viewHolder.id.setText(Objects.requireNonNull(getItem(position)).getId());
        return convertView;
    }

    static class ViewHolder{
        TextView author, comment, id;

    }
}
