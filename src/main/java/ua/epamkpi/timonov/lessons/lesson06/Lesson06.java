package ua.epamkpi.timonov.lessons.lesson06;

public class Lesson06 {

    interface A {
        Number calc();
    }

    interface B extends A {
        Double calc();
    }

    public static void main(String[] args) {
        new Lesson06().run();
    }

    private void run() {

    }
}
