package com.example.vallagtesena;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button signup, login;

   private FirebaseAuth mAuth;


   @Override
   public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        setupUI();
        checkDataEntered();
       setupListeners();
       mAuth = FirebaseAuth.getInstance();
//       mAuth.createUserWithEmailAndPassword("vogcod@gmail.com", "_ihfhAdd8f;d")
//               .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
//                   @Override
//                   public void onComplete(@NonNull Task<AuthResult> task) {
//                       if (task.isSuccessful()) {
//                           // Sign in success, update UI with the signed-in user's information
//                          Log.d(TAG, "createUserWithEmail:success");
//                           FirebaseUser user = mAuth.getCurrentUser();
//                           updateUI(user);
//                       } else {
//                           // If sign in fails, display a message to the user.
//                           Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                          Toast.makeText(MainActivity.this, "Authentication failed.",
//                                   Toast.LENGTH_SHORT).show();
//                          updateUI(null);
//                      }
//                   }
//               });
  }
//
//
//    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
//            new FirebaseAuthUIActivityResultContract(),
//            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
//                @Override
//                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
//                    onSignInResult(result);
//                }
//            }
//    );
//
//    List<AuthUI.IdpConfig> providers = Arrays.asList(
//            new AuthUI.IdpConfig.EmailBuilder().build(),
//            new AuthUI.IdpConfig.GoogleBuilder().build();
//
//
//    Intent signInIntent = AuthUI.getInstance()
//            .createSignInIntentBuilder()
//            .setAvailableProviders(providers)
//            .build();
//signInLauncher.launch(signInIntent);

    void checkDataEntered() {

        if (isEmpty(password)) {
            password.setError("This Section cannot be Left Empty!");
        }

        if (!isEmail(username)) {
            username.setError("Please Enter Valid Email Address");
        }
    }


    void checkUsername () {
        boolean isValid = true;

        if (isEmpty(username)) {
            username.setError("You Must Enter an Username to Login !");
            isValid = false;
        }
        if (!isEmail(username)) {
                username.setError("Enter Valid Email !");
                isValid = false;
            }

        if (isValid) {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();

            //background bg= new background(this);
            //bg.execute(user,pass);*/

            if (usernameValue.equals("test@test.com") && passwordValue.equals("test")) {
               Intent i = new Intent(MainActivity.this, homepage.class);
               startActivity(i);
               this.finish();
            } else {
                Toast t = Toast.makeText(this, "Wrong email or password entered !", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }


    private void setupUI () {
        username = findViewById(R.id.username);
        password = findViewById(R.id.PasswordLogin);
        signup = findViewById(R.id.signup_button);
        login = findViewById(R.id.login_button);
        mAuth = FirebaseAuth.getInstance();
    }

    private void setupListeners () {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                mAuth.signInWithEmailAndPassword(usernameValue,passwordValue).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(MainActivity.this, homepage.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Clicked",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, signup.class);

                startActivity(i);

            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }


    boolean isEmpty (EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }


}

