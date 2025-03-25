import java.util.ArrayList;
import java.util.Collections;

public class Box<T extends Fruit> {
    ArrayList<T> fruitBox = new ArrayList<>();

    public Box(ArrayList<T> fruits) {
        this.fruitBox = fruits;
    }

    public Box() {}

    public void addFruit(T fruit) {
        fruitBox.add((T) fruit);
    }

    public void addFruit(T[] fruit) {
        if(fruit.length == 0){
            throw new IllegalArgumentException("Fruit list is empty");
        }
            for (Fruit fruitObj : fruit) {
                fruitBox.add((T) fruitObj);
            }
    }

    public double getWeight(){
        double weight = 0;
        for (Fruit fruit : fruitBox) {
            weight += fruit.getWeigth();
        }
        return weight;
    }

    public boolean compareFruit(Box box) {
        return getWeight() == box.getWeight();
    }

}
