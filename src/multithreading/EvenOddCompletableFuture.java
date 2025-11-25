package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddCompletableFuture {
    public static void main(String[] args) throws Exception {

        String str = "abc";

        // ---------------------------
        // Create a custom thread pool
        // ---------------------------
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // ---------------------------
        // Odd Task as CompletableFuture
        // supplyAsync() runs task in background thread and returns CompletableFuture
        // ---------------------------
        CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(() -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Odd Thread  : " + str + i);
            }
        }, executor);

        // ---------------------------
        // Even Task runs only AFTER odd task completes
        // thenRunAsync() ensures sequencing
        // ---------------------------
        CompletableFuture<Void> evenFuture = oddFuture.thenRunAsync(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even Thread : " + str + i);
            }
        }, executor);

        // ---------------------------
        // Wait for both tasks to complete
        // join() is like get() but simpler & unchecked
        // ---------------------------
        evenFuture.join();

        // Shutdown executor
        executor.shutdown();
    }
}
