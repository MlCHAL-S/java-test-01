package org.example;

import junit.framework.TestCase;

public class ThreadSumImplementationTest extends TestCase {

    public void testCalculate() {
        int N = 10;

        ThreadSumImplementation threadSumImplementation = new ThreadSumImplementation(new SumImplementation());

        assertEquals(450, threadSumImplementation.calculate(N));
    }
}