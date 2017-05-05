package ua.javaweb.timonov.lessons.lesson02;

public class Lesson02 {
    public static void main(String[] args) {
        new Lesson02().run();
    }

    private void run() {
        long i = 12;
        Long a = i;
        Long b = new Long(i);
        System.out.println("a == i : " + (a == i));
        System.out.println("b == i : " + (b == i));
        System.out.println("a == b : " + (a == b));
        System.out.println("a equals b : " + a.equals(b));

        P p = new P();
        P pq = new Q();
        Q q = new Q();
        System.out.println(p instanceof P);
        System.out.println(p instanceof Q);
        System.out.println(pq instanceof P);
        System.out.println(pq instanceof Q);
        System.out.println(q instanceof Q);
        System.out.println(q instanceof P);
//        System.out.println(p instanceof R); // inconvertible types
//        System.out.println(p instanceof null); // compilation error

        Float floatNumber = 2.71F;
        double doubleValue = floatNumber.doubleValue();
        
    }
}

class P {}

class Q extends P {}

class R {}