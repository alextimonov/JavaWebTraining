package ua.epamkpi.timonov.lessons.lesson04;

public class Lesson04 {
    public static void main(String[] args) {
        new Lesson04().run();
        String s = "hello";
        int[] a = {1, 2, 3};
        System.out.println(s + a);
        System.out.println(a);

        byte b = 7;

    }

    private void run() {
        val(5);
    }

    private void val(int k) {
        System.out.println("k");
    }

    private void val(Integer k) {
        System.out.println("K");
    }
}
