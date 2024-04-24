package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumImplementation implements Sum {
    private int sum = 0;
    private final Object lock = new Object();
    final static Logger logger = LoggerFactory.getLogger(SumImplementation.class);

    @Override
    public void add(int n) {
        synchronized (lock) {
            sum += n;
            logger.trace("Added {} to the sum. Current sum: {}", n, sum);
        }
    }

    @Override
    public int getSum() {
        synchronized (lock) {
            logger.trace("Returning sum: {}", sum);
            return sum;
        }
    }
}
