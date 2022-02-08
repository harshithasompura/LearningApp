package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.learningapp.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting binding variable
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        //get fields
        username = findViewById(R.id.etUserName);
        password = findViewById(R.id.etPassword);

        //programmatically creating the button onClick
        this.binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,LessonList.class);
                Log.d(TAG, "Login button pressed");

                //check if the user has entered BOTH the fields i.e. SHOULD NOT be empty
                if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    //display fields can't be empty
                    //Log.d(TAG, "Please enter all the required fields!");

                    Snackbar snackbar = Snackbar.make(view, "Please enter all the fields", Snackbar.LENGTH_LONG);
                    snackbar.setBackgroundTint(Color.rgb(255,249,233));
                    snackbar.setTextColor(Color.rgb(255,192,46));
                    snackbar.show();

                    //clear the fields
                    username.getText().clear();
                    password.getText().clear();
                }

                //both the fields are entered
                if(!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    //display fields can't be empty
                    //Log.d(TAG, "The user has entered required fields!");

                    String enteredUsername = username.getText().toString();
                    String enteredPassword = password.getText().toString();

                    if(!enteredUsername.equals("abcd")) {
                        //user enters something other than abcd
                        Snackbar snackbar = Snackbar.make(view, "The username does not exist", Snackbar.LENGTH_LONG);
                        snackbar.setBackgroundTint(Color.rgb(255,233,217));
                        snackbar.setTextColor(Color.rgb(244,86,40));
                        snackbar.show();

                        //clear the fields
                        username.getText().clear();
                        password.getText().clear();

                    } else {
                        Snackbar snackbar = Snackbar.make(view, "The username/password combination does not match", Snackbar.LENGTH_LONG);
                        snackbar.setBackgroundTint(Color.rgb(255,233,217));
                        snackbar.setTextColor(Color.rgb(244,86,40));
                        snackbar.show();

                        //clear the fields
                        username.getText().clear();
                        password.getText().clear();
                    }

                    if(enteredUsername.equals("abcd") && enteredPassword.equals("1234")) {

                        //TODO get and save value of the toggle
                        Log.d(TAG,"Try to go to LessonList activity");
                        startActivity(intent);
                    }


                }
            }
        });
    }
}