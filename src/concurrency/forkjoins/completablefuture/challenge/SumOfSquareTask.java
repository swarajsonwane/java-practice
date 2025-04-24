package concurrency.forkjoins.completablefuture.challenge;

import java.util.concurrent.Callable;

public class SumOfSquareTask implements Callable {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i * i;
            }
            return sum;
        }
}
