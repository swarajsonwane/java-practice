package concurrency.forkjoins.completablefuture.challenge;

import java.util.concurrent.CompletableFuture;

public class Solution2 {

    public static void main(String[] args) {
        //Here for completable future we are using thenCompose method
        // chaining to do further processing on the result of completable future
        //thenCompose method is used when we want to return a completable future from a completable future

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started");
            //to calculate sum of even numbers till 10
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
            System.out.println("Finding sum of even numbers "+sum);
            return sum;
        }).thenCompose(value -> {
            return CompletableFuture.supplyAsync(() -> {
               //calculate the square of the sum of even numbers
                System.out.println("Processing result");
                return value * value;
            });
        });

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
