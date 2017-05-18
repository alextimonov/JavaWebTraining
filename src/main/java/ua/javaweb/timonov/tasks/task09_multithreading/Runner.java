package ua.javaweb.timonov.tasks.task09_multithreading;

public class Runner {
    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {
        Barbershop barbershop = new Barbershop(5);
        ClientProducer clientProducer = new ClientProducer(barbershop.getQueue());

        new Thread(clientProducer).start();
        new Thread(barbershop).start();
    }
}
