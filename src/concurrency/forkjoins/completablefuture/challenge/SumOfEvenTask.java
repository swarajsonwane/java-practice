package concurrency.forkjoins.completablefuture.challenge;

import java.util.concurrent.Callable;

public class SumOfEvenTask implements Callable {


    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
