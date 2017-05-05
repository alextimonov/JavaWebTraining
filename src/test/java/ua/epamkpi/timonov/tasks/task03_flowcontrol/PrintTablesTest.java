package ua.epamkpi.timonov.tasks.task03_flowcontrol;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrintTablesTest {
    PrintTables printTables = new PrintTables();

    @Test
    public void testBuildLeftTableIncreasingByDiagonalNormal01() throws Exception {
        String actual = printTables.buildLeftTableIncreasingByDiagonal(0, 4);
        String expected = "0 \n1 0 \n2 1 0 \n3 2 1 0 \n4 3 2 1 0 \n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildLeftTableIncreasingByDiagonalNormal02() throws Exception {
        String actual = printTables.buildLeftTableIncreasingByDiagonal(1, 3);
        String expected = "1 \n2 1 \n3 2 1 \n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildLeftTableIncreasingByDiagonalNormal03() throws Exception {
        String actual = printTables.buildLeftTableIncreasingByDiagonal(2, 5);
        String expected = "2 \n3 2 \n4 3 2 \n5 4 3 2 \n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildLeftTableIncreasingByDiagonalBoundary01() throws Exception {
        String actual = printTables.buildLeftTableIncreasingByDiagonal(1, 1);
        String expected = "1 \n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildLeftTableIncreasingByDiagonalAbnormal01() throws Exception {
        String actual = printTables.buildLeftTableIncreasingByDiagonal(1, 0);
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildRightTableDecreasingByHorizontalNormal01() throws Exception {
        String actual = printTables.buildRightTableDecreasingByHorizontal(0, 2);
        String expected = "    0 \n  1 0 \n2 1 0 \n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildRightTableDecreasingByHorizontalNormal02() throws Exception {
        String actual = printTables.buildRightTableDecreasingByHorizontal(1, 5);
        String expected = "        1 \n      2 1 \n    3 2 1 \n  4 3 2 1 \n5 4 3 2 1 \n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildRightTableDecreasingByHorizontalNormal03() throws Exception {
        String actual = printTables.buildRightTableDecreasingByHorizontal(2, 5);
        String expected = "      2 \n    3 2 \n  4 3 2 \n5 4 3 2 \n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildRightTableDecreasingByHorizontalBoundary01() throws Exception {
        String actual = printTables.buildRightTableDecreasingByHorizontal(1, 1);
        String expected = "1 \n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuildRightTableDecreasingByHorizontalAbnormal01() throws Exception {
        String actual = printTables.buildRightTableDecreasingByHorizontal(1, 0);
        String expected = "";
        assertEquals(expected, actual);
    }
}