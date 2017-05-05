package ua.epamkpi.timonov.tasks.task06_anonymous;

public class Runner {
    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        System.out.println("Invoke from external to local, start & stop");
        AirPlainAnonymous airPlainAnonimous = new AirPlainAnonymous();
        System.out.println(airPlainAnonimous.airPlainStart());
        System.out.println(airPlainAnonimous.airPlainStop());
    }
}
