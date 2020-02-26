package com.example.anti_social;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.anti_social.net_utils.Const;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Activity page for post content on the app, displays the title and body of the post as well as user comments
 * Allows users to create and add new comments to the post
 */
public class postActivity extends AppCompatActivity {

   // public static final String TAG = "TEST";
    RequestQueue Queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final TextView bodyTV = (TextView) findViewById(R.id.bodyTV);
        Queue = Volley.newRequestQueue(postActivity.this);

        //TODO Change POSTMAN_url to proper url once everything works
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Const.POSTMAN_URL,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for(int i = 0; i < response.length(); i++){           //TODO potentialy not a loop just go through json array and assign values individualy
                                JSONObject stuff = response.getJSONObject(i);     //TODO change this to be for proper format for post
                                bodyTV.setText(stuff.getString("title"));   //TODO this as well
                            }
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
        Queue.add(request);
    }
}
