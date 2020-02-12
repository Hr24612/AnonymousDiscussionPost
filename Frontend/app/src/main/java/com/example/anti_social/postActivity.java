package com.example.anti_social;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.anti_social.net_utils.Const;


public class postActivity extends AppCompatActivity {

    public static final String TAG = "TEST";
    RequestQueue Queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final TextView bodyTV = (TextView) findViewById(R.id.bodyTV);
        Queue = Volley.newRequestQueue(postActivity.this);

        StringRequest strReq = new StringRequest(Request.Method.GET, Const.POSTMAN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "SERVER RESPONSE: " + response);

                bodyTV.setText(response);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                bodyTV.setText(error.getMessage());
            }
        });

        Queue.add(strReq);
        //AppController.getInstance().addToRequestQueue(strReq, "testTag");
    }
}
