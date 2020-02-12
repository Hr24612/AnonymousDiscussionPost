package com.example.anti_social;
// Helpful link for testing with json http://myjson.com/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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


        Button postBtn = (Button) findViewById(R.id.postBtn);

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postIntent = new Intent(getApplicationContext(), postActivity.class);
                startActivity(postIntent);
            }
        });

    }
}
