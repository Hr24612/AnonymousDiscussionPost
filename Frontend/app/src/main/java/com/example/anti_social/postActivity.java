package com.example.anti_social;

import android.os.Bundle;
import android.util.Log;
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

        if(getIntent().hasExtra("postContent")){

            TextView titleTV = (TextView) findViewById(R.id.titleTV);
            TextView bodyTV = (TextView) findViewById(R.id.bodyTV);
            TextView tagsTV = (TextView) findViewById(R.id.tagsTV);
            //EditText commentET = (EditText) findViewById(R.id.commentET); //TODO change to recycler view stuff

            String jsonString = getIntent().getStringExtra("postContent");
            Log.d("postActivity", "string is " + jsonString);

            try {
                JSONObject post = new JSONObject(jsonString);

               fillPostContent(post);

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
                            for(int i = 0; i < response.length(); i++){         //TODO potential not a loop just go through json array and assign values individually
                                JSONObject stuff = response.getJSONObject(i);   //TODO change this to be for proper format for post
                                bodyTV.setText(stuff.getString("title"));       //TODO this as well
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

    public void fillPostContent(JSONObject post) throws JSONException {

        TextView titleTV = (TextView) findViewById(R.id.titleTV);
        TextView bodyTV = (TextView) findViewById(R.id.bodyTV);
        TextView tagsTV = (TextView) findViewById(R.id.tagsTV);

        titleTV.setText(post.getString("title"));
        bodyTV.setText(post.getString("BODY"));
        tagsTV.setText(post.getString("TAGS"));
    }

    public String getPostTitle(){
        TextView titleTV = (TextView) findViewById(R.id.titleTV);
        return titleTV.getText().toString();

    }

    public String getPostBody(){
        TextView bodyTV = (TextView) findViewById(R.id.bodyTV);
        return bodyTV.getText().toString();

    }
    public String getPostTag(){
        TextView tagsTV = (TextView) findViewById(R.id.tagsTV);
        return tagsTV.getText().toString();

    }

}
