package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OddEvenExecutorServiceCallable {
    public static void main(String[] args) throws Exception {

        String str = "abc";

        // ---------------------------
        // Odd Task (Callable)
        // Callable must return something (Void or any type)
        // ---------------------------
        Callable<Void> oddTask = () -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Odd Thread : " + str + i);
            }
            return null;   // Callable must return a value
        };

        // ---------------------------
        // Even Task (Callable)
        // ---------------------------
        Callable<Void> evenTask = () -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even Thread : " + str + i);
            }
            return null;
        };

        // ---------------------------
        // Create ExecutorService with 2 threads
        // ---------------------------
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // ---------------------------
        // Submit odd task first
        // Future allows getting the result and waiting for task completion
        // ---------------------------
        Future<Void> oddFuture = executorService.submit(oddTask);

        // ---------------------------
        // Ensure odd thread completes before even thread starts
        // .get() blocks main thread until oddTask is done
        // ---------------------------
        oddFuture.get();

        // ---------------------------
        // Now submit even task
        // This will start only after odd task is fully done
        // ---------------------------
        executorService.submit(evenTask);

        // ---------------------------
        // Shutdown executor service
        // ---------------------------
        executorService.shutdown();
    }
}
