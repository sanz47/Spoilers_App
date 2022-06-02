package com.example.vallagtesena;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.bumptech.glide.Glide;
import com.example.vallagtesena.placeholder.Movie;

public class DetailActivity extends AppCompatActivity {
    Button gobackx;
    SwitchCompat switchCompat;
    SwitchCompat switchCompat2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Button exit,confirm,total;



        EditText editText=findViewById(R.id.no_of_episodes);
        exit=findViewById(R.id.exit);
        total=findViewById(R.id.total);
        confirm=findViewById(R.id.confirm);
        ImageView imageView = findViewById(R.id.poster_image);
        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mTitle);
        TextView overview_tv = findViewById(R.id.movervie_tv);
        switchCompat=findViewById(R.id.switch2);
        switchCompat=findViewById(R.id.switch1);
        Bundle bundle = getIntent().getExtras();
        String mTitle = bundle.getString("title");
        String mPoster = bundle.getString("poster");
        String mOverView = bundle.getString("overview");

        double mRating = bundle.getDouble("rating");
        String ID = bundle.getString("id");
        String srs=bundle.getString("srs");
        Movie movie=new Movie(mTitle, mPoster, mOverView,mRating,ID, srs);

        if(srs.equals("1")){
            total.setVisibility(View.VISIBLE);
            editText.setVisibility(View.VISIBLE);
            String S=editText.getText().toString();
            total.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(
                            DetailActivity.this,searchMainActivity.class

                    );
                    signup.sIncrease();
                    startActivity(intent);

                }
            });
        }
        CharSequence no = editText.getText().toString();
        if (!(no.equals("0"))){
            SharedPreferences sharedPreferences2=getSharedPreferences("save",MODE_PRIVATE);
            SharedPreferences.Editor editor=getSharedPreferences("save",MODE_PRIVATE).edit();
            editor.putBoolean("value",true);
            editor.apply();
            switchCompat.setChecked(true);
        }
        SharedPreferences sharedPreferences=getSharedPreferences("save",MODE_PRIVATE);
        //switchCompat.setChecked(sharedPreferences.getBoolean("value",false));
        switchCompat.setChecked(sharedPreferences.getBoolean("value",true));
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchCompat.isChecked()){
                    SharedPreferences.Editor editor=getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    switchCompat.setChecked(true);

                }
                else{
                    SharedPreferences.Editor editor = getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    switchCompat.setChecked(false);
                }
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



//                FirebaseFirestore db = FirebaseFirestore.getInstance();
//                String uID= FirebaseAuth.getInstance().getCurrentUser().getUid();
//                DocumentReference documentReference = db.collection("users").document(uID);
//                Toast.makeText(DetailActivity.this,"Done",Toast.LENGTH_SHORT).show();
////
////
////
//                documentReference.addSnapshotListener(DetailActivity.this, new EventListener<DocumentSnapshot>() {
//                    @Override
//                    public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//
//
//
//                        //value.getString("First Name");
//
//                        String name1=value.getString("First Name");
//                        String name2=value.getString("Last Name");
//                        String mail=value.getString("Email");
//                        String mcount=value.getString("Movie Count");
//                        String scount=value.getString("Series Count");
//                        String mtime=value.getString("Movie Time");
//                        String stime=value.getString("Series Time");
//                        Integer cnt=Integer.parseInt(mcount)+1;
//                        mcount=cnt.toString();
//                        Map<String,Object> user=new HashMap<>();
//                        user.put("First Name",name1);
//                        user.put("Last Name",name2);
//                        user.put("Email",mail);
//                        user.put("Movie Count",mcount);
//                        user.put("Series Count",scount);
//                        user.put("Movie Time",mtime);
//                        user.put("Series Time",stime);
//                        documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void unused) {
//                                Toast.makeText(DetailActivity.this, "Updated", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                });

                Intent intent = new Intent(
                        DetailActivity.this,searchMainActivity.class
                );
                signup.increase();
                signup.Timeincrease();
//                if(srs.equals("0")){
//                    Watchlist.add_on_movieList(movie);
//                }
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(
                        DetailActivity.this,searchMainActivity.class
                );
                startActivity(intent2);
            }
        });

        Glide.with(this).load(mPoster).into(imageView);
        rating_tv.setText(Double.toString(mRating));
        title_tv.setText(mTitle);
        overview_tv.setText(mOverView);
        Button gobackx=findViewById(R.id.go_back);
        gobackx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(DetailActivity.this, searchMainActivity.class);
                startActivity(intent);
            }
        });

    }
}