package com.example.anti_social;
// Helpful link for testing with json http://myjson.com/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.anti_social.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {
    private ArrayList<String> postTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getIntent().hasExtra("Mainactivity.name")){
            RecyclerView postRecyler = (RecyclerView) findViewById(R.id.homePostViewRV);
            RecyclerView.LayoutManager postLayoutManager = new LinearLayoutManager(this);
            postRecyler.setLayoutManager(postLayoutManager);
            AppController controller = new AppController();
            RequestQueue queue = Volley.newRequestQueue(homeActivity.this);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "https://api.myjson.com/bins/1ddf34",null,
                    new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("Posts");

                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject post = jsonArray.getJSONObject(i);
                            postTitles.add(post.getString("Title"));
                        }
                        initRecyclerView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
            queue.add(request);
        }
        Button createPostBtn = (Button) findViewById(R.id.createPostBtn);
        createPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createPostIntent = new Intent(getApplicationContext(), CreatePostActivity.class);
                startActivity(createPostIntent);
            }
        });
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.homePostViewRV);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(postTitles, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
