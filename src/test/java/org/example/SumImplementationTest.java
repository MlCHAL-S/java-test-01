package org.example;

import junit.framework.TestCase;

public class SumImplementationTest extends TestCase {

    public void testAdd() {
        SumImplementation sumImplementation = new SumImplementation();

        sumImplementation.add(5);
        sumImplementation.add(5);
        sumImplementation.add(5);

        assertEquals(15, sumImplementation.getSum());
    }

    public void testGetSum() {
        SumImplementation sumImplementation = new SumImplementation();

        // Sprawdź, czy suma jest równa 0, gdy nie dodano żadnych wartości
        assertEquals(0, sumImplementation.getSum());
    }
}