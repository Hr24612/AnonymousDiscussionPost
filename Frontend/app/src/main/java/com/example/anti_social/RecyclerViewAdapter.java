package com.example.anti_social;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> postTitles = new ArrayList<>();
    private Context postListContext;

    public RecyclerViewAdapter(ArrayList<String> postTitles, Context postListContext) {
        this.postTitles = postTitles;
        this.postListContext = postListContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.postTitle.setText(postTitles.get(position));
        holder.listItemWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "you clicked on item " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postTitles.size();
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
