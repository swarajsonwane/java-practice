package concurrency.forkjoins;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class SumArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        ArraySumTask task = new ArraySumTask(array, 0, array.length - 1);

        ForkJoinPool pool = ForkJoinPool.commonPool();

        int sum = pool.invoke(task);

        System.out.println("The sum is " + sum);
    }

    public static class ArraySumTask extends RecursiveTask<Integer>{
        private final int[] array;
        private final int from;
        private final int to;

        public ArraySumTask(int[] array, int from, int to) {
            this.array = array;
            this.from = from;
            this.to = to;
        }



        @Override
        protected Integer compute() {
            if(to - from < 2) {
                return doCompute();
            }

            int mid = (from + to) / 2;
            ArraySumTask leftSum = new ArraySumTask(array, from, mid);
            ArraySumTask rightSum = new ArraySumTask(array, mid+1, to);

            rightSum.fork();

            return leftSum.compute() + rightSum.join();
        }

        protected Integer doCompute() {
           return IntStream.rangeClosed(from, to).sum();
        }
    }
}
