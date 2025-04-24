package concurrency.forkjoins.future;

import java.util.concurrent.Callable;

public class TimeConsumingTask implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("TimeConsumingTask started");
        Thread.sleep(5000);
        System.out.println("TimeConsumingTask completed");
        return "Task completed";
    }
}
