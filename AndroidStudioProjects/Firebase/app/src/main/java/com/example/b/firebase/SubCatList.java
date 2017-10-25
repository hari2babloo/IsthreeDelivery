package com.example.b.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SubCatList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference myref;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_cat_list);
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            value = extras.getString("key");
//
//            //p.getName().indexOf(value);
//            Toast.makeText(SubCatList.this, value, Toast.LENGTH_SHORT).show();
//        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(SubCatList.this, 2);
        //  RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Dresh.this);


        recyclerView.setLayoutManager(layoutManager);
        //myref= FirebaseDatabase.getInstance().getReference().child("/blog");
        myref = FirebaseDatabase.getInstance().getReference().child("Database/Category/Schools");
        //   myref.child("Category").child("Clothing").getKey();

        //   myref.child("School").orderByValue().equalTo("CBSE","type");

        // query =  myref.child("Database/Category/Schools").orderByValue();

//        myref.getParent().getKey();
//        Log.e("Data",query.toString());
        Log.e("Data", myref.toString());


        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> list = new ArrayList<>();
                //   ArrayList<Person> data = new ArrayList<Person>();

                // List<String, Object> data = new ArrayList<String,Object>();
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {

                    // data.add(childSnapshot.getKey(), childSnapshot.getValue());




                    String ss = childSnapshot.getKey().toString();
                    Log.e("Key:",childSnapshot.getKey().toString());

                    Log.e("TOtal Data",childSnapshot.toString());
                    Log.e("Value:",childSnapshot.getValue().toString());


                    // data.add(childSnapshot.getValue().toString());
                    list.add(ss);


                    // data.add(childSnapshot.getValue());


                  //  textView.setText(ss);

                }
                Log.e("List:",list.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}