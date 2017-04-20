package ua.epamkpi.timonov.tasks.task02;

public class BankPercentages {

    public static final int HUNDRED = 100;
    public static final String REQUIRED_NUMBER_OF_YEARS = "Required number of years: ";
    public static final String ARGUMENTS_SHOULD_BE_POSITIVE = "Arguments should be positive";

    public static void main(String[] args) {
        try {
            new BankPercentages().run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void run() {
        int years = findTermForLoopWithSystemExit(1000, 2000, 5);
        System.out.println(REQUIRED_NUMBER_OF_YEARS + years);
    }

    public int findTermWhileDoLoop(double startSum, double requiredSum, double percentage) {
        checkArguments(startSum, requiredSum, percentage);
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        while (startSum < requiredSum) {
            startSum *= ratio;
            years++;
        }
        return years;
    }

    public int findTermDoWhileLoop(double startSum, double requiredSum, double percentage) {
        checkArguments(startSum, requiredSum, percentage);
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

    public int findTermForLoop(double startSum, double requiredSum, double percentage) {
        checkArguments(startSum, requiredSum, percentage);
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        for (double currentSum = startSum; currentSum < requiredSum; currentSum *= ratio, years++) {
        }
        return years;
    }

    public int findTermWhileDoLoopWithBreak(double startSum, double requiredSum, double percentage) {
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
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
        checkArguments(startSum, requiredSum, percentage);
        double ratio = (percentage + HUNDRED) / HUNDRED;
        int years = 0;
        for (double currentSum = startSum; ; currentSum *= ratio) {
            if (currentSum >= requiredSum) {
                System.exit(years);
            }
            years++;
        }
    }

    private void checkArguments(double startSum, double requiredSum, double percentage) {
        if (startSum <= 0 || requiredSum <= 0 || percentage <= 0) {
            throw new IllegalArgumentException(ARGUMENTS_SHOULD_BE_POSITIVE);
        }
    }
}
