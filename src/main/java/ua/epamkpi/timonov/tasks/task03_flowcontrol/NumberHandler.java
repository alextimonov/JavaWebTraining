package ua.epamkpi.timonov.tasks.task03_flowcontrol;

/**
 * Represents handling of inputted numbers to find their max, min & average values and their amount
 */
public class NumberHandler {

    public static final String NO_ARGUMENTS = "There is no arguments. Values can't be founded.";
    public static final String AMOUNT_OF_NUMBERS = "Amount of numbers = ";
    public static final String MIN_VALUE = "\nMin value = ";
    public static final String MAX_VALUE = "\nMax value = ";
    public static final String AVERAGE_VALUE = "\nAverage value = ";
    public static final String NUMBER_FORMAT_ERROR = "Number format error: ";

    /* array with double numbers to process */
    private double[] doubleNumbers;

    /* minimal value of received numbers */
    private double minValue;

    /* maximum value of received numbers */
    private double maxValue;

    /* average value of received numbers */
    private double averageValue;

    public static void main(String[] args) {
        try {
            new NumberHandler().run(args);
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * runs handling of inputted string numbers, prints founded max, min & average values and their amount
     * @param arguments     array of strings with numbers
     * throws               NumberFormatException if there is not a number in arguments
     *                      IllegalArgumentException if there is no arguments (empty array)
     */
    public void run(String[] arguments) {
        getNumbersFromStringArguments(arguments);
        processNumbers();
        System.out.println(buildAnswerOutput());
    }

    /**
     * converts array of strings with numbers to double numbers
     * @param arguments     array of strings with numbers
     * throws               NumberFormatException if there is not a number in arguments
     *                      IllegalArgumentException if there is no arguments (empty array)
     */
    public void getNumbersFromStringArguments(String[] arguments) {
        int amount = arguments.length;
        checkArgumentsAmount(amount);
        doubleNumbers = new double[amount];
        for (int i = 0; i < amount; i++) {
            doubleNumbers[i] = Double.valueOf(arguments[i]);
        }
    }

    /**
     * finds max, min & average values for array of numbers
     * throws               IllegalArgumentException if array with numbers is empty
     */
    public void processNumbers() {
        checkArgumentsAmount(doubleNumbers.length);
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
        averageValue = sum / doubleNumbers.length;
    }

    /**
     * builds string with founded values of founded max, min & average values and their amount
     * @return      constructed string
     */
    public String buildAnswerOutput() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(AMOUNT_OF_NUMBERS + doubleNumbers.length)
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

    public double[] getDoubleNumbers() {
        return doubleNumbers;
    }

    public void setDoubleNumbers(double[] doubleNumbers) {
        this.doubleNumbers = doubleNumbers;
    }
}
