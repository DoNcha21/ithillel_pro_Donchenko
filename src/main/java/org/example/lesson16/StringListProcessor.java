package lesson16;

public class StringListProcessor {

    static public int countUppercase(String s){
        int counter = 0;
        for (char c : s.toCharArray()) {
            if(Character.isUpperCase(c)){
                counter++;
            }
        }
        return counter;
    }
}
