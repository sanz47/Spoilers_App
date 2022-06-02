package com.example.vallagtesena;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class signup extends AppCompatActivity {

    private static Integer eTime=0,series=0,movies=0,mTime=0;
    EditText firstName,lastName,email,password;
    static String fullname;
    TextView textepisodecount,textepisodewatched,textmovietime,textmoviecount;
    Button signupx;
    FirebaseAuth fAuth;
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    private FirebaseAuth newAuth;
    FirebaseFirestore fStore;
    static String userID;
    Button gobackx;
    private static final String USER = "user";
    private static final String TAG = "RegisterActivity";
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password_signup);
        signupx = (Button) findViewById(R.id.signup2);
        fullname=firstName.getText().toString()+" "+lastName.getText().toString();
        fAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USER);
        fStore = FirebaseFirestore.getInstance();

        signupx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                registerUser(email1,password1);

            }
        });
        Button gobackx=findViewById(R.id.go_back);
        gobackx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent class will help to go to next activity using
                // it's object named intent.
                // SecondActivty is the name of new created EmptyActivity.
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    /*    Toast.makeText(signup.this, "opened new intent",Toast.LENGTH_SHORT).show();
        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        newAuth=FirebaseAuth.getInstance();
        newAuth.createUserWithEmailAndPassword(email1, password1)
               .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           // Sign in success, update UI with the signed-in user's information
//                           Log.d(TAG, "createUserWithEmail:success");
                           FirebaseUser user = newAuth.getCurrentUser();
//                           updateUI(user);
                       } else {
                           // If sign in fails, display a message to the user.
//                           Log.w(TAG, "createUserWithEmail:failure", task.getException());
                           Toast.makeText(signup.this, "Authentication failed.",
                                   Toast.LENGTH_SHORT).show();
//                           updateUI(null);
                       }
                   }
               });

        signupx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(signup.this, "Clicked the button",Toast.LENGTH_SHORT).show();
                checkDataEntered();
                fAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup.this,"User Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(signup.this,"Error Occurred During Signup"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
*/
    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(firstName)) {
            Toast t = Toast.makeText(this, "Please Enter Your First Name !", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmpty(lastName)) {
            lastName.setError("Please Enter Your Last Name ! ");
        }

        if (!isEmail(email)) {
            email.setError("Please Enter Valid Email Address");
        }
    }

    public void registerUser(String email2,String password2){
        fAuth.createUserWithEmailAndPassword(email2,password2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String name1=firstName.getText().toString();
                    String name2=lastName.getText().toString();
                    String email1 = email.getText().toString();
                    String password1 = password.getText().toString();
                    Toast.makeText(signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    userID = fAuth.getCurrentUser().getUid();
                    DocumentReference documentReference=fStore.collection("users").document(userID);
                    Map<String,Object>user=new HashMap<>();
                    user.put("First Name",name1);
                    user.put("Last Name",name2);
                    user.put("Email",email1);
                    user.put("Movie Count",movies);
                    user.put("Series Count",series);
                    user.put("Movie Time",mTime);
                    user.put("Series Time",eTime);


                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Log.d(TAG,"User profile is created for "+userID);
                        }
                    });
                    email.setText("");
                    password.setText("");
                    firstName.setText("");
                    lastName.setText("");
                    Intent i = new Intent(signup.this, MainActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    Log.w(TAG,"createUserWithEmail:failure",task.getException());
                    Toast.makeText(signup.this, "Authentication Failed", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void updateUI(FirebaseUser currentUser){
        String keyID = mDatabase.push().getKey();
        mDatabase.child(keyID).setValue(user);
        Intent loginInternet = new Intent(this,MainActivity.class);
        startActivity(loginInternet);
    }

    public String getUserID(){
        userID = fAuth.getCurrentUser().getUid();
        return userID;
    }
    public static String getName(){
        return fullname;
    }
    public static Integer getSeries(){
        return series;
    }
    public static Integer getMovies(){
        return movies;
    }
    public static Integer getepiTime(){
        return eTime;
    }
    public static Integer getmTime(){
        return mTime;
    }
    public static String getUID(){
        return userID;
    }
    public static void increase(){
        ++movies;
    }
    public static void Timeincrease(){
        final int random = new Random().nextInt(39) + 20;
        mTime=mTime+2+(random/30);
    }
    public static void sIncrease(){
        ++series;
    }

}
