package concurrency.forkjoins.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

        public static void main(String[] args) throws InterruptedException, ExecutionException {
            ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(2);

            long startTime = System.nanoTime();

            Future<String> timeConsumingTask = executorService.submit(new TimeConsumingTask());
            Future<String> otherTask = executorService.submit(new OtherTask());

            while(!timeConsumingTask.isDone() || !otherTask.isDone()) {
                System.out.println("Waiting for tasks to complete");
                TimeUnit.SECONDS.sleep(1);
            }

            System.out.println(timeConsumingTask.get());
            System.out.println(otherTask.get());

            long endTime = System.nanoTime();
            System.out.println("Time taken: " + (endTime - startTime) / 1_000_000 + " milliseconds");

            executorService.shutdown();

        }
}
