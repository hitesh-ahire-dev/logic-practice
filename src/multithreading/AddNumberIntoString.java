package multithreading;

public class AddNumberIntoString {
    private volatile int num = 1;
    private volatile String str = "abc";

    public synchronized void addEvenNum(){
        try{
            while (num <= 10){
                if (num % 2 != 0){
                    wait();
                }else {
                    str += num;
                    System.out.println("Even Thread : " + str + " | added value - " + num);
                    num++;
                    notify();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public synchronized void addOddNum(){
        try{
            while (num <= 10){
                if (num % 2 == 0){
                    wait();
                }else {
                    str += num;
                    System.out.println("Odd Thread : " + str + " | added value - " + num);
                    num++;
                    notify();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        AddNumberIntoString obj = new AddNumberIntoString();

        Thread t1 = new Thread(() -> {
            obj.addEvenNum();
        });

        Thread t2 = new Thread(() -> {
            obj.addOddNum();
        });

        t1.start();
        t2.start();

    }
}
