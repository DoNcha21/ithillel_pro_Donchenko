package PubPractise;

import java.util.Random;

public enum DrinkSize {
    SMALL(100),
    MEDIUM(200),
    LARGE(300);

    DrinkSize(int i) {
    }

//    public static DrinkSize getRandomDrinkSize() {
//        Random random = new Random();
//        return DrinkSize.values()[random.nextInt(DrinkSize.values().length)];
//    }
}
