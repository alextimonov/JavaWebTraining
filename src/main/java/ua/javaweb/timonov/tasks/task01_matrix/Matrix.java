package ua.javaweb.timonov.tasks.task01_matrix;

/**
 * Represents two-dimensional matrix
 */
public class Matrix {

    public static final String INDEXES_SHOULD_BE_POSITIVE = "Element indexes should be positive";
    public static final String MATRIX_SIZES_SHOULD_BE_POSITIVE = "Matrix sizes should be positive";
    public static final String ROW_SHOULD_BE_LESS_THAN_VERTICAL_SIZE =
            "Row should be less than matrix's vertical size";
    public static final String COLUMN_SHOULD_BE_LESS_THAN_HORIZONTAL_SIZE =
            "Column should be less than matrix's horizontal size";

    /* array with matrix's elements */
    private int[][] array;

    /**
     * constructor for Matrix with given number of rows and columns
     * @param verticalSize          number of rows
     * @param horizontalSize        number of columns
     */
    public Matrix(int verticalSize, int horizontalSize) {
        checkSizes(verticalSize, horizontalSize);
        array = new int[verticalSize][horizontalSize];
    }

    private void checkSizes(int verticalSize, int horizontalSize) {
        if (verticalSize < 1 || horizontalSize < 1) {
            throw new IllegalArgumentException(MATRIX_SIZES_SHOULD_BE_POSITIVE);
        }
    }

    /**
     * returns matrix's element with indexes row and column
     * @param row           element's row
     * @param column        element's column
     * @return              matrix's element
     * @throws IllegalArgumentException if illegal indexes (row or column) are received
     */
    public int getElement(int row, int column) {
        checkElementIndexes(row, column);
        return array[row][column];
    }

    /**
     * sets matrix's element on row i and column j
     * @param row           element's row
     * @param column        element's column
     * @param value         element's value to be set
     * @throws IllegalArgumentException if illegal indexes (row or column) are received
     */
    public void setElement(int row, int column, int value) {
        checkElementIndexes(row, column);
        array[row][column] = value;
    }

    private void checkElementIndexes(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException(INDEXES_SHOULD_BE_POSITIVE);
        }
        if (row >= array.length) {
            throw new IllegalArgumentException(ROW_SHOULD_BE_LESS_THAN_VERTICAL_SIZE);
        }
        if (column >= array[0].length) {
            throw new IllegalArgumentException(COLUMN_SHOULD_BE_LESS_THAN_HORIZONTAL_SIZE);
        }
    }

    /**
     * returns number of matrix's columns
     * @return      number of matrix's columns
     */
    public int getHorizontalSize() {
        return array[0].length;
    }

    /**
     * returns number of matrix's rows
     * @return      number of matrix's rows
     */
    public int getVerticalSize() {
        return array.length;
    }

    /**
     * creates String view for matrix
     * @return      string with matrix's elements
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                String stringValue = String.format("%5d", array[i][j]);
                sb.append(stringValue);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
