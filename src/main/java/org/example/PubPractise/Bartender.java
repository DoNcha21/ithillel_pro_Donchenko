package PubPractise;

import java.util.ArrayList;

public class Bartender extends Thread {
    static public ArrayList<Person> persons = null;
    static double generalIncome = 0.0;
//    public Bartender(ArrayList<Person> persons) {
//        this.persons = persons;
//    }

    @Override
    public void run() {
        ShakeClass shake = new ShakeClass();

        while(true) {
            synchronized(persons) {
                if(!persons.isEmpty()){
                    shake.serveCustomerRequest(persons.get(0));
                    persons.remove(0);
                }else{
                    System.out.println("Bartender stopped");
                    break;
                }
            }

        }

    }
}
