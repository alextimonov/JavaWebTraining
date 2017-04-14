package ua.epamkpi.timonov.tasks.task01;

import java.util.Random;

/**
 * Represents factory to create matrix
 */
public class MatrixFactory {

    /**
     * creates matrix with given sizes
     * @param verticalSize      number of rows in the matrix
     * @param horizontalSize    number of columns in the matrix
     * @return      created matrix with given sizes and random elements
     * @throws      IllegalArgumentException if any matrix's size is not positive
     */
    public static Matrix createMatrix(int verticalSize, int horizontalSize) {
        checkArguments(verticalSize, horizontalSize);
        Matrix matrix = new Matrix(verticalSize, horizontalSize);
        Random random = new Random();
        int currentElement;
        for (int i = 0; i < verticalSize; i++) {
            for (int j = 0; j < horizontalSize; j++) {
                currentElement = (int) (random.nextDouble() * verticalSize * horizontalSize);
                matrix.setElement(i, j, currentElement);
            }
        }
        return matrix;
    }

    private static void checkArguments(int verticalSize, int horizontalSize) {
        if (verticalSize <= 0 || horizontalSize <= 0) {
            throw new IllegalArgumentException("Matrix's sizes should be positive");
        }
    }
}
