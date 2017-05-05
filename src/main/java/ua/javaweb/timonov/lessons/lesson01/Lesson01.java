package ua.javaweb.timonov.lessons.lesson01;

public class Lesson01 {
    public static void main(String[] args) {
        new Lesson01().run();
    }

    private void run() {
        byte x = (byte) 129;
        System.out.println("x = " + x);

        final byte B = 7;
        byte b = 7;
        byte b1 = B + 1;
        byte b2 = (byte) (b + 1);
    }
}
