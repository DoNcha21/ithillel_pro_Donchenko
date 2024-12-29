package org.example.lesson3;

public static void main(String[] args) {
    public static void main(String[] args) {

        double celsius = 25;
        double fahrenheit = 77;

        double fahrenheitResult = convCelsiusToFahrenheit(celsius);
        double celsiusResult = convFahrenheitToCelsius(fahrenheit);

        System.out.println("Result is " + fahrenheitResult + " Fahrenheit and " + celsiusResult + " Celsius.");
    }

    private static double convCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double convFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}