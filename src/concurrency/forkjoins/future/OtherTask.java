package concurrency.forkjoins.future;

import java.util.concurrent.Callable;

public class OtherTask implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("OtherTask started");
            Thread.sleep(100);
            System.out.println("OtherTask completed");
            return "Task completed";
        }
}
