package com.example.b.firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by Cnf on 8/3/2016.
 */
public class FacebookLoginActivity extends AppCompatActivity{

     LoginButton loginButton;
    private CallbackManager callbackManager;

    private FirebaseAuth firebaseAuth;
    String email,firstName,lastName,gender,bday,pic;
    private FirebaseAuth.AuthStateListener firebaseAuthListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_facebooklogin);

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton)findViewById(R.id.login_button);

       // loginButton.setReadPermissions("email", "public_profile");
        loginButton.setReadPermissions(Arrays.asList("email", "public_profile","user_birthday"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
                setFacebookData(loginResult);
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListner = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    goMainScreen();
                }
            }
        };
    }

    private void setFacebookData(LoginResult loginResult) {
        {
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response) {
                            // Application code
                            try {
                                Log.i("Response", response.toString());

                                 email = response.getJSONObject().getString("email");
                                 firstName = response.getJSONObject().getString("first_name");
                                 lastName = response.getJSONObject().getString("last_name");
                                 gender = response.getJSONObject().getString("gender");
                                 bday = response.getJSONObject().getString("birthday");
                               // pic = Profile.getCurrentProfile().getProfilePictureUri(200, 200);

                                Profile profile = Profile.getCurrentProfile();
//                                String id = profile.getId();

//                                Log.i("Link", pic);
                                if (Profile.getCurrentProfile() != null) {

                                    pic = Profile.getCurrentProfile().getProfilePictureUri(200, 200).toString();
                                    Log.i("Login", "ProfilePic" + Profile.getCurrentProfile().getProfilePictureUri(200, 200));
                                }

                                Log.i("Login" + "Email", email);
                                Log.i("Login" + "FirstName", firstName);
                                Log.i("Login" + "LastName", lastName);
                                Log.i("Login" + "Gender", gender);
                                Log.i("Login" + "Bday", bday);

                                PutintoDB();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,email,first_name,last_name,gender, birthday");
            request.setParameters(parameters);
            request.executeAsync();
        }
    }

    private void PutintoDB() {

        final DatabaseReference myref;
        final Person per = new Person();

        per.setUfname(firstName);
        per.setUlname(lastName);
        per.setUdob(bday);
        per.setUemail(email);
        per.setUgender(gender);
        per.setUpic(pic);

        myref = FirebaseDatabase.getInstance().getReference().child("Users");

        Query q = myref.orderByChild("uemail").equalTo("hari2babloo@live");

        q.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                if(dataSnapshot.exists())
                {
                    Toast.makeText(FacebookLoginActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                }
                else {

                    String userid = myref.push().getKey();
                    myref.child(userid).setValue(per);
                    Toast.makeText(FacebookLoginActivity.this, "No", Toast.LENGTH_SHORT).show();
                }

            }
            //
            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(FacebookLoginActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();

            }
        });
        //myref.child("Database4").getKey().equalsIgnoreCase("HDFC");

    }

    private void handleFacebookAccessToken(AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"firebase ettpr login", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListner);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(firebaseAuthListner);
    }

    public void goMainScreen(){
        Intent intent = new Intent(this, Facebook.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}