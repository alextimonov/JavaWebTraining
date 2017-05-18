package ua.javaweb.timonov.tasks.task09_multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Barber {
    public static final int TIME_TO_CROP = 500;
    public static final long TIME_TO_SLEEP_TOO_LONG = 5_000;

    private Lock lock = new ReentrantLock();
    private boolean isSleeping;
    private long timeAsleep;

    public Barber(boolean isSleeping) {
        this.isSleeping = isSleeping;
        timeAsleep = System.currentTimeMillis();
    }

    public boolean isSleeping() {
        System.out.println("Barber is sleeping: " + isSleeping);
        return isSleeping;
    }

    public void crop(Client client) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("Barber starts to crop client #" + client.getId());
            Thread.sleep(TIME_TO_CROP);
            System.out.println("Barber ends to crop client #" + client.getId());
        } finally {
            lock.unlock();
        }
    }

    public void asleep() {
        System.out.println("Barber falls asleep");
        isSleeping = true;
        timeAsleep = System.currentTimeMillis();
    }

    public void wakeUp() {
        isSleeping = false;
    }

    public boolean isSleepingToLong() {
        return isSleeping && System.currentTimeMillis() - timeAsleep > TIME_TO_SLEEP_TOO_LONG;
    }
}
