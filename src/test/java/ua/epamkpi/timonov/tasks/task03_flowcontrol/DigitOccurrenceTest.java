package ua.epamkpi.timonov.tasks.task03_flowcontrol;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitOccurrenceTest {
    private DigitOccurrence digitOccurrence = new DigitOccurrence();

    @Test
    public void testFindAmountOfDigitOccurrencesPositive01() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(474_748, (byte) 4);
        assertEquals(3, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesPositive02() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(474_748, (byte) 7);
        assertEquals(2, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesPositive03() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(474_748, (byte) 8);
        assertEquals(1, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesPositive04() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(474_748, (byte) 9);
        assertEquals(0, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary01() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(0, (byte) 0);
        assertEquals(1, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary02() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(0, (byte) 5);
        assertEquals(0, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary03() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(7, (byte) 7);
        assertEquals(1, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary04() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(7, (byte) 5);
        assertEquals(0, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary05() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(555_555, (byte) 5);
        assertEquals(6, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesNegative01() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(-161_216, (byte) 1);
        assertEquals(3, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesNegative02() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(-161_216, (byte) 6);
        assertEquals(2, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesNegative03() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(-555, (byte) 5);
        assertEquals(3, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesAbnormal01() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(555, (byte) -5);
        assertEquals(-1, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesAbnormal02() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(555, (byte) 11);
        assertEquals(-1, result);
    }
}