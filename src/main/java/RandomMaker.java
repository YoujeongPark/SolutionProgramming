package main.java;

import java.util.Random;

public class RandomMaker {

    public void randomAlphabet(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random randomMaker = new Random();
        StringBuilder buffer = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (randomMaker.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        System.out.println(generatedString);

    }
}
