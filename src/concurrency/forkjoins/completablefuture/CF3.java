package concurrency.forkjoins.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CF3 {

    public static void main(String[] args) {
        //Here for completable future we are using thenCombine method
        //thenCombine method is used when we want to combine two completable future and return a result

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed");
            return 200;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println("Other task started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Other task completed");
            return 300;
        }), (value1, value2) -> {
            return value1 + value2;
        });

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
