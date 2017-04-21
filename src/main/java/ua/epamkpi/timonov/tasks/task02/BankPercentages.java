package ua.epamkpi.timonov.tasks.task02;

/**
 * Represents search for years needed to get required sum if start sum is put to a bank at a percentage rate
 */
public class BankPercentages {

    public static final int HUNDRED = 100;
    public static final String REQUIRED_NUMBER_OF_YEARS = "Required number of years: ";
    public static final String ARGUMENTS_SHOULD_BE_POSITIVE = "Arguments should be positive";
    public static final int NOT_VALID_ARGUMENTS = -1;

    public static void main(String[] args) {
        new BankPercentages().run();
    }

    /**
     * starts one of possible method to find number of years, prints the answer
     */
    private void run() {
        int years = findTermForLoopWithSystemExit(1000, 2000, 5);
        if (years >= 0) {
            System.out.println(REQUIRED_NUMBER_OF_YEARS + years);
        } else {
            System.out.println(ARGUMENTS_SHOULD_BE_POSITIVE);
        }
    }

    /**
     * finds years needed to get required sum if start sum is put to a bank at a percentage rate
     * uses loop while... do
     * @param startSum      start sum
     * @param requiredSum   required sum
     * @param percentage    annual interest rate
     * @return              founded number of years or -1 if arguments are not valid (are not positive)
     */
    public int findTermWhileDoLoop(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        while (startSum < requiredSum) {
            startSum *= ratio;
            years++;
        }
        return years;
    }

    /**
     * finds years needed to get required sum if start sum is put to a bank at a percentage rate
     * uses loop do... while
     * @param startSum      start sum
     * @param requiredSum   required sum
     * @param percentage    annual interest rate
     * @return              founded number of years or -1 if arguments are not valid (are not positive)
     */
    public int findTermDoWhileLoop(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        if (startSum >= requiredSum) {
            return 0;
        }
        int years = 0;
        do {
            startSum *= ratio;
            years++;
        }
        while (startSum < requiredSum);
        return years;
    }

    /**
     * finds years needed to get required sum if start sum is put to a bank at a percentage rate
     * uses loop for...
     * @param startSum      start sum
     * @param requiredSum   required sum
     * @param percentage    annual interest rate
     * @return              founded number of years or -1 if arguments are not valid (are not positive)
     */
    public int findTermForLoop(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        for (double currentSum = startSum; currentSum < requiredSum; currentSum *= ratio, years++) {
        }
        return years;
    }

    public int findTermWhileDoLoopWithBreak(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        while (true) {
            if (startSum >= requiredSum) {
                break;
            }
            startSum *= ratio;
            years++;
        }
        return years;
    }

    public int findTermDoWhileLoopWithBreak(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        if (startSum >= requiredSum) {
            return 0;
        }
        int years = 0;
        do {
            startSum *= ratio;
            years++;
            if (startSum >= requiredSum) {
                break;
            }
        }
        while (true);
        return years;
    }

    public int findTermForLoopWithBreak(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        for (double currentSum = startSum; ; currentSum *= ratio) {
            if (currentSum >= requiredSum) {
                break;
            }
            years++;
        }
        return years;
    }

    public int findTermWhileDoLoopWithBreakAndLabel(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        label: while (true) {
            if (startSum >= requiredSum) {
                break label;
            }
            startSum *= ratio;
            years++;
        }
        return years;
    }

    public int findTermDoWhileLoopWithBreakAndLabel(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        if (startSum >= requiredSum) {
            return 0;
        }
        int years = 0;
        label: do {
            startSum *= ratio;
            years++;
            if (startSum >= requiredSum) {
                break label;
            }
        }
        while (true);
        return years;
    }

    public int findTermForLoopWithBreakAndLabel(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        label: for (double currentSum = startSum; ; currentSum *= ratio) {
            if (currentSum >= requiredSum) {
                break label;
            }
            years++;
        }
        return years;
    }

    public int findTermWhileDoLoopWithReturn(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        while (true) {
            if (startSum >= requiredSum) {
                return years;
            }
            startSum *= ratio;
            years++;
        }
    }

    public int findTermDoWhileLoopWithReturn(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        if (startSum >= requiredSum) {
            return 0;
        }
        int years = 0;
        do {
            startSum *= ratio;
            years++;
            if (startSum >= requiredSum) {
                return years;
            }
        }
        while (true);
    }

    public int findTermForLoopWithReturn(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        for (double currentSum = startSum; ; currentSum *= ratio) {
            if (currentSum >= requiredSum) {
                return years;
            }
            years++;
        }
    }

    public int findTermForLoopWithSystemExit(double startSum, double requiredSum, double percentage) {
        if (!argumentsAreValid(startSum, requiredSum, percentage)) {
            return NOT_VALID_ARGUMENTS;
        }
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        for (double currentSum = startSum; ; currentSum *= ratio) {
            if (currentSum >= requiredSum) {
                System.exit(years);
            }
            years++;
        }
    }

    private boolean argumentsAreValid(double startSum, double requiredSum, double percentage) {
        return (startSum > 0 && requiredSum > 0 && percentage > 0);
    }
}
