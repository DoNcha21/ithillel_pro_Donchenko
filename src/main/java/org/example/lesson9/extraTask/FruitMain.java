import java.awt.geom.AffineTransform;

public class FruitMain {
    public static void main(String[] args) {
        Box appleBox = new Box();

        appleBox.addFruit(new Apple());
        Apple[] appleArr = new Apple[10];
        for (int i = 0; i < appleArr.length; i++) {
            appleArr[i] = new Apple();
        }
        appleBox.addFruit(appleArr);
        System.out.println(appleBox.getWeight());
        System.out.println("///////////////////////////////////");
        Box<Apple> lameAppleBox = new Box<Apple>();
        Apple[] fruitArr = new Apple[3];
        fruitArr[0] = new Apple();
        fruitArr[1] = new Apple();
        fruitArr[2] = new Apple();
        lameAppleBox.addFruit(fruitArr);
        System.out.println(lameAppleBox.getWeight());

        System.out.println("///////////////////////////////////");
        Box<Orange> lameOrangeBox = new Box<>();
        lameOrangeBox.addFruit(new Orange());
        lameOrangeBox.addFruit(new Orange());
        if(lameOrangeBox.compareFruit(lameAppleBox)){
            System.out.println("Fruit is the same");
        }
    }
}
