package ua.epamkpi.timonov.tasks.task03_flowcontrol;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NumberHandlerTest {
    public static final double DELTA = 1e-6;
    private NumberHandler numberHandler;

    @Before
    public void setUp() throws Exception {
        numberHandler = new NumberHandler();
    }

    @Test
    public void testGetDoublesFromStringArgumentsNormal01() throws Exception {
        String[] args = {"0.0", "2", "4", "6"};
        numberHandler.getNumbersFromStringArguments(args);
        double[] doublesExpected = {0, 2, 4, 6};
        assertArrayEquals(doublesExpected, numberHandler.getDoubleNumbers(), DELTA);
    }

    @Test
    public void testGetDoublesFromStringArgumentsNormal02() throws Exception {
        String[] args = {"-1.25", "0", "1e-3", "2e5", "16.67F"};
        numberHandler.getNumbersFromStringArguments(args);
        double[] doublesExpected = {-1.25, 0, 0.001, 200_000, 16.67};
        assertArrayEquals(doublesExpected, numberHandler.getDoubleNumbers(), DELTA);
    }

    @Test
    public void testGetDoublesFromStringArgumentsNormal03() throws Exception {
        String[] args = {"0", "2", "4", "6"};
        numberHandler.getNumbersFromStringArguments(args);
        double[] doublesExpected = {0, 2, 4, 6};
        assertArrayEquals(doublesExpected, numberHandler.getDoubleNumbers(), DELTA);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetDoublesFromStringArgumentsAbnormal01() throws Exception {
        String[] args = {"2", "4.5", "F", "0"};
        numberHandler.getNumbersFromStringArguments(args);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetDoublesFromStringArgumentsAbnormal02() throws Exception {
        String[] args = {"2", "4.5", " ", "0"};
        numberHandler.getNumbersFromStringArguments(args);
    }

    @Test(expected = NumberFormatException.class)
    public void testGetDoublesFromStringArgumentsAbnormal03() throws Exception {
        String[] args = {"36,6", "-10", "1E-6"};
        numberHandler.getNumbersFromStringArguments(args);
    }

    @Test
    public void testProcessNumbersNormal01() throws Exception {
        double[] doubleNumbers = {2.0, 4.0, 0.0, 6.0};
        numberHandler.setDoubleNumbers(doubleNumbers);
        numberHandler.processNumbers();
        assertEquals(4, numberHandler.getDoubleNumbers().length);
        assertEquals(0.0, numberHandler.getMinValue(), DELTA);
        assertEquals(6.0, numberHandler.getMaxValue(), DELTA);
        assertEquals(3.0, numberHandler.getAverageValue(), DELTA);
    }

    @Test
    public void testProcessNumbersNormal02() throws Exception {
        double[] doubleNumbers = {-2.0, 0.0, 4.0, 8.0, 10.0};
        numberHandler.setDoubleNumbers(doubleNumbers);
        numberHandler.processNumbers();
        assertEquals(5, numberHandler.getDoubleNumbers().length);
        assertEquals(-2.0, numberHandler.getMinValue(), DELTA);
        assertEquals(10.0, numberHandler.getMaxValue(), DELTA);
        assertEquals(4.0, numberHandler.getAverageValue(), DELTA);
    }

    @Test
    public void testProcessNumbersNormal03() throws Exception {
        double[] doubleNumbers = {5, 4, 3, 2, 1, 0};
        numberHandler.setDoubleNumbers(doubleNumbers);
        numberHandler.processNumbers();
        assertEquals(6, numberHandler.getDoubleNumbers().length);
        assertEquals(0.0, numberHandler.getMinValue(), DELTA);
        assertEquals(5.0, numberHandler.getMaxValue(), DELTA);
        assertEquals(2.5, numberHandler.getAverageValue(), DELTA);
    }

    @Test
    public void testProcessNumbersBoundary01() throws Exception {
        double[] doubleNumbers = {0, 0, 0};
        numberHandler.setDoubleNumbers(doubleNumbers);
        numberHandler.processNumbers();
        assertEquals(3, numberHandler.getDoubleNumbers().length);
        assertEquals(0.0, numberHandler.getMinValue(), DELTA);
        assertEquals(0.0, numberHandler.getMaxValue(), DELTA);
        assertEquals(0.0, numberHandler.getAverageValue(), DELTA);
    }

    @Test
    public void testProcessNumbersBoundary02() throws Exception {
        double[] doubleNumbers = {7};
        numberHandler.setDoubleNumbers(doubleNumbers);
        numberHandler.processNumbers();
        assertEquals(1, numberHandler.getDoubleNumbers().length);
        assertEquals(7.0, numberHandler.getMinValue(), DELTA);
        assertEquals(7.0, numberHandler.getMaxValue(), DELTA);
        assertEquals(7.0, numberHandler.getAverageValue(), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProcessNumbersAbnormal01() throws Exception {
        double[] doubleNumbers = {};
        numberHandler.setDoubleNumbers(doubleNumbers);
        numberHandler.processNumbers();
    }

    @Test
    public void testBuildAnswerOutput01() throws Exception {
        numberHandler.setDoubleNumbers(new double[]{0, 0, 0, 0, 0});
        numberHandler.setMinValue(12);
        numberHandler.setMaxValue(220);
        numberHandler.setAverageValue(110);
        String actual = numberHandler.buildAnswerOutput();
        String expected = NumberHandler.AMOUNT_OF_NUMBERS + "5" + NumberHandler.MIN_VALUE + "12.0"
                + NumberHandler.MAX_VALUE + "220.0" + NumberHandler.AVERAGE_VALUE + "110.0";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildAnswerOutput02() throws Exception {
        numberHandler.setDoubleNumbers(new double[]{0, 0, 0, 0});
        numberHandler.setMinValue(-1e-3);
        numberHandler.setMaxValue(2.5e4);
        numberHandler.setAverageValue(0);
        String actual = numberHandler.buildAnswerOutput();
        String expected = NumberHandler.AMOUNT_OF_NUMBERS + "4" + NumberHandler.MIN_VALUE + "-0.001"
                + NumberHandler.MAX_VALUE + "25000.0" + NumberHandler.AVERAGE_VALUE + "0.0";
        assertEquals(expected, actual);
    }
}