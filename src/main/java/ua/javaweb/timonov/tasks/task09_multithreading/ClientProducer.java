package ua.javaweb.timonov.tasks.task09_multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ClientProducer implements Runnable {

    public static final int MAX_CLIENTS = 15;
    public static final int MAX_INTERVAL = 1_450;
    private final BlockingQueue<Client> queue;

    public ClientProducer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < MAX_CLIENTS; i++) {
            Client client = new Client(i);
            try {
                Thread.sleep((long) (random.nextDouble() * MAX_INTERVAL));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            client.comeToBarbershop();
            if (queue.offer(client)) {
                client.sitIntoQueue(queue.remainingCapacity());
            } else {
                client.goAwayUnshorn();
            }

        }
    }
}
