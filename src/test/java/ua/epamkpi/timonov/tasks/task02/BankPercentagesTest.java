package ua.epamkpi.timonov.tasks.task02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankPercentagesTest {
    private BankPercentages bankPercentages = new BankPercentages();

    @Test
    public void testFindTermNormal01() throws Exception {
        assertEquals(4, bankPercentages.findTermWhileDoLoop(1000, 2000, 20));
        assertEquals(4, bankPercentages.findTermDoWhileLoop(1000, 2000, 20));
        assertEquals(4, bankPercentages.findTermForLoop(1000, 2000, 20));

        assertEquals(4, bankPercentages.findTermWhileDoLoopWithBreak(1000, 2000, 20));
        assertEquals(4, bankPercentages.findTermDoWhileLoopWithBreak(1000, 2000, 20));
        assertEquals(4, bankPercentages.findTermForLoopWithBreak(1000, 2000, 20));

        assertEquals(4, bankPercentages.findTermWhileDoLoopWithBreakAndLabel(1000, 2000, 20));
        assertEquals(4, bankPercentages.findTermDoWhileLoopWithBreakAndLabel(1000, 2000, 20));
        assertEquals(4, bankPercentages.findTermForLoopWithBreakAndLabel(1000, 2000, 20));

        assertEquals(4, bankPercentages.findTermWhileDoLoopWithReturn(1000, 2000, 20));
        assertEquals(4, bankPercentages.findTermDoWhileLoopWithReturn(1000, 2000, 20));
        assertEquals(4, bankPercentages.findTermForLoopWithReturn(1000, 2000, 20));
    }

    @Test
    public void testFindTermNormal02() throws Exception {
        assertEquals(5, bankPercentages.findTermWhileDoLoop(100, 150, 10));
        assertEquals(5, bankPercentages.findTermDoWhileLoop(100, 150, 10));
        assertEquals(5, bankPercentages.findTermForLoop(100, 150, 10));

        assertEquals(5, bankPercentages.findTermWhileDoLoopWithBreak(100, 150, 10));
        assertEquals(5, bankPercentages.findTermDoWhileLoopWithBreak(100, 150, 10));
        assertEquals(5, bankPercentages.findTermForLoopWithBreak(100, 150, 10));

        assertEquals(5, bankPercentages.findTermWhileDoLoopWithBreakAndLabel(100, 150, 10));
        assertEquals(5, bankPercentages.findTermDoWhileLoopWithBreakAndLabel(100, 150, 10));
        assertEquals(5, bankPercentages.findTermForLoopWithBreakAndLabel(100, 150, 10));

        assertEquals(5, bankPercentages.findTermWhileDoLoopWithReturn(100, 150, 10));
        assertEquals(5, bankPercentages.findTermDoWhileLoopWithReturn(100, 150, 10));
        assertEquals(5, bankPercentages.findTermForLoopWithReturn(100, 150, 10));
    }

    @Test
    public void testFindTermNormal03() throws Exception {
        assertEquals(12, bankPercentages.findTermWhileDoLoop(100, 300, 10));
        assertEquals(12, bankPercentages.findTermDoWhileLoop(100, 300, 10));
        assertEquals(12, bankPercentages.findTermForLoop(100, 300, 10));

        assertEquals(12, bankPercentages.findTermWhileDoLoopWithBreak(100, 300, 10));
        assertEquals(12, bankPercentages.findTermDoWhileLoopWithBreak(100, 300, 10));
        assertEquals(12, bankPercentages.findTermForLoopWithBreak(100, 300, 10));

        assertEquals(12, bankPercentages.findTermWhileDoLoopWithBreakAndLabel(100, 300, 10));
        assertEquals(12, bankPercentages.findTermDoWhileLoopWithBreakAndLabel(100, 300, 10));
        assertEquals(12, bankPercentages.findTermForLoopWithBreakAndLabel(100, 300, 10));

        assertEquals(12, bankPercentages.findTermWhileDoLoopWithReturn(100, 300, 10));
        assertEquals(12, bankPercentages.findTermDoWhileLoopWithReturn(100, 300, 10));
        assertEquals(12, bankPercentages.findTermForLoopWithReturn(100, 300, 10));
    }

    @Test
    public void testFindTermNormal04() throws Exception {
        assertEquals(15, bankPercentages.findTermWhileDoLoop(100, 200, 5));
        assertEquals(15, bankPercentages.findTermDoWhileLoop(100, 200, 5));
        assertEquals(15, bankPercentages.findTermForLoop(100, 200, 5));

        assertEquals(15, bankPercentages.findTermWhileDoLoopWithBreak(100, 200, 5));
        assertEquals(15, bankPercentages.findTermDoWhileLoopWithBreak(100, 200, 5));
        assertEquals(15, bankPercentages.findTermForLoopWithBreak(100, 200, 5));

        assertEquals(15, bankPercentages.findTermWhileDoLoopWithBreakAndLabel(100, 200, 5));
        assertEquals(15, bankPercentages.findTermDoWhileLoopWithBreakAndLabel(100, 200, 5));
        assertEquals(15, bankPercentages.findTermForLoopWithBreakAndLabel(100, 200, 5));

        assertEquals(15, bankPercentages.findTermWhileDoLoopWithReturn(100, 200, 5));
        assertEquals(15, bankPercentages.findTermDoWhileLoopWithReturn(100, 200, 5));
        assertEquals(15, bankPercentages.findTermForLoopWithReturn(100, 200, 5));
    }

    @Test
    public void testFindTermBoundary01() throws Exception {
        assertEquals(0, bankPercentages.findTermWhileDoLoop(1000, 1000, 10));
        assertEquals(0, bankPercentages.findTermDoWhileLoop(1000, 1000, 10));
        assertEquals(0, bankPercentages.findTermForLoop(1000, 1000, 10));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithBreak(1000, 1000, 10));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithBreak(1000, 1000, 10));
        assertEquals(0, bankPercentages.findTermForLoopWithBreak(1000, 1000, 10));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithBreakAndLabel(1000, 1000, 10));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithBreakAndLabel(1000, 1000, 10));
        assertEquals(0, bankPercentages.findTermForLoopWithBreakAndLabel(1000, 1000, 10));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithReturn(1000, 1000, 10));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithReturn(1000, 1000, 10));
        assertEquals(0, bankPercentages.findTermForLoopWithReturn(1000, 1000, 10));
    }

    @Test
    public void testFindTermBoundary02() throws Exception {
        assertEquals(0, bankPercentages.findTermWhileDoLoop(1100, 1000, 5));
        assertEquals(0, bankPercentages.findTermDoWhileLoop(1100, 1000, 5));
        assertEquals(0, bankPercentages.findTermForLoop(1100, 1000, 5));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithBreak(1100, 1000, 5));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithBreak(1100, 1000, 5));
        assertEquals(0, bankPercentages.findTermForLoopWithBreak(1100, 1000, 5));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithBreakAndLabel(1100, 1000, 5));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithBreakAndLabel(1100, 1000, 5));
        assertEquals(0, bankPercentages.findTermForLoopWithBreakAndLabel(1100, 1000, 5));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithReturn(1100, 1000, 5));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithReturn(1100, 1000, 5));
        assertEquals(0, bankPercentages.findTermForLoopWithReturn(1100, 1000, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTermWhileDoBoundary03() throws Exception {
        assertEquals(0, bankPercentages.findTermWhileDoLoop(1000, 1000, 0));
        assertEquals(0, bankPercentages.findTermDoWhileLoop(1000, 1000, 0));
        assertEquals(0, bankPercentages.findTermForLoop(1000, 1000, 0));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithBreak(1000, 1000, 0));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithBreak(1000, 1000, 0));
        assertEquals(0, bankPercentages.findTermForLoopWithBreak(1000, 1000, 0));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithBreakAndLabel(1000, 1000, 0));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithBreakAndLabel(1000, 1000, 0));
        assertEquals(0, bankPercentages.findTermForLoopWithBreakAndLabel(1000, 1000, 0));

        assertEquals(0, bankPercentages.findTermWhileDoLoopWithReturn(1000, 1000, 0));
        assertEquals(0, bankPercentages.findTermDoWhileLoopWithReturn(1000, 1000, 0));
        assertEquals(0, bankPercentages.findTermForLoopWithReturn(1000, 1000, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTermWhileDoAbnormal01() throws Exception {
        bankPercentages.findTermWhileDoLoop(-100, 200, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTermWhileDoAbnormal02() throws Exception {
        bankPercentages.findTermWhileDoLoop(100, -200, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTermWhileDoAbnormal03() throws Exception {
        bankPercentages.findTermWhileDoLoop(100, 200, -10);
    }
}