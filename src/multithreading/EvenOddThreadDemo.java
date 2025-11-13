package multithreading;

public class EvenOddThreadDemo {
    private boolean isOddTrue = false;

    public synchronized void printOdd(int num) {

        try {
            if(!isOddTrue) {
                wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Odd Thread: " + num);
        isOddTrue = true;
        notify();
    }

    public synchronized void printEven(int num) {
        try {
            if(isOddTrue) { //use while
                wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Even Thread: " + num);
        isOddTrue = true;
        notify();
    }

    public static void main(String[] args) {
        EvenOddThreadDemo printer = new EvenOddThreadDemo();

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                printer.printOdd(i);
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                printer.printEven(i);
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
