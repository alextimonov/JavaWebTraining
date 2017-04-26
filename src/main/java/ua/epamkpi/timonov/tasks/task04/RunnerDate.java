package ua.epamkpi.timonov.tasks.task04;

public class RunnerDate {
    public static void main(String[] args) {
        new RunnerDate().run();
    }

    private void run() {
        Date date1 = new Date(2017, 4, 26);
        Date date2 = new Date();
        date2.inputDateFromConsole();
        date1.printToConsole();
        date2.printToConsole();
    }
}
