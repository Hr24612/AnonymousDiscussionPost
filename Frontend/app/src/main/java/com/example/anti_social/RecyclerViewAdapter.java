package com.example.anti_social;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<JSONObject> posts = new ArrayList<>();
    private Context postListContext;


    /**
     * A method for initializing a new RecyclerViewAdadpter.  An adapter is used for binding the items of a ViewHolder to that ViewHolder.  This specific adapter was made for rendering posts.
     * @param /postTitles This is ArrayList of all the post titles that needed to be rendered
     * @param postListContext This is the context in which the post titles are being rendered (An example would be an activity).
     */
    public RecyclerViewAdapter(ArrayList<JSONObject> posts, Context postListContext) {
        this.posts = posts;
        this.postListContext = postListContext;
    }

    /**
     * @param parent This is the target container for all the ViewHolder items listed in onBindViewHolder
     * @param viewType The type of view we are dealing with
     * @return Returns the ViewHolder so that it can be rendered.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * This function is used to generate each individual viewholder in our RecyclerView.  A ViewHolder can be loosely defined as
     *     each individual item in the RecyclerView.
     * @param holder This would be the ViewHolder object in which we are adding properties too. The ViewHolder object's specific layout can be found in the layout layout_listitem.xml
     *         in the layouts folder
     * @param position The position of this ViewHolder in the RecyclerView, e.g. if 3, than this is the third item down.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        try {
            holder.postTitle.setText(posts.get(position).getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        holder.listItemWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent postIntent = new Intent(postListContext.getApplicationContext(), postActivity.class);
                postIntent.putExtra("postContent", posts.get(position).toString());
                postListContext.startActivity(postIntent);
                Log.d(TAG, "you clicked on item " + position);
            }
        });
    }


    /**
     * This function returns the number of ViewHolders in this RecyclerView
     * @return The number of ViewHolders int his RecyclerView
     */
    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView postTitle;
        RelativeLayout listItemWrapper;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.postTitle);
            listItemWrapper = itemView.findViewById(R.id.listItemWrapper);
        }
    }
}
