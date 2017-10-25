package com.example.b.firebase;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static android.R.attr.value;

public class Page4 extends AppCompatActivity {

    TextView textView;
    String value;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        Bundle extras = getIntent().getExtras();

        // handler to set duration and to upate animation
        final Handler mHandler = new Handler();

        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {
                AnimateandSlideShow();
            }
        };

        int delay = 500;
        int period = 4000;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                mHandler.post(mUpdateResults);
            }
        }, delay, period);

        viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
        if (extras != null) {
            value = extras.getString("key");

            //p.getName().indexOf(value);
            Toast.makeText(Page4.this, value, Toast.LENGTH_SHORT).show();
        }
        textView =(TextView)findViewById(R.id.textView2);

        //textView.setText(value);
        Loadimages();

//        Log.e("Details",s);

    }

    private void Loadimages() {

        ArrayList<String> actorsList = new ArrayList<String>();

       // actorsList.add("https://www.gstatic.com/mobilesdk/160323_mobilesdk/images/firebase_logotype_white_18dp.svg");
        actorsList.add("https://graph.facebook.com/1010491118990160/picture?height=200&width=200&migration_overrides=%7Boctober_2012%3Atrue%7D");
        actorsList.add("http://microblogging.wingnity.com/JSONParsingTutorial/brad.jpg");

        actorsList.add("http://microblogging.wingnity.com/JSONParsingTutorial/cruise.jpg");

Log.e("Arraylisr",actorsList.toString());
        for(int i=0;i<actorsList.size();i++){
            Log.i("Set Filpper Called", actorsList.get(i).toString()+"");
            ImageView image = new ImageView(getApplicationContext());
// image.setBackgroundResource(res);
            Picasso.with(Page4.this)
                    .load(actorsList.get(i).toString())
                    .placeholder(R.drawable.com_facebook_button_icon)
                    .error(R.drawable.com_facebook_close)
                    .into(image);
            viewFlipper.addView(image);
        }
    }

    // method to show slide show
    private void AnimateandSlideShow() {
        viewFlipper.showNext();
    }
    }

