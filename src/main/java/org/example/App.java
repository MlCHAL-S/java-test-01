package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
    final static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        logger.info("Starting the application.");

        int N = 4;
        int sum;

        logger.info("Calculating sum for N = {}", N);

        ThreadSumImplementation threadSumImplementation = new ThreadSumImplementation(new SumImplementation());
        sum = threadSumImplementation.calculate(N);

        logger.info("Calculation finished. Sum for N = {} is {}", N, sum);

        System.out.println("N = " + N);
        System.out.println("Sum = " + sum);
    }
}
