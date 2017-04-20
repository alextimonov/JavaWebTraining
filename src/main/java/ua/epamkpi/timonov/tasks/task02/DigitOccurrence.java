package ua.epamkpi.timonov.tasks.task02;

public class DigitOccurrence {

    public static final int RADIX = 10;
    public static final String MUST_BE_DIGIT = "Digit must be in diapason 0..9!";
    public static final String FOUNDED_AMOUNT_OF_DIGITS = "Founded amount of digits = ";

    public static void main(String[] args) {
        DigitOccurrence digitOccurrence = new DigitOccurrence();
        try {
            int amount = digitOccurrence.findAmountOfDigitOccurrences(575_315, 5);
            System.out.println(FOUNDED_AMOUNT_OF_DIGITS + amount);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * finds amount of digit's occurrences in a number
     * @param number    number to check
     * @param digit     digit to find its occurrences
     * @return          amount of digit's occurrences
     * throws           IllegalArgumentException if received digit's value is not a digit (is less than 0 or more than 9)
     */
    public int findAmountOfDigitOccurrences(int number, int digit) {
        checkArgumentDigit(digit);
        number = Math.abs(number);
        int amount = 0;
        do {
            if (number % RADIX == digit) {
                amount++;
            }
            number /= RADIX;
        }
        while (number > 0);
        return amount;
    }

    private void checkArgumentDigit(int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException(MUST_BE_DIGIT);
        }
    }
}
