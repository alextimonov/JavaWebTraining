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
        int p = 10_00_0;
        int b = 0b01_10_100;
        double b1 = 4e-2;
        int i1 = 123456;
        long L1 = (long) i1;
        short s2 = (short) i1;
        byte b2 = (byte) i1;
        int i2 = (int) 123.456;
//        byte b3 = b1 + 7; // compilation error
    }
}
