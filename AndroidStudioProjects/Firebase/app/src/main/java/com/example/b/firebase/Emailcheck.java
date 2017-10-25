package com.example.b.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Emailcheck extends AppCompatActivity {

    Button putdat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailcheck);
        putdat = (Button)findViewById(R.id.Putdata);
        putdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference myref;
                myref = FirebaseDatabase.getInstance().getReference().child("Users");
                String userid = myref.push().getKey();
             //   myref.child(userid).setValue(per);

                Query q = myref.orderByChild("uemail").equalTo("hari2babloo@live");

                q.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        if(dataSnapshot.exists())
                        {
                            Toast.makeText(Emailcheck.this, "Yes", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Emailcheck.this, "No", Toast.LENGTH_SHORT).show();
                        }
//
//                        if(dataSnapshot.getValue() == null || dataSnapshot.getValue().toString().isEmpty() || dataSnapshot.getValue().toString().equalsIgnoreCase("{ key = Users, value = null }") ){
//                            Toast.makeText(Emailcheck.this, "Data Already presemt", Toast.LENGTH_SHORT).show();
//                        }
//                        else
//                        {
//                            Toast.makeText(Emailcheck.this, "Data ready to send", Toast.LENGTH_SHORT).show();
//                        }
//
//                        //Toast.makeText(Emailcheck.this, "Inserted", Toast.LENGTH_SHORT).show();
                    }
//
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Toast.makeText(Emailcheck.this, "Cancelled", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}
