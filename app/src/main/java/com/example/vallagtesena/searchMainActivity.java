package com.example.vallagtesena;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vallagtesena.placeholder.Movie;
import com.example.vallagtesena.placeholder.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class searchMainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Movie> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);
        Button gobackx=findViewById(R.id.go_back);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        movieList = new ArrayList<>();
        fetchMovies(search_bar.new_search);
        Button goback=findViewById(R.id.go_back);
        gobackx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(searchMainActivity.this, search_bar.class);
                startActivity(intent);
            }
        });


    }

    private void fetchMovies(String movie_name) {

        String movie_url = "https://api.themoviedb.org/3/search/movie?api_key=46dcf0c9bfcce3c007dbf3d56df98402&language=en-US&query=";
        String poster_init="https://image.tmdb.org/t/p/w500";
        String url=movie_url+movie_name;

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, null, new Response.Listener<JSONObject>(){

        //JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                //new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                        JSONArray movie_list= response.getJSONArray("results");

                        for (int i = 0 ; i < movie_list.length() ; i ++){

                                JSONObject jsonObject = movie_list.getJSONObject(i);
                                String title = jsonObject.getString("original_title");
                                String overview = jsonObject.getString("overview");
                                String poster = poster_init+jsonObject.getString("poster_path");
                                Double rating = jsonObject.getDouble("vote_average");
                                String ID=jsonObject.getString("id");

                                Movie movie = new Movie(title , poster , overview , rating, ID,"0");
                                movieList.add(movie);
                            }

                            MovieAdapter adapter = new MovieAdapter(searchMainActivity.this , movieList);

                            recyclerView.setAdapter(adapter);
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(searchMainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}