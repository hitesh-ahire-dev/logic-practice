package String;

import java.util.Arrays;

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
    }
}
