package ua.javaweb.timonov.tasks.task09_multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Barbershop implements Runnable {
    private final int numberPlaces;
    private final BlockingQueue<Client> queue;
    private Barber barber = new Barber(true);

    public Barbershop(int numberPlaces) {
        this.numberPlaces = numberPlaces;
        this.queue = new LinkedBlockingQueue<>(numberPlaces);
    }

    public BlockingQueue<Client> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        try {
            while (!barber.isSleepingToLong()) {
                Client client = queue.poll();
                if (client != null) {
                    if (barber.isSleeping()) {
                        client.wakeUp(barber);
                    }
                    outputRemainingCapacityInQueue();
                    barber.crop(client);
                    client.goCroppedAndLucky();
                } else {
                    if (!barber.isSleeping()) {
                        barber.asleep();
                    }
                }
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void outputRemainingCapacityInQueue() {
        System.out.println(queue.remainingCapacity() + " places remaining in the queue");
    }
}
