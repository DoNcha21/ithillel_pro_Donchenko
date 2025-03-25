package PubPractise;

import java.util.ArrayList;

public class Cocktail {
    Taste dominantTaste;
    double price;
    ArrayList<AlcoholicDrink> components;
    DrinkSize size;

    public Cocktail(Taste dominantTaste, double price, ArrayList<AlcoholicDrink> components, DrinkSize size) {
        this.dominantTaste = dominantTaste;
        this.price = price;
        this.components = components;
        this.size = size;
    }

    public Taste getDominantTaste() {
        return dominantTaste;
    }

    public void setDominantTaste(Taste dominantTaste) {
        this.dominantTaste = dominantTaste;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<AlcoholicDrink> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<AlcoholicDrink> components) {
        this.components = components;
    }

    public DrinkSize getSize() {
        return size;
    }

    public void setSize(DrinkSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "dominantTaste=" + dominantTaste +
                ", price=" + price +
                ", components=" + components +
                ", size=" + size +
                '}';
    }
}
