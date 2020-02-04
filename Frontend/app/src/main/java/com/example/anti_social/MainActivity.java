package com.example.anti_social;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameET = (EditText) findViewById(R.id.nameEditText);
                Intent homePageIntent = new Intent(getApplicationContext(),homeActivity.class);
                homePageIntent.putExtra("Mainactivity.name", nameET.getText().toString());
                startActivity(homePageIntent);
                nameET.setText("");
            }
        });
    }
}
