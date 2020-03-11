package com.example.anti_social;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.anti_social.app.AppController;
import com.example.anti_social.net_utils.Const;
import com.example.anti_social.recyclerViewAdapters.CommentRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Activity page for post content on the app, displays the title and body of the post as well as user comments
 * Allows users to create and add new comments to the post
 */
public class postActivity extends AppCompatActivity {

    private ArrayList<String> comments = new ArrayList<>();
    // public static final String TAG = "TEST";
    //RequestQueue Queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

       // Queue = Volley.newRequestQueue(postActivity.this);

        if(getIntent().hasExtra("postContent")){

            TextView titleTV = (TextView) findViewById(R.id.titleTV);
            TextView bodyTV = (TextView) findViewById(R.id.bodyTV);
            TextView tagsTV = (TextView) findViewById(R.id.tagsTV);
            //EditText commentET = (EditText) findViewById(R.id.commentET); //TODO change to recycler view stuff

            String jsonString = getIntent().getStringExtra("postContent");
            Log.d("postActivity", "string is " + jsonString);
            try {
                JSONObject post = new JSONObject(jsonString);
                titleTV.setText(post.getString("title"));
                bodyTV.setText(post.getString("body"));
                tagsTV.setText(post.getString("hashTag"));
                int postID = post.getInt("id");
                RequestQueue queue = AppController.getInstance().getRequestQueue();
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Const.getPostComments(postID),null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                for(int i = 0; i < response.length(); i++){
                                    try {
                                        comments.add(response.getJSONObject(i).getString("text"));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                initRecyclerView();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                queue.add(request);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.postCommentRV);
        CommentRecyclerView adapter = new CommentRecyclerView(comments, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
