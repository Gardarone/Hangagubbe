package com.example.anton.hangagubbe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;


public class Meny extends AppCompatActivity {

    private Button aboutButton;
    private Button playButton;
    private TextView welcomeTextView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meny);

        /*
        Buttons for getting to play the game and info about the game.
         */
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlay();
            }
        });

        aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i("PauseResume", "onPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("PauseResume", "onResume");
    }

    /*
    How the about buttons action works
     */
    public void openAbout() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    /*
    How the play buttons action works
     */
    public void openPlay() {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

}
