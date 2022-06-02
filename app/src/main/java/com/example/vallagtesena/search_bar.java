package com.example.vallagtesena;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class search_bar extends AppCompatActivity {
    Button goback,searchMoviebtn,searchSeriesBtn;
    EditText searchContent;
    static String new_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);
        Button goback=findViewById(R.id.go_back);
        searchContent=findViewById(R.id.searchbar);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(search_bar.this, homepage.class);
                startActivity(intent);
            }
        });

        Button searchMoviebtn=findViewById(R.id.searchMoviebtn);
        searchMoviebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(search_bar.this, searchMainActivity.class);
                new_search=searchContent.getText().toString();
                startActivity(intent2);

            }
        });

        Button searchSerialbtn=findViewById(R.id.searchSerialbtn);
        searchSerialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(search_bar.this, SearchSeriesActivity.class);
                new_search=searchContent.getText().toString();
                startActivity(intent3);
            }
        });
    }
}