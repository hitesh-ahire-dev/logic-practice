package String;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Annagram {

    public static boolean isAnnagram(String str1, String str2){

        if(str1.length() != str2.length())  return  false;

        char[] charArray1 = str1.toLowerCase().toCharArray();
        char[] charArray2 = str2.toLowerCase().toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
         String   str1 =  "aab";
           String str2 = "cba";

        boolean annagram = isAnnagram(str1, str2);

        if (annagram){
            System.out.println("String are annagram");
        }else {
            System.out.println("String are not annagram");
        }
    }
}
