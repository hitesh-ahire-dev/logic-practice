package String;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hitesh";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[(str.length() - i) - 1];
            charArray[(str.length() - i) - 1] = temp;
        }
        System.out.println(charArray);


        //java 8 - logic 1
        String collect = IntStream.rangeClosed(1, str.length())
                .mapToObj(i -> str.charAt(str.length() - i))
                .map(String::valueOf)
                .collect(Collectors.joining());

        String res = str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (result, ch) -> ch + result);



        System.out.println("Revers String " + res);

    }
}
