package com.example.anton.hangagubbe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


public class Game extends AppCompatActivity {

    private Button guessButton;
    private EditText guessLetter;

    private String word = generateWord();

    List<Character> letterList = new ArrayList<>();
    private BitSet revealed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /*
        Created functions to the buttons in the game.
         */
        guessButton = (Button) findViewById(R.id.guessButton);
        guessLetter = findViewById(R.id.guessLetterEditText);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess(guessLetter.getText().toString());
            }
        });
    }

    public void guess(String guess) {

        if (guess.length() != 1) {
            Toast.makeText(guessLetter.getContext(), R.string.invalidguess_length, Toast.LENGTH_LONG).show();
        } else if (letterList.contains(guess.charAt(0))) {
            Toast.makeText(guessLetter.getContext(), R.string.same_letter, Toast.LENGTH_LONG).show();
        } else {
            char letter = guess.charAt(0);
            letterList.add(letter);
            for (int i = 0; i < word.length(); i++) {
               if (letter == word.charAt(i)) {
                   updateAnswerView();
                   break;
               }

            }


        }

    }

    public void updateAnswerView(){
        final BitSet revealed = null;
        this.revealed = new BitSet(word.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <word.length() ; i++) {
            sb.append("-");
        }
    }

    public String generateWord() {
        return "SHEEP";
    }

}
