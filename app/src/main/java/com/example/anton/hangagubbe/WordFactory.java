package com.example.anton.hangagubbe;

import java.util.Random;

public class WordFactory {

    public static String generateWord() {
        String [] word = {"appointment", "dinner", "acceptance", "friend", "shape", "hammer", "student" };
        Random randGen = new Random();
        randGen.nextInt(word.length);
        return word[randGen.nextInt(word.length)];
    }
}
