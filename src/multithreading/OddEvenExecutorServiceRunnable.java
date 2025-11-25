package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OddEvenExecutorServiceRunnable {

    public static void main(String[] args) throws Exception {

        String str = "abc";

        // ---------------------------
        // Odd Task (Runnable)
        // ---------------------------
        Runnable oddTask = () -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Odd Thread : " + str + i);
            }
        };

        // ---------------------------
        // Even Task (Runnable)
        // ---------------------------
        Runnable evenTask = () -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even Thread : " + str + i);
            }
        };

        // ---------------------------
        // Create ExecutorService with 2 threads
        // ---------------------------
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // ---------------------------
        // Submit odd task first
        // Future allows waiting, even though Runnable returns null
        // ---------------------------
        Future<?> oddFuture = executorService.submit(oddTask);

        // ---------------------------
        // Ensure odd thread finishes completely
        // .get() will block main thread until oddTask is done
        // ---------------------------
        oddFuture.get();

        // ---------------------------
        // Now submit even task
        // This will run only after odd task completes
        // ---------------------------
        executorService.submit(evenTask);

        // ---------------------------
        // Shutdown executor service
        // ---------------------------
        executorService.shutdown();
    }
}
