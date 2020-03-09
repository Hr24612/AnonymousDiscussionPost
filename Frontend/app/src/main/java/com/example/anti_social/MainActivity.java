package com.example.anti_social;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.anti_social.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Initial page for user login button
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);
        Button createUserBtn = (Button) findViewById(R.id.createNewUserBtn);
        TextView userFoundTV = (TextView) findViewById(R.id.userNotFoundTV);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //TODO check if user exists
                EditText nameET = (EditText) findViewById(R.id.nameEditText);
                final int[] found = {0};
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Const.getUserByName(nameET.getText().toString()),null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                found[0] = 1;
                                try {
                                    String id = response.getString("id");

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

                if(found[0] == 1) {
                    Intent homePageIntent = new Intent(getApplicationContext(), homeActivity.class);
                    homePageIntent.putExtra("Mainactivity.id", nameET.getText().toString());
                    startActivity(homePageIntent);
                    nameET.setText("");
                }
                else{

                }
            }
        });

        createUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createNewUserIntent = new Intent(getApplicationContext(), CreateUserActivity.class);
                startActivity(createNewUserIntent);
            }
        });


    }
}
