package concurrency.forkjoins.completablefuture;

import java.util.concurrent.CompletableFuture;

public class CF1 {

    public static void main(String[] args) {
        // creating simple data call using completable future also it uses lambda expression

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed");
            return 200;
        });

        // now to process result of completable future we use thenApply method
        // which is a callback method so gets called when completable future is completed
        // callback function is gets called when other function is completed

        CompletableFuture<Integer> result = future.thenApply(value -> {
            System.out.println("Processing result");
            return value * 2;
        });


        //suppose the data is down and you want to return last cached data

        future.complete(500);

        //now the result would be 500*2 = 1000

        // now to get the result of completable future we use get method

        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
