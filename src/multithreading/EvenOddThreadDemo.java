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
        str += num;
        System.out.println("Odd Thread: " + num + " -> " + str);

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
        str += num;
        System.out.println("Even Thread: " + num + " -> " + str);

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
    }
}
