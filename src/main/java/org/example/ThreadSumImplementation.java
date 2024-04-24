package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class ThreadSumImplementation implements ThreadSum {
    private final SumImplementation sumImplementation;
    final static Logger logger = LoggerFactory.getLogger(ThreadSumImplementation.class);

    public ThreadSumImplementation(SumImplementation sumImplementation) {
        this.sumImplementation = sumImplementation;
    }

    @Override
    public int calculate(int n) {
        logger.trace("Starting calculation with {} threads", n);

        CountDownLatch latch = new CountDownLatch(n);

        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < n; j++) {
                    sumImplementation.add(j);
                    logger.trace("Thread {} added {} to the sum", Thread.currentThread().getName(), j);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        logger.warn(e.getMessage());
                    }
                }
                latch.countDown();
                logger.trace("Thread {} finished", Thread.currentThread().getName());
            });
            thread.setName("Thread " + i);
            thread.start();
            logger.trace("Thread {} started", thread.getName());
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.warn(e.getMessage());
        }

        logger.trace("All threads finished calculation");
        return sumImplementation.getSum();
    }
}
