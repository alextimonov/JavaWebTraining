package ua.javaweb.timonov.tasks.task03_flowcontrol;

/**
 * Represents constructing some types of non-regular tables of numbers
 */
public class PrintTables {

    public static final String SPACE = " ";
    public static final String DOUBLE_SPACE = "  ";
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        new PrintTables().run();
    }

    /**
     * starts building tables and prints them
     */
    private void run() {
        String leftTable = buildLeftTableIncreasingByDiagonal(0, 4);
        System.out.println("Left table:");
        System.out.println(leftTable);

        String rightTable = buildRightTableDecreasingByHorizontal(1, 5);
        System.out.println("Right table:");
        System.out.println(rightTable);
    }

    /**
     * builds non-regular left-handed table with values increasing by diagonal
     * @param startValue        start value in a table
     * @param endValue          end value in a table
     * @return                  string to be printed
     */
    public String buildLeftTableIncreasingByDiagonal(int startValue, int endValue) {
        StringBuilder sb = new StringBuilder();
        for (int i = startValue; i <= endValue; i++) {
            for (int j = i; j >= startValue; j--) {
                sb.append(j).append(SPACE);
            }
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }

    /**
     * builds non-regular right-handed table with values decreasing by horizontal
     * @param startValue        start value in a table
     * @param endValue          end value in a table
     * @return                  string to be printed
     */
    public String buildRightTableDecreasingByHorizontal(int startValue, int endValue) {
        StringBuilder sb = new StringBuilder();
        for (int i = startValue; i <= endValue; i++) {
            for (int j = endValue; j >= i + 1 ; j--) {
                sb.append(DOUBLE_SPACE);
            }
            for (int j = i; j >= startValue; j--) {
                sb.append(j).append(SPACE);
            }
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }
}
