/*
package com.example.vallagtesena;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class search_class extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<MovieData> movieList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_search);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = MySingleton.getInstance(this).getRequestQueue();

        movieList = new ArrayList<>();
        search_movie_name("the batman");


    }
    String movieID;
    Context context;
    String Movie_search_URL="https://api.themoviedb.org/3/search/movie?api_key=46dcf0c9bfcce3c007dbf3d56df98402&language=en-US&query=";
    public search_class(Context context)
    {
        this.context=context;
    }
    public interface VolleyResponseListener
    {
        void  onError(String message);

        Void onResponse(String movieID);
    }
    public void search_movie_name(String Title)
    {
        List<MovieData>movie_data= new ArrayList<>();

        String URL=Movie_search_URL+Title;
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray movie_list = response.getJSONArray("results");
                    for (int i = 0; i < movie_list.length(); i++) {

                        JSONObject movie_from_search=(JSONObject) movie_list.get(i);
                        String title= movie_from_search.getString("original_title");
                        String overview=movie_from_search.getString("overview");
                        String posterID=movie_from_search.getString("poster_path");
                        String rating=movie_from_search.getString("vote_average");
                        String movieID=movie_from_search.getString("id");

                        MovieData one_movie=new MovieData(movieID,posterID, title, overview, rating);
                        movie_data.add(one_movie);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                movieAdapter adapter= new movieAdapter(context, movie_data);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(request);
    }
}
*/