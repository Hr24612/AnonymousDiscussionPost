package com.example.anti_social;
// Helpful link for testing with json http://myjson.com/

import android.os.Bundle;

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
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.homePostViewRV);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(postTitles, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
