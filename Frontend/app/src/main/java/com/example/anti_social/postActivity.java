package com.example.anti_social;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.example.anti_social.app.AppController;
import com.example.anti_social.net_utils.Const;


public class postActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        

        StringRequest strReq = new StringRequest(Request.Method.GET, Const.POSTMAN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(AppController.TAG, response.toString());
                //pDialog.hide();

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(AppController.TAG, "Error: " + error.getMessage());
                // pDialog.hide();
            }

        });
        AppController.getInstance().addToRequestQueue(strReq, "testTag");
    }
}
