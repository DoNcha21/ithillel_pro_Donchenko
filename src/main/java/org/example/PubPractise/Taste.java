package PubPractise;

import java.util.Random;

public enum Taste {
    SWEET,
    SOUR,
    BITTER,
    SALTY;


    public static Taste getRandomTaste() {
        Random random = new Random();
        return Taste.values()[random.nextInt(Taste.values().length)];
    }
}
