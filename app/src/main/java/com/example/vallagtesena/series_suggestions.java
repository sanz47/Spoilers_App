package com.example.vallagtesena;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class series_suggestions extends AppCompatActivity {
    Button movieFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_suggestions);
        movieFragment=findViewById(R.id.movie_frag);
        movieFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(series_suggestions.this, suggestions.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bottom_nav_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.home:
                Intent w = new Intent(series_suggestions.this, homepage.class);
                startActivity(w);
                break;
            case R.id.nav_movie:
                Intent s = new Intent(series_suggestions.this, Watchlist.class);
                startActivity(s);
                break;
            case R.id.nav_tv:
                Intent a = new Intent(series_suggestions.this, wishlist.class);
                startActivity(a);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}


