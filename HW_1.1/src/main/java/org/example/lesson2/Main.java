package org.example.lesson2;
//dummy lesson2
public class Main {
    private static final double CONV_K = 1.60934;

    public static void main(String[] args) {

        double km = 1;
        double miles = 12;

        double milesResult = convKmToMiles(km);
        double kmResult = convMilesToKm(miles);

        System.out.println("Result is " + milesResult + " miles and " + kmResult + " kilometrs.");
    }

    private static double convKmToMiles(double km) {
        return km / CONV_K;
    }

    private static double convMilesToKm(double miles) {
        return miles * CONV_K;
    }

}
