package PubPractise;



public enum AlcoholicDrink {

    VODKA("Vodka", Taste.BITTER,0.02),
    WHISKEY("Whiskey", Taste.BITTER,0.035),
    ABSINTHE("Absinthe", Taste.BITTER,0.045),
    TEQUILA("Tequila", Taste.SALTY,0.025),
    QIN("Qin", Taste.SALTY,0.03),
    AQUAVIT("Aquavit", Taste.SALTY,0.035),
    VERMOUTH("Vermouth", Taste.SWEET,0.025),
    RUM("Rum", Taste.SWEET,0.03),
    LIQUEUR("Liqueur", Taste.SWEET,0.045);

    private final String name;
    private final Taste taste;
    private final double price;

    AlcoholicDrink(String name, Taste taste, double price) {
        this.name = name;
        this.taste = taste;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Taste getTaste() {
        return taste;
    }

    public double getPrice() {
        return price;
    }
}
