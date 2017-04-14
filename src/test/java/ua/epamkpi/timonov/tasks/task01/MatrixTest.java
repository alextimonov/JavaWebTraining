package ua.epamkpi.timonov.tasks.task01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {
    private Matrix matrix;

    @Before
    public void setUp() throws Exception {
        matrix = new Matrix(2, 3);
        matrix.setElement(0, 0, 2);
        matrix.setElement(0, 1, 4);
        matrix.setElement(0, 2, 6);
        matrix.setElement(1, 0, 5);
        matrix.setElement(1, 1, -7);
        matrix.setElement(1, 2, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixConstructorAbnormal1() throws Exception {
        new Matrix(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMatrixConstructorAbnormal2() throws Exception {
        new Matrix(2, -2);
    }

    @Test
    public void testMatrixConstructorNormal1() throws Exception {
        Matrix matrix = new Matrix(2, 3);
        assertEquals(2, matrix.getVerticalSize());
        assertEquals(3, matrix.getHorizontalSize());
        assertEquals(0, matrix.getElement(0, 0));
        assertEquals(0, matrix.getElement(0, 2));
        assertEquals(0, matrix.getElement(1, 0));
        assertEquals(0, matrix.getElement(1, 1));
    }

    @Test
    public void testGetElementNormal() throws Exception {
        assertEquals(2, matrix.getElement(0, 0));
        assertEquals(4, matrix.getElement(0, 1));
        assertEquals(6, matrix.getElement(0, 2));
        assertEquals(5, matrix.getElement(1, 0));
        assertEquals(-7, matrix.getElement(1, 1));
        assertEquals(0, matrix.getElement(1, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementAbnormal1() throws Exception {
        matrix.getElement(0, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementAbnormal2() throws Exception {
        matrix.getElement(-2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementAbnormal3() throws Exception {
        matrix.getElement(2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementAbnormal4() throws Exception {
        matrix.getElement(1, 4);
    }

    @Test
    public void testSetElementNormal() throws Exception {
        matrix.setElement(0, 0, 5);
        matrix.setElement(1, 1, Integer.MAX_VALUE);
        matrix.setElement(1, 2, Integer.MIN_VALUE);
        assertEquals(5, matrix.getElement(0, 0));
        assertEquals(Integer.MAX_VALUE, matrix.getElement(1, 1));
        assertEquals(Integer.MIN_VALUE, matrix.getElement(1, 2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void tesSetElementAbnormal1() throws Exception {
        matrix.setElement(0, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementAbnormal2() throws Exception {
        matrix.setElement(-2, 1, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementAbnormal3() throws Exception {
        matrix.setElement(2, 2, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementAbnormal4() throws Exception {
        matrix.setElement(1, 4, 100);
    }

    @Test
    public void testGetHorizontalSizeNormal1() throws Exception {
        assertEquals(3, matrix.getHorizontalSize());
    }

    @Test
    public void testGetHorizontalSizeNormal2() throws Exception {
        Matrix newMatrix = new Matrix(2, 5);
        assertEquals(5, newMatrix.getHorizontalSize());
    }

    @Test
    public void testGetVerticalSizeNormal1() throws Exception {
        assertEquals(2, matrix.getVerticalSize());
    }

    @Test
    public void testGetVerticalSizeNormal2() throws Exception {
        Matrix newMatrix = new Matrix(3, 5);
        assertEquals(3, newMatrix.getVerticalSize());
    }

    @Test
    public void testToStringNormal1() throws Exception {
        String lines = "    2    4    6\n    5   -7    0\n";
        assertEquals(lines, matrix.toString());
    }

    @Test
    public void testToStringNormal2() throws Exception {
        Matrix newMatrix = new Matrix(3, 2);
        String lines = "    0    0\n    0    0\n    0    0\n";
        assertEquals(lines, newMatrix.toString());
    }
}