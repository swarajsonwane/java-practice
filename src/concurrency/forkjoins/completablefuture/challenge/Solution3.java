package concurrency.forkjoins.completablefuture.challenge;

import java.util.concurrent.CompletableFuture;

public class Solution3 {

    public static void main(String[] args) {
        //Here for completable future we are using thenCombine method

        //thenCombine method is used when we want to combine the result of two completable futures

        long startTime = System.nanoTime();

        CompletableFuture<Integer> sumOfSquareTask = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started");
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i * i;
            }
            System.out.println("Finding sum of squares " + sum);
            return sum;
        });

        CompletableFuture<Integer> sumOfEvenTask = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started");
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
            System.out.println("Finding sum of even numbers " + sum);
            return sum;
        });

        CompletableFuture<Integer> result = sumOfSquareTask.thenCombine(sumOfEvenTask, (squares, even) -> {
            System.out.println("Processing result");
            return squares + even;
        });

        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
    }
}

}
