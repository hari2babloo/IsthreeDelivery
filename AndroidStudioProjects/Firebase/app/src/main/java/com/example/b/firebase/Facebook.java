package com.example.b.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;

public class Facebook extends AppCompatActivity {

    CallbackManager mCallbackManager;
    LoginButton loginButton;
    Button logout,Getdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        if (AccessToken.getCurrentAccessToken() == null) {
            goLoginScreen();
        }
        logout = (Button)findViewById(R.id.button2);
        Getdata = (Button)findViewById(R.id.get);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                FirebaseAuth.getInstance().signOut();
                goLoginScreen();
            }
        });
        Getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(Facebook.this,Page1.class);
                startActivity(i);
            }
        });
    }

        private void goLoginScreen() {
            Intent intent = new Intent(this, FacebookLoginActivity.class);
           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


        public void logout(View view) {
            LoginManager.getInstance().logOut();
            goLoginScreen();
        }

    }

