package ua.epamkpi.timonov.tasks.task01_matrix;

public class MatrixRunner {
    public static void main(String[] args) {
        new MatrixRunner().run();
    }

    private void run() {
        Matrix matrix1 = MatrixFactory.createMatrix(3, 4);
        Matrix matrix2 = MatrixFactory.createMatrix(3, 4);
        Matrix resultMatrix = Summator.sumMatrix(matrix1, matrix2);

        System.out.println("Matrix #1:");
        System.out.println(matrix1.toString());
        System.out.println("Matrix #2:");
        System.out.println(matrix2.toString());
        System.out.println("Result matrix:");
        System.out.println(resultMatrix.toString());
    }
}
