package ua.epamkpi.timonov.tasks.task02;

public class NumberHandler {

    public static final String NO_ARGUMENTS = "There is no arguments. Values can't be founded.";
    public static final String AMOUNT_OF_NUMBERS = "Amount of numbers = ";
    public static final String MIN_VALUE = "\nMin value = ";
    public static final String MAX_VALUE = "\nMax value = ";
    public static final String AVERAGE_VALUE = "\nAverage value = ";

    private int amount;
    private double minValue;
    private double maxValue;
    private double averageValue;

    public static void main(String[] args) {
        try {
            new NumberHandler().run(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param arguments
     * throws               IllegalArgumentException if there is no arguments (empty array)
     *                      NumberFormatException if there is not a number in arguments
     */
    public void run(String[] arguments) {
        double[] doubleNumbers = getDoublesFromStringArguments(arguments);
        processNumbers(doubleNumbers);
        System.out.println(buildAnswerOutput());
    }

    public double[] getDoublesFromStringArguments(String[] arguments) {
        double[] doubleNumbers = new double[arguments.length];
        for (int i = 0; i < arguments.length; i++) {
            doubleNumbers[i] = Double.valueOf(arguments[i]);
        }
        return doubleNumbers;
    }

    public void processNumbers(double[] doubleNumbers) {
        checkArgumentsAmount(doubleNumbers.length);
        amount = doubleNumbers.length;
        minValue = doubleNumbers[0];
        maxValue = doubleNumbers[0];
        double sum = 0;
        for (double value : doubleNumbers) {
            if (minValue > value) {
                minValue = value;
            }
            if (maxValue < value) {
                maxValue = value;
            }
            sum += value;
        }
        averageValue = sum / amount;
    }

    public String buildAnswerOutput() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(AMOUNT_OF_NUMBERS + amount)
                .append(MIN_VALUE + minValue)
                .append(MAX_VALUE + maxValue)
                .append(AVERAGE_VALUE + averageValue);
        return sb.toString();
    }

    private void checkArgumentsAmount(int length) {
        if (length < 1) {
            throw new IllegalArgumentException(NO_ARGUMENTS);
        }
    }

    /* ==================== Getters & setters ================= */
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getAverageValue() {
        return averageValue;
    }

    public void setAverageValue(double averageValue) {
        this.averageValue = averageValue;
    }
}
