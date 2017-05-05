package ua.epamkpi.timonov.tasks.task08_exceptions;

class Node {
    private Node node = new Node();
}

public class SOEModulation {

    public void createNode() {
        new Node();
    }

    public long fibonacci(int value) {
        if (value <= 2) {
            return 1;
        }
        return fibonacci(value - 1) + fibonacci(value - 2);
    }

    public long factorial(int value) {
        if (value <= 1) {
            return 1;
        }
        return value * factorial(value - 1);
    }
}
