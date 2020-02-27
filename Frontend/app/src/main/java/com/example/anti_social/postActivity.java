package com.example.anti_social;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Activity page for post content on the app, displays the title and body of the post as well as user comments
 * Allows users to create and add new comments to the post
 */
public class postActivity extends AppCompatActivity {

    // public static final String TAG = "TEST";
    //RequestQueue Queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);


       // Queue = Volley.newRequestQueue(postActivity.this);

        if(getIntent().hasExtra("TEMPNAME")){  //TODO change name

            TextView titleTV = (TextView) findViewById(R.id.titleTV);
            TextView bodyTV = (TextView) findViewById(R.id.bodyTV);
            TextView tagsTV = (TextView) findViewById(R.id.tagsTV);
            EditText commentET = (EditText) findViewById(R.id.commentET);

            String jsonString = getIntent().getStringExtra("TEMPNAME"); //TODO change key name

            try {
                JSONObject post = new JSONObject(jsonString);

                titleTV.setText(post.getString("TITLE"));
                bodyTV.setText(post.getString("BODY"));
                tagsTV.setText(post.getString("TAGS"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //TODO Rework for comments or as backup if no intent extra
       /* JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, Const.POSTMAN_URL,null,
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
        Queue.add(request);*/
    }
}
