package com.example.anton.hangagubbe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;



public class Game extends AppCompatActivity {

    private EditText guessLetter;
    private TextView wordGuessText;
    private TextView letterTextView;
    private ImageView imageView;


    private String word = null;
    private int imageIndex = 0;

    /*
    A list that keeps track on the letters that are guessed
     */
    List<Character> letterList = new ArrayList<>();

    /*
    List of all the hangman pictures
     */
    private final static int[] PICS = {R.mipmap.hang10, R.mipmap.hang9, R.mipmap.hang8, R.mipmap.hang7, R.mipmap.hang6, R.mipmap.hang5, R.mipmap.hang4, R.mipmap.hang3, R.mipmap.hang2, R.mipmap.hang1, R.mipmap.hang0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        word = generateWord();

        wordGuessText = findViewById(R.id.wordTextView);
        letterTextView = findViewById(R.id.letterTextView);
        imageView = findViewById(R.id.imageView);

        /*
        Created functions to the buttons in the game.
         */
        Button guessButton = findViewById(R.id.guessButton);
        guessLetter = findViewById(R.id.guessLetterEditText);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess(guessLetter.getText().toString());
            }
        });
    }


    /*
    Checking if the input is valid or not.
    Checking if the letter has been used or not and if the input is more then 1 letter
    Printing out to player if those conditions has been meet with a "warning"
    If won/loss takes you to Finish screen and shows a message
     */
    public void guess(String guess) {
        if (guess.length() != 1) {
            Toast.makeText(getApplicationContext(), R.string.invalidguess_length, Toast.LENGTH_LONG).show();
        } else if (letterList.contains(guess.charAt(0))) {
            Toast.makeText(getApplicationContext(), R.string.same_letter, Toast.LENGTH_LONG).show();
        } else {
            char letter = guess.charAt(0);
            letterList.add(letter);
            updateAnswerView();
            if(!word.contains(letter+"")){
                nextPictures();
            }
            if(hasWon()){
                Intent intent = new Intent(this, FinishScreen.class);
                intent.putExtra("won", true);
                intent.putExtra("word", word);
                startActivity(intent);
            } else if(hasLost()) {
                Intent intent = new Intent(this, FinishScreen.class);
                intent.putExtra("won", false);
                intent.putExtra("word", word);
                startActivity(intent);
            }

            /* Clears phones last written letter/word */
            guessLetter.setText("");
            guessLetter.requestFocus();

            /*Shows guessed letters both right and wrong */
            letterTextView.setText(letterList.toString());

        }
    }


    /*
    Updates the word if player gets a letter right.
     */
    public void updateAnswerView(){
        wordGuessText.setText(getCurrentResult());
    }

    /*
    Builds up the word and mask it for the player
     */
    public String getCurrentResult(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <word.length() ; i++) {
            char currentLetter = word.charAt(i);

            if(letterList.contains(currentLetter)){
                sb.append(currentLetter);
            }else {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    /*
    Checks if the player has won
     */
    public boolean hasWon() {
        for (int i = 0; i < word.length() ; i++) {
            if (!letterList.contains(word.charAt(i))){
               return false;
            }
        }
        return true;
    }

    /*
    Checks if the player has lost by checking how many pictures that are left
     */
    public boolean hasLost(){
        return PICS.length - 1 == imageIndex;
    }

    /*
    Rolling the next picture and checking if there is any pictures left.
     */
    public void nextPictures(){
        if(imageIndex < PICS.length-1) {
            imageIndex++;
        }
        Picasso.get().load(PICS[imageIndex]).into(imageView);
    }

    /*
    Gets a random word form the class word factory.
     */
    public String generateWord() {
         return WordFactory.genWord(getApplicationContext());
    }



}
