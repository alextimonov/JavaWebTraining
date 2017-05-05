package ua.epamkpi.timonov.tasks.task07_string;

public class Runner {

    public static final String DONG_DING_DONG = "Dong-ding-dong";
    public static final String DONG_DING_BANG = "Dong-ding-bang";
    public static final String DONG = "dong";
    public static final String BONG = "bong";

    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        StringImpl string = new StringImpl(DONG_DING_DONG);
        System.out.println("Number of letters: " + string.findNumberOfLetters());
        System.out.println("Compare with \"Dong-ding-dong\": " + string.compareIgnoreCase(DONG_DING_DONG));
        System.out.println("Compare with \"Dong-ding-bung\": " + string.compareIgnoreCase(DONG_DING_BANG));
        System.out.println("To upper case: " + string.toUpperCase());
        System.out.println("To lower case: " + string.toLowerCase());
        System.out.println("Indexes for \"dong\": " + string.findOccurIndexes(DONG));
        System.out.println("Replace \"dong\" to \"bong\": " + string.replace(DONG, BONG));
        System.out.println("Equal words: " + string.findEqualWords());

        System.out.println();

        string = new StringImpl("How do,you:do?I'm \"fine\"; and you? how are you?");
        System.out.println("Number of letters: " + string.findNumberOfLetters());
        System.out.println("Compare with \"Dong-ding-dong\": " + string.compareIgnoreCase(DONG_DING_DONG));
        System.out.println("Compare with \"Dong-ding-bung\": " + string.compareIgnoreCase(DONG_DING_BANG));
        System.out.println("To upper case: " + string.toUpperCase());
        System.out.println("To lower case: " + string.toLowerCase());
        System.out.println("Indexes for \"you\": " + string.findOccurIndexes("you"));
        System.out.println("Replace \"you\" to \"he\": " + string.replace("you", "he"));
        System.out.println("Equal words: " + string.findEqualWords());
    }
}
