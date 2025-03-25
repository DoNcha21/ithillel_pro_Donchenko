package PubPractise;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class ShakeClass {

    public void serveCustomerRequest(Person person) {
        if (person.isCocktailLover()) {
            Cocktail cocktail = serveCocktail(person);
            System.out.println(person.getName() + " get " + cocktail.dominantTaste + " per " + String.format(Locale.US, "%.2f", cocktail.price));
            Bartender.generalIncome += cocktail.price;
        } else {
            PriceWithDrink priceWithDrink = servePureDrink(person);
            AlcoholicDrink alcoholicDrink = priceWithDrink.alcoholicDrink();
            double price = priceWithDrink.price();
            System.out.println(person.getName() + " get " + alcoholicDrink.getName() + " per " + String.format(Locale.US, "%.2f", price));
            Bartender.generalIncome += price;
        }
    }

    public record PriceWithDrink(AlcoholicDrink alcoholicDrink, double price) {}

    public PriceWithDrink servePureDrink(Person person) {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Random rand = new Random();
        Taste preferTaste = person.getPreferencessTaste();
        double price = 0.0;
        ArrayList<AlcoholicDrink> alcoholicDrinks = new ArrayList<>();
        for (AlcoholicDrink alcoholicDrink : AlcoholicDrink.values()) {
            if (alcoholicDrink.getTaste().equals(preferTaste)) {
                alcoholicDrinks.add(alcoholicDrink);
            }
        }
        AlcoholicDrink alcoholicDrink;
        if (alcoholicDrinks.isEmpty()) {
            alcoholicDrink = AlcoholicDrink.values()[0];
        } else {
            int index = rand.nextInt(alcoholicDrinks.size());
            alcoholicDrink = alcoholicDrinks.get(index);
        }

        int liquidCapacity = 0;
        switch (person.getStressLevel()) {
            case 1:
                liquidCapacity = 100;
                break;
            case 2:
                liquidCapacity = 200;
                break;
            case 3:
                liquidCapacity = 300;
                break;
        }

        price += alcoholicDrink.getPrice() * liquidCapacity;

        return new PriceWithDrink(alcoholicDrink, price);
    }

    public Cocktail serveCocktail(Person person) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Random rand = new Random();
        Taste preferTaste = person.getPreferencessTaste();
        double price = 0.0;
        ArrayList<AlcoholicDrink> alcoholicDrinks = new ArrayList<>();
        for (AlcoholicDrink alcoholicDrink : AlcoholicDrink.values()) {
            if (alcoholicDrink.getTaste().equals(preferTaste)) {
                alcoholicDrinks.add(alcoholicDrink);
            }
        }
        if (alcoholicDrinks.isEmpty()) {
            alcoholicDrinks.add(AlcoholicDrink.values()[0]);
        }

        int maxComponents = Math.min(alcoholicDrinks.size(), 3);
        int minComponents = 2;
        int componentValue = minComponents;
        if (maxComponents > minComponents) {
            componentValue = rand.nextInt(maxComponents - minComponents + 1) + minComponents;
        }

        ArrayList<AlcoholicDrink> alcoholicComponents = new ArrayList<>();
        for (int i = 0; i < componentValue; i++) {
            if (alcoholicDrinks.size() > 0) {
                int index = rand.nextInt(alcoholicDrinks.size());
                alcoholicComponents.add(alcoholicDrinks.get(index));
                alcoholicDrinks.remove(index);
            } else {
                break;
            }
        }

        int liquidCapacity = 0;
        DrinkSize cocktailSize = null;
        switch (person.getStressLevel()) {
            case 1:
                liquidCapacity = 100;
                cocktailSize = DrinkSize.SMALL;
                break;
            case 2:
                liquidCapacity = 200;
                cocktailSize = DrinkSize.MEDIUM;
                break;
            case 3:
                liquidCapacity = 300;
                cocktailSize = DrinkSize.LARGE;
                break;
        }

        int remainingCapacity = liquidCapacity;
        for (int i = 0; i < alcoholicComponents.size() - 1; i++) {
            int componentsLeft = alcoholicComponents.size() - i;
            int minRequired = componentsLeft - 1;

            int alcCompCap;
            int maxCap = remainingCapacity - minRequired;
            if (maxCap <= 0) {
                alcCompCap = remainingCapacity / componentsLeft;
                if (alcCompCap < 1) alcCompCap = 1;
            } else {
                alcCompCap = rand.nextInt(maxCap) + 1;
            }

            remainingCapacity -= alcCompCap;
            price += alcoholicComponents.get(i).getPrice() * alcCompCap;
        }
        if (remainingCapacity < 0) remainingCapacity = 0;
        price += alcoholicComponents.getLast().getPrice() * remainingCapacity;

        return new Cocktail(preferTaste, price, alcoholicComponents, cocktailSize);
    }
}