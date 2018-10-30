package com.example.anton.hangagubbe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishScreen extends AppCompatActivity {

    private Button playButton;
    private TextView wonLost;
    private TextView lost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);

        boolean won = getIntent().getExtras().getBoolean("won");
        wonLost = findViewById(R.id.wonLostTextView);
        if(won){
            wonLost.setText(getString(R.string.won));
            Bundle extras = getIntent().getExtras();
            boolean win = extras.getBoolean("won");
            String word = extras.getString("word");
            lost.setText(getString(R.string.right_word)+ word);
        }else{
            wonLost.setText(getString(R.string.lost));
            lost = findViewById(R.id.lostWordTextView);
            Bundle extras = getIntent().getExtras();
            boolean win = extras.getBoolean("won");
            String word = extras.getString("word");
            lost.setText(getString(R.string.wrong_word)+ word);
        }



        playButton = (Button) findViewById(R.id.playAgainButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlay();
            }
        });
    }

    public void openPlay() {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

}
