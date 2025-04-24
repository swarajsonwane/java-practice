package concurrency.forkjoins.completablefuture.challenge;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();

        Future<Integer> sumOfSquareTask = executorService.submit(new SumOfSquareTask());
        Future<Integer> sumOfEvenTask = executorService.submit(new SumOfEvenTask());

        while(!sumOfSquareTask.isDone() || !sumOfEvenTask.isDone()) {
            System.out.println("Waiting for tasks to complete");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println(sumOfSquareTask.get());
            System.out.println(sumOfEvenTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();

        System.out.println("Time taken: " + (endTime - startTime) / 1_000_000 + " milliseconds");

        executorService.shutdown();

    }
}
