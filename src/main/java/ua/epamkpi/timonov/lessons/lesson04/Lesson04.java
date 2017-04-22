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

    static final void calc6() {}

    private static void calc7() {}
    protected static void calc8() {}
    public static void calc9() {}

    private final void calc10() {}
    protected final void calc11() {}
    public final void calc12() {}

}

abstract class Try {
    // abstract final void calc1();
    // abstract static void calc3();
    // abstract private void calc2();
    abstract protected void calc4();
    abstract public void calc5();
}
