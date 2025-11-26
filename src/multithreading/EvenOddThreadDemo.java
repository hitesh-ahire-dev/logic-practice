package multithreading;

public class EvenOddThreadDemo {
    private boolean isOddTurn = true; // Start with odd
    private String str = "abc";

    public synchronized void printOdd(int num) {
        while (!isOddTurn) { // Wait until it's odd thread's turn
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd Thread: " + str+num);

        isOddTurn = false; // Now even thread should run
        notify();
    }

    public synchronized void printEven(int num) {
        while (isOddTurn) { // Wait until it's even thread's turn
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even Thread: " +str+num);

        isOddTurn = true; // Now odd thread should run
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
        System.out.println(10+20+"10"+20);
    }
}
