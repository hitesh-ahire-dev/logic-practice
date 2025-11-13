package number;

public class PrintEvenOddWithOutLoop {

    public static int isEven(int num){
        if(num <= 0){
            return 0;
        }

           if(num % 2 == 0)
               System.out.println(num);
        return  isEven(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(isEven(100));
    }
}
