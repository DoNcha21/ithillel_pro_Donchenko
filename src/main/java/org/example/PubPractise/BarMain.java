package PubPractise;

import java.util.ArrayList;
import java.util.Random;

public class BarMain {
    public static void main(String[] args) {
        ArrayList<Person> bar = new ArrayList<Person>();
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            bar.add(new Person("Person" + i,Person.getRandomStressLevel(),
                    Taste.getRandomTaste(),Person.getRandomCocktailPref()));
        }
        Bartender.persons = bar;
        Bartender bartender1 = new Bartender();
        Bartender bartender2 = new Bartender();
        Bartender bartender3 = new Bartender();
        bartender1.start();
        bartender2.start();
        bartender3.start();


        try {
            bartender1.join();
            bartender2.join();
            bartender3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Bartender.generalIncome);
    }
}
