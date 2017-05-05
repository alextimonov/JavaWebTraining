package ua.epamkpi.timonov.tasks.task01_matrix;

/**
 * Represents adding two matrices
 */
public class Summator {

    public static final String MATRICES_SHOULD_NOT_BE_NULL = "Matrices should not be null";
    public static final String SIZES_SHOULD_BE_POSITIVE = "Matrix's sizes should be positive";
    public static final String MATRICES_HAVE_DIFFERENT_SIZES = "Matrices have different sizes";

    /**
     * finds sum of two matrices
     * @param matrix1   matrix #1 to be added
     * @param matrix2   matrix #2 to be added
     * @return          matrix, result of adding two matrices
     * @throws          IllegalArgumentException if any matrix is null or matrices have illegal sizes to add
     */
    public static Matrix sumMatrix(Matrix matrix1, Matrix matrix2) {
        checkArgumentsForAddMatrices(matrix1, matrix2);
        int verticalSize1 = matrix1.getVerticalSize();
        int horizontalSize1 = matrix1.getHorizontalSize();
        Matrix sumMatrix = new Matrix(verticalSize1, horizontalSize1);
        int sumElement;
        for (int i = 0; i < verticalSize1; i++) {
            for (int j = 0; j < horizontalSize1; j++) {
                sumElement = matrix1.getElement(i, j) + matrix2.getElement(i, j);
                sumMatrix.setElement(i, j, sumElement);
            }
        }
        return sumMatrix;
    }

    /* checks if two matrices can be added */
    private static void checkArgumentsForAddMatrices(Matrix matrix1, Matrix matrix2) {
        if (anyMatrixIsNull(matrix1, matrix2)) {
            throw new IllegalArgumentException(MATRICES_SHOULD_NOT_BE_NULL);
        }

        int verticalSize1 = matrix1.getVerticalSize();
        int horizontalSize1 = matrix1.getHorizontalSize();
        int verticalSize2 = matrix2.getVerticalSize();
        int horizontalSize2 = matrix2.getHorizontalSize();

        if (anyMatrixSizeIsNotPositive(verticalSize1, horizontalSize1)
                || anyMatrixSizeIsNotPositive(verticalSize2, horizontalSize2)) {
            throw new IllegalArgumentException(SIZES_SHOULD_BE_POSITIVE);
        }
        if (matricesHaveDifferentSizes(verticalSize1, horizontalSize1, verticalSize2, horizontalSize2)) {
            throw new IllegalArgumentException(MATRICES_HAVE_DIFFERENT_SIZES);
        }
    }

    private static boolean anyMatrixIsNull(Matrix matrix1, Matrix matrix2) {
        return matrix1 == null || matrix2 == null;
    }

    private static boolean anyMatrixSizeIsNotPositive(int verticalSize, int horizontalSize) {
        return verticalSize <= 0 || horizontalSize <= 0;
    }

    private static boolean matricesHaveDifferentSizes(int verticalSize1, int horizontalSize1,
                                                      int verticalSize2, int horizontalSize2) {
        return verticalSize1 != verticalSize2 || horizontalSize1 != horizontalSize2;
    }
}
