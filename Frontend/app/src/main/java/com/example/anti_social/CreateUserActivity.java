package com.example.anti_social;

import android.os.Bundle;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        final EditText firstET = (EditText) findViewById(R.id.firstNameET);
        final EditText lastET = (EditText) findViewById(R.id.lastNameET);
        final EditText userET = (EditText) findViewById(R.id.userNameET);
        Button createBtn = (Button) findViewById(R.id.createUserBTN);

       createBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               RequestQueue queue = Volley.newRequestQueue(CreateUserActivity.this);
               Map<String, String> params = new HashMap<String, String>();
               params.put("firstName", firstET.getText().toString());
               params.put("lastName", lastET.getText().toString());
               params.put("userName", userET.getText().toString());

               //TODO move url to strings file
               JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "coms-309-sk-4.cs.iastate.edu:8080/api/user/createUser", new JSONObject(params),
                       new Response.Listener<JSONObject>() {
                           @Override
                           public void onResponse(JSONObject response) {
                               try {
                                   VolleyLog.v("Response:%n %s", response.toString(4));
                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }
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
