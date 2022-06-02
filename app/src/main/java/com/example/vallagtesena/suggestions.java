package com.example.vallagtesena;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class suggestions extends AppCompatActivity {
    Button seriesFragment,goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);
        seriesFragment=findViewById(R.id.series_frag);
        seriesFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(suggestions.this, series_suggestions.class);
                startActivity(i);
            }
        });
        goback=findViewById(R.id.go_back);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(suggestions.this, homepage.class);
                startActivity(intent);
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
                Intent w = new Intent(suggestions.this, homepage.class);
                startActivity(w);
                break;
            case R.id.suggestions:
                Intent d = new Intent(suggestions.this, suggestions.class);
                startActivity(d);
                break;
            case R.id.nav_movie:
                Intent s = new Intent(suggestions.this, Watchlist.class);
                startActivity(s);
                break;
            case R.id.nav_tv:
                Intent a = new Intent(suggestions.this, wishlist.class);
                startActivity(a);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}




// get the reference of Button's


// perform setOnClickListener event on First Button
