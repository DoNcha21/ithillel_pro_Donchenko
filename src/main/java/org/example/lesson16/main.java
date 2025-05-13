package lesson16;

import java.util.function.Function;
import java.util.function.Supplier;

public class main {
    public static void main(String[] args) {
        // 1.
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        int sum = addition.operate(10, 5);
        System.out.println("sum  res - " + sum);

        //
        MathOperation subtraction = (a, b) -> a - b;
        int difference = subtraction.operate(10,5);
        System.out.println("sub res - " + difference);


        // 2.
        StringManipulator toUpperCase = (s) -> s.toUpperCase();
        String originalString = "qwerty";
        String upperCaseString = toUpperCase.manipulate(originalString);
        System.out.println("UpperCase: " + upperCaseString);

        // 3.
        String testString = "qWerTy";
        Function<String, Integer> countUppercaseFunction = StringListProcessor::countUppercase;
        int uppercaseCount = countUppercaseFunction.apply(testString);
        System.out.println("Count of big letters '" + testString + "': " + uppercaseCount);

        // 4.
        Supplier<Integer> randomNumberSupplier = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        int randomNumber = randomNumberSupplier.get();
        System.out.println("Random from 1 to 100: " + randomNumber);

        //
        int anotherRandomNumber = randomNumberSupplier.get();
        System.out.println("Another random from 1 to 100: " + anotherRandomNumber);
    }
}
