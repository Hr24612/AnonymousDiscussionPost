package com.example.mtg_lifepoint_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        // Your buttons
        Button youMinusOne = (Button) findViewById(R.id.youMinusOne);
        Button youPlusOne  = (Button) findViewById(R.id.youPlusOne);
        Button youvarAdd   = (Button) findViewById(R.id.youVariableAdd);

        //oppButtons
        Button oppMinusOne = (Button) findViewById(R.id.oppMinusOne);
        Button oppPlusOne  = (Button) findViewById(R.id.oppPlusOne);
        Button oppvarAdd   = (Button) findViewById(R.id.oppVariableAdd);

        //Other Buttons
        Button resetButton = (Button) findViewById(R.id.resetButton);

        final int[] yourLife = {20};
        final int[] oppLife  = {20};

        youPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView youLife = (TextView) findViewById(R.id.youLife);
                yourLife[0]++;
                String resultPrint = yourLife[0] + "";
                youLife.setText(resultPrint);
            }
        });

        youMinusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView youLife = (TextView) findViewById(R.id.youLife);
                yourLife[0]--;
                String resultPrint = yourLife[0] + "";
                youLife.setText(resultPrint);
            }
        });

        youvarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView youLife = (TextView) findViewById(R.id.youLife);
                EditText youLifeChange = (EditText) findViewById(R.id.youLifeChange);
                String text = youLifeChange.getText().toString();
                youLifeChange.setText("");
                int output = (text.length()>0) ? Integer.parseInt(text): 0;
                yourLife[0]+=output;
                String resultPrint = yourLife[0] + "";
                youLife.setText(resultPrint);
            }
        });


        oppPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView oppLifeTV = (TextView) findViewById(R.id.oppLife);
                oppLife[0]++;
                String resultPrint = oppLife[0] + "";
                oppLifeTV.setText(resultPrint);
            }
        });

        oppMinusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView oppLifeTV = (TextView) findViewById(R.id.oppLife);
                oppLife[0]--;
                String resultPrint = oppLife[0] + "";
                oppLifeTV.setText(resultPrint);
            }
        });

        oppvarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView oppLifeTV = (TextView) findViewById(R.id.oppLife);
                EditText oppLifeChange = (EditText) findViewById(R.id.oppLifeChange);
                String text = oppLifeChange.getText().toString();
                oppLifeChange.setText("");
                int output = (text.length()>0) ? Integer.parseInt(text): 0;
                oppLife[0]+=output;
                String resultPrint = oppLife[0] + "";
                oppLifeTV.setText(resultPrint);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView youLife = (TextView) findViewById(R.id.youLife);
                TextView oppLifeTV = (TextView) findViewById(R.id.oppLife);
                yourLife[0] = 20;
                oppLife[0]  = 20;
                String resultPrint = yourLife[0] + "";
                youLife.setText(resultPrint);
                String oppString = oppLife[0] + "";
                oppLifeTV.setText(oppString);
            }
        });
    }
}
