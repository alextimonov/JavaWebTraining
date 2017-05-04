package ua.epamkpi.timonov.tasks.task07;

public class Runner {

    public static final String DONG_DING_DONG = "Dong-ding-dong";

    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        StringTask stringTask = new StringTask(DONG_DING_DONG);
        System.out.println("Number of alphabet signs: " + stringTask.findNumberAlphabetSymbols());
        for (int i = 65; i < 122; i++) {
            System.out.println("Symbol with code " + i + " is " + (char) i);
        }
    }
}
