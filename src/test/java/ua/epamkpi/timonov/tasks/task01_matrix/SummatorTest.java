package ua.epamkpi.timonov.tasks.task01_matrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SummatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumMatrixWithNull1() throws Exception {
        Matrix matrix2 = MatrixFactory.createMatrix(2, 3);
        Summator.sumMatrix(null, matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumMatrixWithNull2() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(3, 2);
        Summator.sumMatrix(matrix1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumOneMatrixWithIllegalSize1() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(0, 2);
        Matrix matrix2 = MatrixFactory.createMatrix(2, 2);
        Summator.sumMatrix(matrix1, matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumOneMatrixWithIllegalSize2() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(3, -1);
        Matrix matrix2 = MatrixFactory.createMatrix(2, 2);
        Summator.sumMatrix(matrix1, matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumOneMatrixWithIllegalSize3() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(3, 2);
        Matrix matrix2 = MatrixFactory.createMatrix(-2, 3);
        Summator.sumMatrix(matrix1, matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumOneMatrixWithIllegalSize4() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(-1, 2);
        Matrix matrix2 = MatrixFactory.createMatrix(2, 0);
        Summator.sumMatrix(matrix1, matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumTwoMatricesWithIllegalSize() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(-1, 2);
        Matrix matrix2 = MatrixFactory.createMatrix(2, 0);
        Summator.sumMatrix(matrix1, matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumTwoMatricesWithDifferentSizes1() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(3, 2);
        Matrix matrix2 = MatrixFactory.createMatrix(3, 3);
        Summator.sumMatrix(matrix1, matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumTwoMatricesWithDifferentSizes2() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(3, 3);
        Matrix matrix2 = MatrixFactory.createMatrix(4, 3);
        Summator.sumMatrix(matrix1, matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAbnormalSumTwoMatricesWithDifferentSizes3() throws Exception {
        Matrix matrix1 = MatrixFactory.createMatrix(3, 2);
        Matrix matrix2 = MatrixFactory.createMatrix(4, 4);
        Summator.sumMatrix(matrix1, matrix2);
    }

    @Test
    public void testSumNormalMatrix1() throws Exception {
        Matrix matrix1 = new Matrix(2, 3);
        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);
        matrix1.setElement(0, 2, 3);
        matrix1.setElement(1, 0, 4);
        matrix1.setElement(1, 1, 5);
        matrix1.setElement(1, 2, 6);
        Matrix matrix2 = new Matrix(2, 3);
        matrix2.setElement(0, 0, 2);
        matrix2.setElement(0, 1, 4);
        matrix2.setElement(0, 2, 6);
        matrix2.setElement(1, 0, 8);
        matrix2.setElement(1, 1, 10);
        matrix2.setElement(1, 2, 12);
        Matrix resultMatrix = Summator.sumMatrix(matrix1, matrix2);
        assertEquals(3, resultMatrix.getElement(0, 0));
        assertEquals(6, resultMatrix.getElement(0, 1));
        assertEquals(9, resultMatrix.getElement(0, 2));
        assertEquals(12, resultMatrix.getElement(1, 0));
        assertEquals(15, resultMatrix.getElement(1, 1));
        assertEquals(18, resultMatrix.getElement(1, 2));
    }

    @Test
    public void testSumNormalMatrix2() throws Exception {
        Matrix matrix1 = new Matrix(3, 2);
        matrix1.setElement(0, 0, -5);
        matrix1.setElement(0, 1, -7);
        matrix1.setElement(1, 0, 6);
        matrix1.setElement(1, 1, 4);
        matrix1.setElement(2, 0, 0);
        matrix1.setElement(2, 1, 7);
        Matrix matrix2 = new Matrix(3, 2);
        matrix2.setElement(0, 0, -3);
        matrix2.setElement(0, 1, 7);
        matrix2.setElement(1, 0, -9);
        matrix2.setElement(1, 1, 8);
        matrix2.setElement(2, 0, 0);
        matrix2.setElement(2, 1, 2);
        Matrix resultMatrix = Summator.sumMatrix(matrix1, matrix2);
        assertEquals(-8, resultMatrix.getElement(0, 0));
        assertEquals(0, resultMatrix.getElement(0, 1));
        assertEquals(-3, resultMatrix.getElement(1, 0));
        assertEquals(12, resultMatrix.getElement(1, 1));
        assertEquals(0, resultMatrix.getElement(2, 0));
        assertEquals(9, resultMatrix.getElement(2, 1));
    }

    @Test
    public void testSumNormalMatrix3() throws Exception {
        Matrix matrix1 = new Matrix(1, 1);
        matrix1.setElement(0, 0, 5);
        Matrix matrix2 = new Matrix(1, 1);
        matrix2.setElement(0, 0, 7);
        Matrix resultMatrix = Summator.sumMatrix(matrix1, matrix2);
        assertEquals(12, resultMatrix.getElement(0, 0));
    }
}