package concurrency.forkjoins.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CF2 {

    public static void main(String[] args) {
        //Here for completable future we are using thenCompose method
        //thenCompose method is used when we want to return a completable future from a completable future

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed");
            return 200;
        }).thenCompose(value -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Processing result");
                return value * 2;
            });
        });

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
