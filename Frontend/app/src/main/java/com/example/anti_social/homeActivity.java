package com.example.anti_social;
// Helpful link for testing with json http://myjson.com/

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class homeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if(getIntent().hasExtra("Mainactivity.name")){
            RecyclerView postRecyler = (RecyclerView) findViewById(R.id.homePostViewRV);
            RecyclerView.LayoutManager postLayoutManager = new LinearLayoutManager(this);
            postRecyler.setLayoutManager(postLayoutManager);
            final TextView testTV = (TextView) findViewById(R.id.testTV);
            RequestQueue queue = Volley.newRequestQueue(homeActivity.this);
            String url ="https://api.myjson.com/bins/11ujto";
            //This Method will get the full json response for the get request with the url given above. e.g. may need to be parsed
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    testTV.setText("Reponse : " + response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    testTV.setText("Reponse : 404");
                }
            });
            queue.add(stringRequest);
        }
    }
}
