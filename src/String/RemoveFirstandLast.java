package String;

public class RemoveFirstandLast {

    public static String removeFirstandLastChar(String str) {

        String substring = str.substring(1, str.length() - 1);
        return substring;
    }

    public static void main(String[] args) {
        String str = "hiteshahire";
        System.out.println(removeFirstandLastChar(str));
    }
}
