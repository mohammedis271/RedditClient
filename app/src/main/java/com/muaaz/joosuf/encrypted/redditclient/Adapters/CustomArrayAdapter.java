package com.muaaz.joosuf.encrypted.redditclient.Adapters;

public class CustomArrayAdapter /*extends ArrayAdapter<Comment>*/ {
//    private int resource;
//    private int lastPosition = -1;
//    private Context context;
//
//    public CustomArrayAdapter(@NonNull Context context, int resource,@NonNull List<Comment> objects) {
//        super(context, resource, objects);
//        this.resource = resource;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
//

//        LayoutInflater inflater = LayoutInflater.from(context);
//        convertView = inflater.inflate(resource, parent, false);
//        ViewHolder viewHolder = new ViewHolder();
//        viewHolder.author = convertView.findViewById(R.id.comment_author);
//        viewHolder.comment = convertView.findViewById(R.id.comment_description);
//        viewHolder.id = convertView.findViewById(R.id.comment_id);
//
//
//        Animation animation = AnimationUtils.loadAnimation(context,
//                (position > lastPosition) ? R.anim.load_down_animation : R.anim.load_up_animation);
//        convertView.startAnimation(animation);
//        lastPosition = position;
//
//        viewHolder.author.setText(Objects.requireNonNull(getItem(position)).getAuthor());
//        viewHolder.comment.setText(Objects.requireNonNull(getItem(position)).getContent());
//        viewHolder.id.setText(Objects.requireNonNull(getItem(position)).getId());
//        return convertView;
//    }
//
//    static class ViewHolder{
//        TextView author, comment, id;
//
//    }
}
