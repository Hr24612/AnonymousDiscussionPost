package com.example.anti_social;
// Helpful link for testing with json http://myjson.com/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class homeActivity extends AppCompatActivity {
    private ArrayList<String> postTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if(getIntent().hasExtra("Mainactivity.name")){
            RecyclerView postRecyler = (RecyclerView) findViewById(R.id.homePostViewRV);
            RecyclerView.LayoutManager postLayoutManager = new LinearLayoutManager(this);
            postRecyler.setLayoutManager(postLayoutManager);
            for(int i = 0; i < 50;i++){
                postTitles.add("Item " + i);
            }
            initRecyclerView();
        }


        Button postBtn = (Button) findViewById(R.id.postBtn);

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postIntent = new Intent(getApplicationContext(), postActivity.class);
                startActivity(postIntent);
            }
        });

    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.homePostViewRV);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(postTitles, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
