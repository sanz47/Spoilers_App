package com.example.vallagtesena;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class homepage extends AppCompatActivity {
    Button episodecount,episodewatched,movietime,moviecount,recentseries,goback;
    TextView textepisodecount,textepisodewatched,textmovietime,textmoviecount,Name;
    String sss;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    ImageView imageView,baymax;
    Integer a=300,b=223,c=101,d=46,e=42,f=54;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        episodecount=findViewById(R.id.episodecount);
        textepisodecount=findViewById(R.id.textepisodecount);

        episodewatched=findViewById(R.id.episodeswatched);
        textepisodewatched=findViewById(R.id.textepisodeswatched);

        movietime=findViewById(R.id.movietime);
        textmovietime=findViewById(R.id.textmovietime);

        moviecount=findViewById(R.id.moviecount);
        textmoviecount=findViewById(R.id.textmoviecount);

        recentseries=findViewById(R.id.recentmovies);
        Name=findViewById(R.id.name);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID=fAuth.getCurrentUser().getUid();
        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                Name.setText(value.getString("First Name")+" "+value.getString("Last Name"));
               // textepisodecount.setText(value.getString("Series Count"));
            }
        });

        episodecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                episodecount.setVisibility(View.INVISIBLE);
                a=signup.getSeries();
                textepisodecount.setText(a + " Series ");
                episodecount.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        episodecount.setVisibility(view.VISIBLE);
                    }
                },3000);

            }
        });
        sss=signup.getName();
        Name.setText(sss);
        episodewatched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                episodewatched.setVisibility(View.INVISIBLE);
                c=signup.getepiTime();
                textepisodewatched.setText(c+" Hours");
                episodewatched.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        episodewatched.setVisibility(view.VISIBLE);
                    }
                },3000);

            }
        });

        movietime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movietime.setVisibility(View.INVISIBLE);
                b=signup.getMovies();
                textmovietime.setText(b + " Movies");
                movietime.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        movietime.setVisibility(view.VISIBLE);
                    }
                },3000);

            }
        });

        moviecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moviecount.setVisibility(View.INVISIBLE);
                e=signup.getmTime();
                textmoviecount.setText(e+" Hours");
                moviecount.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        moviecount.setVisibility(view.VISIBLE);
                    }
                },3000);

            }
        });

        recentseries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(homepage.this, SeriesList.class);
                startActivity(i);
            }
        });
        imageView = findViewById(R.id.first);

        // Apply OnClickListener  to imageView to
        // switch from one activity to another
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(homepage.this, dark.class);
                startActivity(intent);
            }
        });

        baymax = findViewById(R.id.baymax_seg);

        // Apply OnClickListener  to imageView to
        // switch from one activity to another
        baymax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent2 = new Intent(homepage.this, baymax.class);
                startActivity(intent2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.bottom_nav_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.suggestions:
                Intent sg = new Intent(homepage.this, MainActivity.class);
                startActivity(sg);
                break;
            case R.id.nav_movie:
                Intent s = new Intent(homepage.this, Watchlist.class);
                startActivity(s);
                break;
            case R.id.nav_tv:
                Intent a = new Intent(homepage.this, wishlist.class);
                startActivity(a);
                break;
            case R.id.help:
                Intent h = new Intent(homepage.this, help.class);
                startActivity(h);
                break;
            case R.id.action_search:
                Intent bb=new Intent(homepage.this,search_bar.class);
                startActivity(bb);
        }
        return super.onOptionsItemSelected(item);
    }

  //  public boolean onOptionsItemSelected(@NonNull MenuItem item){
  //      switch (item.getItemId()){
  //          case android.R.id.home:
  //              this.finish();
  //              return true;
   //     }
   //     return super.onOptionsItemSelected(item);
  //  }
}