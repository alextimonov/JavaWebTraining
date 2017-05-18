package ua.javaweb.timonov.tasks.task09_multithreading;

public class Client {

    private int id;

    public Client(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void comeToBarbershop() {
        System.out.println("Client #" + id + " comes to barbershop");
    }

    public void sitIntoQueue(int placesRemaining) {
        System.out.println("Client #" + id + " sits into the queue, " + placesRemaining + " places remaining in the queue");
    }

    void goCroppedAndLucky() {
        System.out.println("Client #" + id + " goes away cropped and lucky");
    }

    public void goAwayUnshorn() {
        System.out.println("Client #" + id + " goes away unshorn");
    }

    public void wakeUp(Barber barber) {
        System.out.println("Client #" + id + " wakes up barber");
        barber.wakeUp();
    }
}
