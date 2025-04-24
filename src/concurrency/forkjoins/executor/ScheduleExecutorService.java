package concurrency.forkjoins.executor;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ScheduleExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduleExecutorService = Executors.newScheduledThreadPool(1);

        Runnable task = () ->{
            System.out.println("Executing task 1 "+ LocalDateTime.now());
        };

        ScheduledFuture<?> scheduledFuture = scheduleExecutorService.schedule(task, 5, TimeUnit.SECONDS);

        System.out.println(scheduledFuture.get());

        scheduleExecutorService.shutdown();
    }
}
