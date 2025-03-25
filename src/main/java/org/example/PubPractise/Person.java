package PubPractise;

import java.util.Random;

public class Person {
    private String name;
//    private double wallet;
    private int stressLevel;
    private Taste preferencessTaste;
    private boolean cocktailLover;

    public Person(String name, int stressLevel, Taste preferencessTaste, boolean cocktailLover) {
        this.name = name;
//        this.wallet = wallet;
        this.stressLevel = stressLevel;
        this.preferencessTaste = preferencessTaste;
        this.cocktailLover = cocktailLover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public double getWallet() {
//        return wallet;
//    }
//
//    public void setWallet(double wallet) {
//        this.wallet = wallet;
//    }

    public int getStressLevel() {
        return stressLevel;
    }

    public void setStressLevel(int stressLevel) {
        this.stressLevel = stressLevel;
    }

    public Taste getPreferencessTaste() {
        return preferencessTaste;
    }

    public void setPreferencessTaste(Taste preferencessTaste) {
        this.preferencessTaste = preferencessTaste;
    }

    public boolean isCocktailLover() {
        return cocktailLover;
    }

    public void setCocktailLover(boolean cocktailLover) {
        this.cocktailLover = cocktailLover;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
//                ", wallet=" + wallet +
                ", stressLevel=" + stressLevel +
                ", preferencessTaste=" + preferencessTaste +
                ", cocktailLover=" + cocktailLover +
                '}';
    }

    public static int getRandomStressLevel() {
        Random random = new Random();
        return  random.nextInt(3)+1;
    }

    public static boolean getRandomCocktailPref() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
