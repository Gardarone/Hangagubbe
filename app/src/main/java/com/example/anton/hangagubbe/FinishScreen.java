package com.example.anton.hangagubbe;

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


    /*
    Finish screen is to show if the player won or lost
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);

        /*
        If won show the wining screen
        If lost show the losing screen
         */

        wonLost = findViewById(R.id.wonLostTextView);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String word = extras.getString("word");
            boolean won = getIntent().getExtras().getBoolean("won");

            if(won){
                wonLost.setText(getString(R.string.won));
                lost.append((R.string.right_word)+ word);
            }else{
                wonLost.setText(getString(R.string.lost));
                lost = findViewById(R.id.lostWordTextView);
                lost.append((R.string.wrong_word)+ word);
            }

        }
        


        /*
        A button set to return to the game and try/play again
         */
        playButton = findViewById(R.id.playAgainButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlay();
            }
        });
    }
    /*
    If button is pushed, open Game class.
     */
    public void openPlay() {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

}
