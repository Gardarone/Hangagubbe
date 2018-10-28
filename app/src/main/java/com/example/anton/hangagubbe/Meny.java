package com.example.anton.hangagubbe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Meny extends AppCompatActivity {

    private Button aboutButton;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meny);

        /*
        Made the buttons work from the meny
         */
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlay();
            }
        });

        aboutButton = (Button) findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
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
