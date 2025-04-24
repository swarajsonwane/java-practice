package concurrency.forkjoins;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class DelegateApplePickUsingForkAndJoin {

    public static void main(String... args) {
        //Explain fork
        // process of breaking down a task into smaller tasks and then executing them in parallel
        //delegating the task to a pool of threads is called forking and joining the results of these tasks is called joining
        //compute method is the method that is called when the task is executed and it is the method that is
        // responsible for breaking down the task into smaller tasks

        AppleTree[] appleTrees = AppleTree.newTreeGarden(6);
        ForkJoinPool pool = ForkJoinPool.commonPool();

        PickApplesTask task = new PickApplesTask(appleTrees, 0, (appleTrees.length - 1));

        //Task is executed by calling the invoke method on the pool which internally calls the compute method
        int result = pool.invoke(task);

        //what happens when pool.execute(task) is called?
        //The task is executed asynchronously and the result is not returned


        System.out.println("Total apples picked: " + result);

    }

    public static class PickApplesTask extends RecursiveTask<Integer> {
        private final AppleTree[] appleTrees;
        private final int fromIndexInclusive;
        private final int endExclusive;

        private final int taskThreshold =4 ;

        public PickApplesTask(AppleTree[] appleTrees, int fromIndexInclusive, int endExclusive) {
            this.appleTrees = appleTrees;
            this.fromIndexInclusive = fromIndexInclusive;
            this.endExclusive = endExclusive;
        }

        @Override
        protected Integer compute() {
            // base case is when the task is small enough to be computed
            if(endExclusive - fromIndexInclusive < taskThreshold) {
                return doCompute();
            }

            //split the task into two smaller tasks
            int midPoint = (fromIndexInclusive + endExclusive) / 2;
            PickApplesTask leftSum = new PickApplesTask(appleTrees, fromIndexInclusive, midPoint);
            PickApplesTask rightSum = new PickApplesTask(appleTrees, midPoint+1, endExclusive);


            //why right sum is forked and left sum is computed
            //forking the task means that the task is delegated to a pool of threads
            //right is forked because it is the task that is going to be executed in parallel
            //left is computed because it is the task that is going to be executed in the current thread
            //so the current thread will wait for the left task to complete and then it will join the result of the right task
            rightSum.fork();

            //join the result of the right task but compute the left task
            //sequential computation of the left task and parallel computation of the right task

            return leftSum.compute() + rightSum.join();

        }

        protected Integer doCompute() {
            return IntStream.rangeClosed(fromIndexInclusive, endExclusive)
                    .map(i -> appleTrees[i].pickApples("Alice"))
                    .sum();
        }


    }
}
