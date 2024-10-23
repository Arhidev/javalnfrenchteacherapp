package com.arinteck.frenchteacherapp;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    //the row folder is a directory where you can place various types of row resources that your Android application might need.
    //Row resources are files that you don't want the system to process in any special way.

    Button black, green, purple, red, yellow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ///many button to handle so  to avoid boilerplate code
        // so: implements  View.OnClickListener interface :
        ///
        //the View.OnClickListener interface View dot on Click Listener
        //interface is an interface that provides a way to handle click events ón Ul elements,
        // especially instances of  the view class

        //When you implement this interface and override the on click method, you define the action that should
        //be taken when the associated view is clicked, the view parameter represents the view that was clicked.

        black = findViewById(R.id.blackId);
        green = findViewById(R.id.greenId);
        purple = findViewById(R.id.purpleId);
        red = findViewById(R.id.redId);
        yellow = findViewById(R.id.yellowId);

        // this refers to this view on click listener interface  (View.OnClickListener)
        //It redirects the call to the on click method that it is implemented and override it here.
        black.setOnClickListener(this);
        green.setOnClickListener(this);
        purple.setOnClickListener(this);
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.blackId){
            playSound(R.raw.black);
        } else  if(id == R.id.greenId){
            playSound(R.raw.vert);
        }else  if(id == R.id.purpleId){
            playSound(R.raw.purple);
        }else  if(id == R.id.redId){
            playSound(R.raw.rouge);
        }else  if(id == R.id.yellowId){
            playSound(R.raw.yellow);
        }
    }

    public  void playSound(int id){
        MediaPlayer mediaPlayer =  MediaPlayer.create(getApplicationContext(),id);
        mediaPlayer.start();
    }
}