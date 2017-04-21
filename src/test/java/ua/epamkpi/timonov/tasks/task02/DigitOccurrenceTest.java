package ua.epamkpi.timonov.tasks.task02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitOccurrenceTest {
    private DigitOccurrence digitOccurrence = new DigitOccurrence();

    @Test
    public void testFindAmountOfDigitOccurrencesPositive01() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(474_748, 4);
        assertEquals(3, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesPositive02() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(474_748, 7);
        assertEquals(2, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesPositive03() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(474_748, 8);
        assertEquals(1, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesPositive04() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(474_748, 9);
        assertEquals(0, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary01() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(0, 0);
        assertEquals(1, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary02() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(0, 5);
        assertEquals(0, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary03() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(7, 7);
        assertEquals(1, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary04() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(7, 5);
        assertEquals(0, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesBoundary05() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(555_555, 5);
        assertEquals(6, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesNegative01() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(-161_216, 1);
        assertEquals(3, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesNegative02() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(-161_216, 6);
        assertEquals(2, result);
    }

    @Test
    public void testFindAmountOfDigitOccurrencesNegative03() throws Exception {
        int result = digitOccurrence.findAmountOfDigitOccurrences(-555, 5);
        assertEquals(3, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAmountOfDigitOccurrencesAbnormal01() throws Exception {
        digitOccurrence.findAmountOfDigitOccurrences(555, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAmountOfDigitOccurrencesAbnormal02() throws Exception {
        digitOccurrence.findAmountOfDigitOccurrences(555, 11);
    }
}