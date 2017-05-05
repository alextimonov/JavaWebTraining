package ua.javaweb.timonov.tasks.task01_matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMatrixAbnormal1() throws Exception {
        MatrixFactory.createMatrix(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMatrixAbnormal2() throws Exception {
        MatrixFactory.createMatrix(2, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMatrixAbnormal3() throws Exception {
        MatrixFactory.createMatrix(-2, 3);
    }

    @Test
    public void testCreateMatrixNormal() throws Exception {
        Matrix matrix = MatrixFactory.createMatrix(2, 3);
        assertEquals(2, matrix.getVerticalSize());
        assertEquals(3, matrix.getHorizontalSize());
    }
}