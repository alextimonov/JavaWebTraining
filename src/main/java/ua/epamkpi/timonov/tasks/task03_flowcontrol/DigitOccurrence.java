package ua.epamkpi.timonov.tasks.task03_flowcontrol;

/**
 * Represents search for amount of digit's occurrences in given number
 */
public class DigitOccurrence {

    public static final int RADIX = 10;
    public static final int NOT_DIGIT = -1;
    public static final String SHOULD_BE_DIGIT = "Digit should be in diapason 0..9 for 10-based number system";
    public static final String FOUNDED_AMOUNT_OF_DIGITS = "Founded amount of digits = ";

    public static void main(String[] args) {
        DigitOccurrence digitOccurrence = new DigitOccurrence();
        int number = 575_315;
        byte digit = 5;
        int amount = digitOccurrence.findAmountOfDigitOccurrences(number, digit);
        if (amount >= 0) {
            System.out.println(FOUNDED_AMOUNT_OF_DIGITS + amount);
        } else {
            System.out.println(SHOULD_BE_DIGIT);
        }
    }

    /**
     * finds amount of digit's occurrences in a number
     * @param number    number to check
     * @param digit     digit to find its occurrences
     * @return          amount of digit's occurrences or -1 if received value for digit is less than 0 or more than 9
     */
    public int findAmountOfDigitOccurrences(int number, byte digit) {
        if (!isDigit(digit)) {
            return NOT_DIGIT;
        }
        number = Math.abs(number);
        int amount = 0;
        do {
            if (number % RADIX == digit) {
                amount++;
            }
            number /= RADIX;
        }
        while (number != 0);
        return amount;
    }

    private boolean isDigit(byte digit) {
        return digit >= 0 && digit < RADIX;
    }
}
