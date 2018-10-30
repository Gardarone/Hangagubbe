package com.example.anton.hangagubbe;

import android.content.Context;

import java.util.Random;

public class WordFactory {

    public static String genWord(Context ctx) {
        String[] words = ctx.getResources().getStringArray(R.array.gissa);
        Random randGen = new Random();
        randGen.nextInt(words.length);
        return words[randGen.nextInt(words.length)];
    }
}
