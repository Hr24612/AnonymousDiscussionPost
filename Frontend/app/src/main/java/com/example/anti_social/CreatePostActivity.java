package com.example.anti_social;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.anti_social.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * This activity is intended to be viewed by a user who wants to create a new post
 * The activity allows the user to enter a title and body for the post and add tags
 */
public class CreatePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        Log.d("CPActivityStart","Creating CreatePostActivity");
        Button submitPostBtn = (Button) findViewById(R.id.submitPostBtn);
        final EditText postTitleET = (EditText) findViewById(R.id.postTitleET);
        final EditText bodyET = (EditText) findViewById(R.id.bodyET);
        final EditText tagsET = (EditText) findViewById(R.id.tagsET);

        submitPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(CreatePostActivity.this);
                Map<String, String> params = new HashMap<String, String>();
                params.put("title", postTitleET.getText().toString());
                params.put("body", bodyET.getText().toString());
                params.put("hashTag", tagsET.getText().toString());

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, Const.CREATEPOST, new JSONObject(params),
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    VolleyLog.v("Response:%n %s", response.toString(4));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                postTitleET.setText("");
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.e("Error: ", error.getMessage());
                    }
                });
                queue.add(request);

            }
        });
    }
}