package com.example.anti_social;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class homeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if(getIntent().hasExtra("Mainactivity.name")){
            TextView testTV = (TextView) findViewById(R.id.testTV);
            testTV.setText(getIntent().getExtras().getString("Mainactivity.name"));
        }
    }
}
