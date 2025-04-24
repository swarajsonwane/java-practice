package concurrency.forkjoins;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

public class ApplePickParallel {


    public static void main(String... args) {
        AppleTree[] appleTrees = AppleTree.newTreeGarden(6);

        Callable<Void> applePicker1 = createApplePicker(appleTrees, 0, 2, "Alice");
        Callable<Void> applePicker2 = createApplePicker(appleTrees, 2, 4, "Bob");
        Callable<Void> applePicker3 = createApplePicker(appleTrees, 4, 6, "Carol");

        //now we can run these tasks in parallel by submitting them to a ForkJoinPool
        //how fork join pool works is that it will create a pool of threads and then it will assign these tasks to these threads
        //and then it will wait for all the tasks to complete
        //Forkjoin pool is a special kind of executor service that is optimized for recursive tasks
        //it is optimized for tasks that can be broken down into smaller tasks and then executed in parallel
        // it requires a list of tasks that are to be executed in parallel
        //ForkJoinPool.commonPool() is a shared pool of threads available for common parallel tasks.
        ForkJoinPool.commonPool().invokeAll(Arrays.asList(applePicker1, applePicker2, applePicker3));

        System.out.println("All apple pickers finished their work");
    }

    //This method returns a Callable<Void>. This is a task that, when executed, will pick apples from a subset of trees in parallel.
    public static Callable<Void> createApplePicker(AppleTree[] appleTrees, int fromIndexInclusive, int toIndexExclusive, String workerName) {
        return () -> {
            for (int i = fromIndexInclusive; i < toIndexExclusive; i++) {
                appleTrees[i].pickApples(workerName);
            }
            return null;
        };
    }
}
